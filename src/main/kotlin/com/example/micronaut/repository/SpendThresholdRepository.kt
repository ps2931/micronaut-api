package com.example.micronaut.repository

import com.example.micronaut.model.SpendThresholdEntity
import com.example.micronaut.model.SpendThresholdId
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.POSTGRES)
interface SpendThresholdRepository : CrudRepository<SpendThresholdEntity, SpendThresholdId> {
//    fun findByClientUidAndCreatedAt(@NotNull spendThresholdId: SpendThresholdId): Optional<SpendThresholdEntity> {
//        TODO("Not yet implemented")
//    }

//    fun findByClientIdOrderByCreateAtDesc(@NotNull spendThresholdEntity:SpendThresholdEntity)
}
