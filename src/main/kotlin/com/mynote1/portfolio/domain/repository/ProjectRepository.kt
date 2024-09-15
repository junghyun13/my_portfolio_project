package com.mynote1.portfolio.domain.repository

import com.mynote1.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>