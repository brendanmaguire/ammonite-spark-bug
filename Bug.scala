import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.sql.SQLContext

object Bug {
  val conf = new SparkConf().setMaster("local[*]").setAppName("bxm")
  val sc = new SparkContext(conf)
  val sqlContext = new SQLContext(sc)

  val df = sqlContext.read.json("data.json")
  
  df.foreachPartition{records =>
    records.foreach(record => println(s"Record: $record"))
  }
}
