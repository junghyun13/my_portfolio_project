package com.mynote1.portfolio.domain.repository

import com.mynote1.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long>