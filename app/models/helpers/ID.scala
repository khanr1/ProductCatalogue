package models.helpers

import play.api.libs.json.Json
import slick.lifted.MappedTo

/** ID is a value class to model  primary key in the application side and
 * avoid stupid mistake when using simple Longs to model primary key such as
 * trying to look up a user by primary key using the primary key from something else*/
case class ID[A](value: Long) extends AnyVal with MappedTo[Long]

object ID{
  /** JSon serializer for ID */
  implicit def IDFormat[A]=Json.format[ID[A]]
}
