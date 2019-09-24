/**
  * Created by Jan on 24.07.2019.
  */
object Currying {

  def main(args: Array[String]): Unit = {
//    println(curry((5)(2))(3));
  }

  def curry: ((Int, Int) => Int) => (Int => Int => Int) =
    f => x => y => f(x, y)

  def uncurry: (Int => Int => Int) => ((Int, Int) => Int) =
    f => (x, y) => f(x)(y)


}
