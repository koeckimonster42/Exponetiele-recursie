package pure

import scala.annotation.tailrec

sealed trait Pure[A]:
  
  @tailrec
  final def compute: A =
    this match
      case Done(a) => a
      case Call(t) => t().compute
      case Cont(p,f) => p match
        case Done(a) => f(a).compute
        case Call(t) => t().flatMap(f).compute
        case Cont(pp,ff) => pp.flatMap(a => ff(a).flatMap(f)).compute

  final def flatMap[B](f: A => Pure[B]): Pure[B] =
    this match
      case Done(a)       => Call(() => f(a))
      case c: Call[A]    => Cont(c, f)
      case c: Cont[a1,_] => c.p.flatMap((a: a1) => c.f(a).flatMap(f))

  final def map[B](f: A => B): Pure[B] =
    flatMap(a => Done(f(a)))

case class Done[A](a: A)                          extends Pure[A]
case class Call[A](t: () => Pure[A])              extends Pure[A]
case class Cont[A,B](p: Pure[A], f: A => Pure[B]) extends Pure[B]

def done[A](a: => A): Pure[A] = Done(a)
def call[A](p: => Pure[A]): Pure[A] = Call(() => p)
