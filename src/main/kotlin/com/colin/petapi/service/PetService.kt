package com.colin.petapi.service

import com.colin.petapi.model.Pet
import org.springframework.stereotype.Service

@Service
class PetService {

    var pet1 : Pet = Pet("Lassie","Old Yeller")

    var listOfPets : ArrayList<Pet> = arrayListOf(pet1)

    fun getPets(): ArrayList<Pet> {
        return listOfPets
    }
}