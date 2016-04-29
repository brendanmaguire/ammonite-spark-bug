# Ammonite & Spark interop bug

This repository provides the environment to reproduce lihaoyi/Ammonite#382 .

The issue does not occur if the code is called through the object:

```
sbt console

Bug
```

but it does occur if the code is run directly within the session:

```
sbt console

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.sql.SQLContext

val conf = new SparkConf().setMaster("local[*]").setAppName("bxm")
val sc = new SparkContext(conf)
val sqlContext = new SQLContext(sc)

val df = sqlContext.read.json("data.json")

df.foreachPartition{records =>
  records.foreach(record => println(s"Record: $record"))
}
```
