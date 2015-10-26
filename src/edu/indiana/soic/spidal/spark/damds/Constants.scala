package edu.indiana.soic.spidal.spark.damds

/**
 * Created by pulasthiiu on 10/26/15.
 */
object Constants {
  final val ProgramName: String = "SPARKDAMDS";

  final val CmdOptionShortC: Char = 'c';
  final val CmdOptionLongC: String = "configFile";
  final val CmdOptionDescriptionC: String = "Configuration file";
  final val CmdOptionShortN: Char = 'n';
  final val CmdOptionLongN: String = "nodeCount";
  final val CmdOptionDescriptionN: String = "Node count";
  final val CmdOptionShortT: Char = 't';
  final val CmdOptionLongT: String = "threadCount";
  final val CmdOptionDescriptionT: String = "Thread count";

  final val ErrProgramArgumentsParsingFailed: String = "Argument parsing failed!";
  final val ErrInvalidProgramArguments: String = "Invalid program arguments!";
  final val ErrEmptyFileName: String = "File name is null or empty!";

  def errWrongNumOfBytesSkipped(requestedBytesToSkip: Int, numSkippedBytes: Int): String = {
    val msg: String = "Requested %1$d bytes to skip, but could skip only %2$d bytes"
    return String.format(msg, requestedBytesToSkip, numSkippedBytes)
  }

}