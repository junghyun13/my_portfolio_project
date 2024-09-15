package com.mynote1.portfolio.domain.repository

import com.mynote1.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long>