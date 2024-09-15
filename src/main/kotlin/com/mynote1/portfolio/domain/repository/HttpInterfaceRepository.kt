package com.mynote1.portfolio.domain.repository

import com.mynote1.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {
    fun countAllByCreatedDateTimeBetween(start: LocalDateTime, end: LocalDateTime): Long
}