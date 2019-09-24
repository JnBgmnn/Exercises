/**
  * Created by Jan on 23.07.2019.
  */
object FunctionExercise {

  def main(args: Array[String]): Unit = {
    println(f1(-7));
    println(f2(-1));
    println(f3(3)(5));
    println(f4(4, 5));
    println(List(5, 3, 6, 7, 8):::(3::(5::7::78::22::Nil)));
    println(f5(List(3)));
  }

  /** f1: Dreht das Vorzeichen einer Zahl n um */
  def f1: Int => Int = {
    n => -n;
  }

  /** f2: Addiert zu einer nicht-negativen Zahl 10 bzw. subtrahiert 2 von einer negativen Zahl */
  def f2: Int => Int = {
    case n => if (n < 0) n - 2
              else n + 10;
  }

  /** f3: Wandelt die beiden Parameter n und m in einen Tupel (m, n) */
  def f3: Int => Int => (Int, Int) = {
    n => m => (m, n)
  }

  /** f4: Wandelt den Tupel (n, m) in einen Tupel (m, n) um*/
  def f4: (Int, Int) => (Int, Int) = {
    (n, m) => (m, n);
  }

  /** f5: */
  def f5: List[Int] => Int = {
    case h::q::ts => h * 5 * q;
    case _ => -1
  }

}
