object Main extends App:

  def a1(m: Int, n: Int): Int =
    if      (m == 0) n + 1
    else if (n == 0) a1(m - 1, 1)
    else             a1(m - 1, a1(m, n - 1))

  def a2(m: Int, n: Int): Int =
    (m, n) match
      case (0, _) => n + 1
      case (_, 0) => a2(m - 1, 1)
      case (_, _) => a2(m - 1, a2(m , n - 1))

  println(a1(4,1))