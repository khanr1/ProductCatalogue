package services

import cats.data.Reader
import cats.~>
import repositories.Repository

/** Service trait  defines the the minimum function any services should
 * implements
 * @tparam Something the type the service is made for
 * @tparam F the service  effect wrapper for example a Future
 * @tparam DbEffect the Repository  effect wrapper for example Future or DBIO for slick base repository*/
trait Service[Something,F[_],DbEffect[_]] {
  /** convert a value of one generic type DbEffect[_] to another generic type F[_].  */
  def evalDb:DbEffect~>F
  /** Create an entity */
  def create(something: Something):Reader[Repository[Something,DbEffect],F[Something]]
  /** List all the entities that exist */
  def listAll: Reader[Repository[Something,DbEffect],F[Seq[Something]]]


}
