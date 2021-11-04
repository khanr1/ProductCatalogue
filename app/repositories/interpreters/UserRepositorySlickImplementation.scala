package repositories.interpreters

import models.User
import models.helpers.ID
import repositories.UserRepository
import repositories.database.UserDatabase
import slick.dbio.DBIO

trait UserRepositorySlickImplementation extends UserRepository[DBIO] with UserDatabase{
  import databaseProfile.api._

  private class Users(tag:Tag) extends Table[User](tag,"USERS"){
    def username=column[String]("USERNAME")
    def password=column[String]("PASSWORD")
    def id= column[ID[User]]("ID",O.AutoInc,O.PrimaryKey)

    def * =(username,password,id)<> ((User.apply _).tupled, User.unapply)

  }

  private val UserTable=TableQuery[Users]

  override def insert(user: User): databaseProfile.api.DBIO[User] = {
    val username: String = user.username
    val password: String = user.password
    val userReturningRow = UserTable returning UserTable.map(_.id) into { (user, id) => user.copy(id = id) }
    userReturningRow += User(username, password)
  }

  override def getAll:databaseProfile.api.DBIO[Seq[User]] = UserTable.result

  override def exist(user: User): databaseProfile.api.DBIO[Boolean] = {
    val username: String = user.username
    val password: String = user.password
    UserTable.filter(u => (u.username===username &&u.password===password)).exists.result
  }
}

object UserRepositorySlickImplementation extends UserRepositorySlickImplementation