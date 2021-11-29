package com.colin.petapi.controller

import com.colin.petapi.model.Pet
import com.colin.petapi.service.PetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PetController {
    @Autowired
    private lateinit var petService: PetService


    @GetMapping("/pets")
    fun getPets(@RequestParam(name = "id", required = false) id: Int? = null): List<Pet> {
        if (id === null){
            return petService.getPets()
        }
        else{
            return petService.getPet(id)
        }
    }
}