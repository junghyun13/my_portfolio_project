package com.mynote1.portfolio.domain.repository

import com.mynote1.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository


interface IntroductionRepository : JpaRepository<Introduction, Long> {

    // select * from introduction where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean): List<Introduction>

}