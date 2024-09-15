package com.mynote1.portfolio.domain.repository

import com.mynote1.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long>