package com.mynote1.portfolio.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController {
    @GetMapping("/test")
    fun test(): String {
        //println("출력")
        return "OK"
    }
}