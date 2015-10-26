package edu.indiana.soic.spidal.spark.configurations

import edu.indiana.soic.spidal.spark.configurations.section.DAMDSSection

/**
 * Created by pulasthiiu on 10/26/15.
 */
class ConfigurationMgr (filePath: String) {
  var configurationFilePath: String = filePath;
  var damdsSection: DAMDSSection = new DAMDSSection(configurationFilePath)

  def LoadConfiguration(configurationFilePath: String): ConfigurationMgr = {
    return new ConfigurationMgr(configurationFilePath)
  }
}
