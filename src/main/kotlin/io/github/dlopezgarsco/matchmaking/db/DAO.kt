package io.github.dlopezgarsco.matchmaking.db

import arrow.core.Either
import arrow.core.Either.Left
import arrow.core.Either.Right
import arrow.core.None
import arrow.core.Some
import arrow.core.firstOrNone
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll


interface DAO<A, T : IdTable<C>, C : Comparable<C>> {
  suspend fun get(id: C): Either<DAOError, A> {
    val row = dbQuery {
      table().select { (table().id eq id) }
    }.firstOrNone()
    return when (row) {
      is None -> Left(DAOError.RecordDoesntExist)
      is Some -> Right(row.value.toPOJO())
    }
  }

  suspend fun get(a: A): Either<DAOError, A>

  suspend fun getAll(): List<A> = dbQuery {
    table().selectAll().map { it.toPOJO() }
  }

  suspend fun create(data: A): Either<DAOError, C>
  suspend fun update(data: A): Boolean
  suspend fun delete(id: Int): Boolean
  suspend fun delete(data: A): Boolean
  suspend fun ResultRow.toPOJO(): A

  fun table(): T
}

sealed class DAOError {

  object InaccessibleDatabase : Exception()
  data object RecordDoesntExist : DAOError()
  data object RecordAlreadyExists : DAOError()

}