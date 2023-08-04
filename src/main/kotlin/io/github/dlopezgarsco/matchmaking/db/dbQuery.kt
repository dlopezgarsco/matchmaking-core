package io.github.dlopezgarsco.matchmaking.db

import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

suspend fun <T> dbQuery(block: suspend () -> T ): T = newSuspendedTransaction { block() }