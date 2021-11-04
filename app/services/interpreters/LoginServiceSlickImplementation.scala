package services.interpreters

import cats.~>
import repositories.database.UserDatabase
import services.LoginService
import slick.dbio.DBIO

import scala.concurrent.Future

trait LoginServiceSlickImplementation extends LoginService[Future,DBIO] with UserDatabase {
  /** convert a value of  the Slick type DBIO[_] to a Future[_].  */
  override val evalDb: DBIO ~> Future = new  (DBIO ~> Future) {
    override def apply[A](fa: DBIO[A]): Future[A] = localDb.db.run(fa)
  }
}

object LoginServiceSlickImplementation extends LoginServiceSlickImplementation




