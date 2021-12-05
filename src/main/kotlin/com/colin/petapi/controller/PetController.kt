package com.colin.petapi.controller

import com.colin.petapi.model.Pet
import com.colin.petapi.service.PetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class PetController {
    @Autowired
    private lateinit var petService: PetService


    @GetMapping("/pets")
    fun get(): MutableIterable<Pet> {
        return petService.getPets()
    }

    @GetMapping("/pets/:id")
    fun getById(@RequestParam(name = "id", required = true) id: Long? = null): Optional<Pet> {
        return petService.getPet(id!!)
    }

    @PostMapping("/pets")
    fun post(@RequestBody pet: Pet): MutableIterable<Pet> {
        petService.createPet(pet)
        return petService.getPets()
    }

    @PutMapping("/pets")
    fun put(@RequestBody pet: Pet): MutableIterable<Pet> {
        petService.updatePet(pet)
        return petService.getPets()
    }

    @DeleteMapping("/pets")
    fun delete(@RequestParam(name = "id", required = true) id: Long? = null): MutableIterable<Pet> {
        petService.deletePet(id!!)
        return petService.getPets()
    }
}