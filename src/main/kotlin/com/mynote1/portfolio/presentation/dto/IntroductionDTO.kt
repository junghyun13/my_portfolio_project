package com.mynote1.portfolio.presentation.dto

import com.mynote1.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String
) {
    constructor(introduction: Introduction) : this(
        content = introduction.content
    )
}