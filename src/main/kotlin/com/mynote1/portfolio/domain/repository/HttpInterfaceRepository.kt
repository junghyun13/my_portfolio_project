package com.mynote1.portfolio.domain.repository

import com.mynote1.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long>