import scala.util.*
import org.scalatest.flatspec.*

class MainSpec extends AnyFlatSpec:

  behavior of "a1"

  it should "compute a1(4,1)" in
    Try(Main.a1(4,1)).isSuccess
  