package repositories
/** Define the repository type.
 * @tparam Something the type of ooject the repository handles
 * @tparal F the repository effect wrapper*/
trait Repository[Something,F[_]] {

  /** insert the record */
  def insert(something: Something):F[Something]
  /** get all the elements in the repository  */
  def getAll: F[Seq[Something]]

}
