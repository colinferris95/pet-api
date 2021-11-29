package com.colin.petapi.service

import com.colin.petapi.model.Pet
import org.springframework.stereotype.Service

@Service
class PetService {

    var pet1 : Pet = Pet(1,"Lassie","Old Yeller")

    var pet2 : Pet = Pet(2,"Toto","Wizard of Oz")

    var listOfPets : ArrayList<Pet> = arrayListOf(pet1,pet2)

    fun getPets(): List<Pet> {
        return listOfPets
    }

    fun getPet(id: Int): List<Pet> {
        return listOfPets.filter { it.id == id }
    }

    fun createPet(pet:Pet): List<Pet> {
        var newPet : Pet = Pet((listOfPets.size + 1), pet.name, pet.description)
        listOfPets.add(newPet)
        return listOfPets
    }
}