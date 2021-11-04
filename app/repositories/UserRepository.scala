package repositories

import models.User
/** Defines the repository type for Users .
 * @tparal F the repository effect wrapper*/
trait UserRepository[F[_]] extends Repository[User,F] {
  def exist(user:User):F[Boolean]

}
