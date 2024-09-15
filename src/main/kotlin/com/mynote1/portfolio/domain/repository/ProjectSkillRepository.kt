package com.mynote1.portfolio.domain.repository

import com.mynote1.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long>