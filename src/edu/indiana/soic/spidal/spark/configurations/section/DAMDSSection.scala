package edu.indiana.soic.spidal.spark.configurations.section

import java.io._;
import java.util.Properties
import java.util.stream.IntStream


/**
 * Created by pulasthiiu on 10/26/15.
 */
class DAMDSSection (configurationFilePath: String){

  var distanceMatrixFile: String = null
  var weightMatrixFile: String = null
  var labelFile: String = null
  var initialPointsFile: String = null
  var pointsFile: String = null
  var timingFile: String = null
  var summaryFile: String = null
  var numberDataPoints: Int = 0
  var targetDimension: Int = 0
  var distanceTransform: Double = .0
  var threshold: Double = .0
  var alpha: Double = .0
  var tMinFactor: Double = .0
  var stressIter: Int = 0
  var cgIter: Int = 0
  var cgErrorThreshold: Double = .0
  var isSammon: Boolean = false
  var blockSize: Int = 0
  var isBigEndian: Boolean = false
  var isMemoryMapped: Boolean = false

  val p: Properties = new Properties

  try {
    p.load(new FileInputStream(configurationFilePath))
    distanceMatrixFile = getProperty(p, "DistanceMatrixFile", "distance.bin")
    weightMatrixFile = getProperty(p, "WeightMatrixFile", "weights.bin")
    labelFile = getProperty(p, "LabelFile", "labels.txt")
    initialPointsFile = getProperty(p, "InitialPointsFile", "init.txt")
    pointsFile = getProperty(p, "PointsFile", "points.txt")
    timingFile = getProperty(p, "TimingFile", "timings.txt")
    summaryFile = getProperty(p, "SummaryFile", "summary.txt")
    numberDataPoints = getProperty(p, "NumberDataPoints", "-1").toInt
    targetDimension = getProperty(p, "TargetDimension", "3").toInt
    distanceTransform = getProperty(p, "DistanceTransform", "1.0").toDouble
    threshold = getProperty(p, "Threshold", "0.000001").toDouble
    alpha = getProperty(p, "Alpha", "0.95").toDouble
    tMinFactor = getProperty(p, "TminFactor", "0.5").toDouble
    stressIter = getProperty(p, "StressIterations", "10000").toInt
    cgIter = getProperty(p, "CGIterations", "20").toInt
    cgErrorThreshold = getProperty(p, "CGErrorThreshold", "1").toDouble
    isSammon = getProperty(p, "IsSammon", "false").toBoolean;
    blockSize = getProperty(p, "BlockSize", "64").toInt
    isBigEndian = getProperty(p, "IsBigEndian", "false").toBoolean;
    isMemoryMapped = getProperty(p, "IsMemoryMapped", "true").toBoolean;
  }
  catch {
    case e: IOException => {
      throw new RuntimeException("IO exception occurred while reading configuration properties file", e)
    }
  }

  private def getProperty(p: Properties, name: String, definition: String): String = {
    var value: String = System.getProperty(name)
    if (value == null) {
      if (definition != null) {
        value = p.getProperty(name, definition)
      }
      else {
        value = p.getProperty(name)
      }
    }
    return value
  }

  private def getPadding(count: Int, prefix: String): String = {
    val sb: StringBuilder = new StringBuilder(prefix)
    //TODO Need to check if correct
    (0 to count).foreach(sb.append(' '));
    return sb.toString
  }

  def toString(centerAligned: Boolean): Unit ={
    val params: Array[String] = Array("DistanceMatrixFile",
                                      "WeightMatrixFile",
                                      "Label Data File",
                                      "Initial Points File",
                                      "PointsFile",
                                      "TimingFile",
                                      "SummaryFile",
                                      "NumberDataPoints",
                                      "The Target Dimension",
                                      "Distance Transform (double)",
                                      "Threshold value",
                                      "Cooling parameter (alpha)",
                                      "TminFactor",
                                      "Stress Iterations",
                                      "CG Iterations",
                                      "CG Threshold",
                                      "Sammon mapping (boolean) ",
                                      "Block Size",
                                      "BigEndian (boolean)",
                                      "Memory mapped (boolean)")

    val args: Array[Any] = Array(distanceMatrixFile,
                                  weightMatrixFile,
                                  labelFile,
                                  initialPointsFile,
                                  pointsFile,
                                  timingFile,
                                  summaryFile,
                                  numberDataPoints,
                                  targetDimension,
                                  distanceTransform,
                                  threshold,
                                  alpha,
                                  tMinFactor,
                                  stressIter,
                                  cgIter,
                                  cgErrorThreshold,
                                  isSammon,
                                  blockSize,
                                  isBigEndian,
                                  isMemoryMapped)

    params.maxBy(_.length)
  }
}
