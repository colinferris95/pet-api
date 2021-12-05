package com.colin.petapi.controller

import com.colin.petapi.model.Pet
import com.colin.petapi.service.PetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class PetController {
    @Autowired
    private lateinit var petService: PetService


    @GetMapping("/pets")
    fun get(@RequestParam(name = "id", required = false) id: Int? = null): List<Pet> {
        if (id === null){
            return petService.getPets()
        }
        else{
            return petService.getPet(id)
        }
    }

    @PostMapping("/pets")
    fun post(@RequestBody pet: Pet): List<Pet> {
        petService.createPet(pet)
        return petService.getPets()
    }

    @PutMapping("/pets")
    fun put(@RequestBody pet: Pet): List<Pet> {
        petService.updatePet(pet)
        return petService.getPets()
    }

    @DeleteMapping("/pets")
    fun delete(@RequestParam(name = "id", required = true) id: Int? = null): List<Pet> {
        petService.deletePet(id!!)
        return petService.getPets()
    }
}