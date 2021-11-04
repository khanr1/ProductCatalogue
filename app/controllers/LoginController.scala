package controllers

import models._
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc._
import repositories.interpreters._
import services.interpreters.LoginServiceSlickImplementation
import services.interpreters.LoginServiceSlickImplementation.{checkCredential,create}

import javax.inject._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's login page.
 */
@Singleton
class LoginController @Inject()(val cc: ControllerComponents) extends AbstractController(cc) {
  /** displays the Login page */
  def login = Action { implicit request =>
    Ok(views.html.login())
  }


  def checkInUser = Action.async{ implicit request =>

    request.body.asJson.map(x => Json.fromJson[User](x) match {
      case JsSuccess(user, path) =>{
        val futureBoolean:Future[Boolean]=checkCredential(user)(UserRepositorySlickImplementation)

        println(futureBoolean)
        futureBoolean.map(b=>Ok(Json.toJson(b)))
      }
      case JsError(e) => Future.successful(Ok(Json.toJson(false)))
    }).getOrElse(Future.successful(Redirect(routes.LoginController.login)))
  }

  def registerUser= Action.async{request=>
    request.body.asJson.map(x=>Json.fromJson[User](x) match{
      case JsSuccess(user,path)=> {
        val futureUser:Future[User]=create(user)(UserRepositorySlickImplementation)
        futureUser.map(u=>Ok(Json.toJson[User](u)))
      }
      case JsError(e) => Future.successful(Ok(Json.toJson("not parsed")) )
    }).getOrElse(Future.successful(Ok(Json.toJson("not parsed")) ))
  }

}