package com.example.micronaut.repository

import com.example.micronaut.model.SpendThresholdIntakeEntity
import com.example.micronaut.model.SpendThresholdIntakeId
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.POSTGRES)
interface SpendThresholdIntakeRepository : CrudRepository<SpendThresholdIntakeEntity, SpendThresholdIntakeId>