val sqlContext = new org.apache.spark.sql.SQLContext(sc)
import sqlContext.implicits._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window
val utv = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/utV_.csv")
val ships = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/Ships_.csv")
val income = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/Income_.csv")
val trip = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/Trip_.csv")
val product = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/product_.csv")
val pass_in_trip = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/Pass_in_trip_.csv")
val outcome_o = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/Outcome_o_.csv")
val income_o = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/Income_o_.csv")
val outcomes = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/Outcomes_.csv")
val utq = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/utQ_.csv")
val battles = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/Battles_.csv")
val utb = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/utB_.csv")
val company = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/Company_.csv")
val outcome = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/Outcome_.csv")
val printer = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/printer_.csv")
val pc = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/pc_.csv")
val classes = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/Classes_.csv")
val passenger = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/Passenger_.csv")
val laptop = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").option("delimiter", ",").load("/home/fziv/tables/laptop_.csv")
    