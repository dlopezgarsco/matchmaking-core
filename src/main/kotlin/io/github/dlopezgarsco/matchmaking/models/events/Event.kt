package io.github.dlopezgarsco.matchmaking.models.events

import io.github.dlopezgarsco.matchmaking.models.Address
import io.github.dlopezgarsco.matchmaking.models.Interest
import io.github.dlopezgarsco.matchmaking.models.Tag
import java.time.LocalDate

data class Event(
  val address: Address,
  val date: LocalDate,
  val tags: Set<Tag>,
  val interests: Set<Interest>
)
