import edu.luc.etl.osdi.processtree.scala.common.ProcessTree
import scala.collection.immutable

object Usemap {

  val trees: ProcessTree = Forcomp.buildTree(Iterator((1, 2, "string")))
  val keys: immutable.Iterable[Int] = trees.map(_._1)
  val values: immutable.Iterable[collection.Seq[(Int, Int, String)]] =
    trees.map(_._2)
  val doubleKeys: immutable.Iterable[Int] = trees.map(_._1 * 2)

}
