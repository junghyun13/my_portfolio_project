package com.mynote1.portfolio.domain.repository

import com.mynote1.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>