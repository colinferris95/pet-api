package com.colin.petapi.controller

import com.colin.petapi.service.PetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PetController {
    @Autowired
    private lateinit var petService: PetService

    @GetMapping("/pets")
    fun getPets(): String {
        return petService.getPets()
    }
}