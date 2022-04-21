object Main extends App:

  import pure.*

  def a1(m: Int, n: Int): Pure[Int] =
    if      (m == 0) done(n + 1)
    else if (n == 0) call(a1(m - 1, 1))
    else for {
      inner <- call(a1(m, n - 1))
      outer <- call(a1(m - 1, inner))
    } yield outer

  // println(a1(4,1).compute)