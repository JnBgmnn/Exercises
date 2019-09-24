/**
  * Created by Jan on 23.07.2019.
  */
object Recursion {

  def main(args: Array[String]): Unit = {
//    println(myConcat(List.range(0, 6), List.range(6, 11)));
    println(mySum(List.range(0, 6)));
  }

  def myLength: List[Any] => Int = {
    case Nil => 0;
    case p::ps => 1 + myLength(ps);
  }

  def myConcat: (List[Any], List[Any]) => List[Any] = {
    case (Nil, Nil) => Nil;
    case (p::ps, os) => p::myConcat(ps, os);
    case (ps, o::os) => o::myConcat(ps, os);
  }

  def mySum: List[Int] => Int = {
    case Nil => 0;
    case p::ps => p + mySum(ps);
  }
}
