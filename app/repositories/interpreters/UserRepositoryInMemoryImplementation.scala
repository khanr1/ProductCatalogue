package repositories.interpreters

import cats.Id
import models.User
import repositories.UserRepository
import collection.mutable

trait UserRepositoryInMemoryImplementation extends UserRepository[Id] {

  private var users:Set[User]=Set(
    User("Raphael","pass")
  )

  override def exist(user: User): Id[Boolean] = users.contains(User(user.username,user.password))

  /** insert the record */
  override def insert(something: User): Id[User] = {
    users=users+something
    something
  }

  /** get all the elements in the repository */
  override def getAll: Id[Seq[User]] = users.toList


}

object UserRepositoryInMemoryImplementation extends UserRepositoryInMemoryImplementation {
}
