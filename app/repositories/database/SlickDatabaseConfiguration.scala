package repositories.database

import com.typesafe.config.{Config, ConfigFactory}

/**  configuration of a database*/
trait SlickDatabaseConfiguration {
  /** load the configuration */
  val config: Config = ConfigFactory.load()

}
