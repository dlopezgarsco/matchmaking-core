package io.github.dlopezgarsco.matchmaking.models

import java.util.*

data class User (
  val id: UUID,
  val email: Email
) : ID
