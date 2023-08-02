package io.github.dlopezgarsco.matchmaking.models.events

import io.github.dlopezgarsco.matchmaking.models.*

@JvmInline
value class FirstName(val v: String)
@JvmInline
value class LastName(val v: String)

data class Attendee(
  val user: User,
  val firstName: FirstName,
  val lastName: LastName,
  val telephone: Telephone,
  val email: Email,
  val address: Address,
  val interests: Set<Interest>
)