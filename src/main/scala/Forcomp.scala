import edu.luc.etl.osdi.processtree.scala.common
import edu.luc.etl.osdi.processtree.scala.common.{Process, ProcessTree}

object Forcomp extends common.TreeBuilder {
  override def buildTree(processes: Iterator[Process]): ProcessTree = {

    val maps = for (prcs <- processes) yield {
      Map(prcs._2 -> prcs)
    }

    val grouped = for (key <- maps.flatten.map(_._1)) yield {
      maps.flatten.toList.filter(_._1 == key)
    }

    grouped.map(x => (x.head._1, x.map(_._2))).toMap
  }
}
