package repositories.database

import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

trait UserDatabase extends SlickDatabaseConfiguration {

  /** name for the database to use */
  val dbName: String = "slick.dbs.user"
  /** load the database with configuration name DbName */
  val localDb: DatabaseConfig[JdbcProfile] =DatabaseConfig.forConfig[JdbcProfile](dbName,config)
  val databaseProfile:JdbcProfile=localDb.profile
}

object UserDatabase extends UserDatabase
