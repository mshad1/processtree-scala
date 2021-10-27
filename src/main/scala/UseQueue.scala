import edu.luc.etl.osdi.processtree.scala.common.ProcessTree
import scala.collection.immutable
import scala.util.Random

object UseQueue {
  val length = 5
  val iter: Iterator[(Int, Int, String)] =
    Iterator
      .continually(
        (1, 2, Random.alphanumeric.take(1).mkString)
      )
      .take(length)

  val trees: ProcessTree =
    Forcomp.buildTree(iter)

  val stringsInTrees: immutable.Iterable[String] = trees.scanLeft("") {
    (acc, tree) =>
      acc + " " + tree._2.map(v => v._3).mkString(" ")
  }

  val lengths: immutable.Iterable[Int] = trees
    .scanLeft(List.empty[Int]) { (acc, tree) =>
      acc :+ tree._2.map(v => v._3.length).max
    }
    .flatten
}