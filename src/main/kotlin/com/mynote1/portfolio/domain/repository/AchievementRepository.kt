package com.mynote1.portfolio.domain.repository

import com.mynote1.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Achievement>  // select * from achievement where is_active = :isActive
}