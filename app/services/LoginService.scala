package services

import cats.data.Reader
import models.User
import repositories.{Repository, UserRepository}

trait LoginService[F[_],DbEffect[_]] extends Service[User,F,DbEffect]{

  /** Check the credential of an User
   * @return true if the credential are valid false otherwise */
  def checkCredential(user:User):Reader[UserRepository[DbEffect],F[Boolean]]= {
    Reader { repo: UserRepository[DbEffect] => evalDb(repo.exist(user)) }
  }

  override def create(something: User): Reader[Repository[User, DbEffect], F[User]] = {
    Reader{repo:Repository[User,DbEffect]=> evalDb(repo.insert(something))}
  }

  override def listAll: Reader[Repository[User, DbEffect], F[Seq[User]]] = {
    Reader{repo:Repository[User,DbEffect]=>evalDb(repo.getAll)}
  }

}


