package services.interpreters

import cats.{Id, ~>}
import services.LoginService
import slick.dbio.DBIO

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait LoginServiceInMemoryImplementation extends LoginService[Future,Id] {

  override val evalDb: Id ~> Future = new  (Id ~> Future) {
    override def apply[A](fa: Id[A]): Future[A] = Future(fa)
  }

}

object LoginServiceInMemoryImplementation extends LoginServiceInMemoryImplementation
