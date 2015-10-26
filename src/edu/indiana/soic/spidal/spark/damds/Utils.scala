package edu.indiana.soic.spidal.spark.damds

/**
 * Created by pulasthiiu on 10/26/15.
 */
class Utils {
  def printAndThrowRuntimeException(e: RuntimeException) {
    e.printStackTrace(System.out)
    throw e
  }

  def printAndThrowRuntimeException(message: String) {
    System.out.println(message)
    throw new RuntimeException(message)
  }

  def printMessage(msg: String) {
    System.out.println(msg)
  }
}
