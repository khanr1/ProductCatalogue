package models

import models.helpers.ID
import play.api.libs.json.Json

case class User(username:String,password:String,id:ID[User]=ID[User](0L)){

}

object User{
  /** JSon serializer for User */
  implicit val UserFormat=Json.using[Json.WithDefaultValues].format[User]
}
