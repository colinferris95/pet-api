package com.colin.petapi.service

import com.colin.petapi.model.Pet
import com.colin.petapi.repository.IPetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList


@Service
class PetService {

    @Autowired
    private lateinit var petRepository: IPetRepository


    fun getPets(): MutableIterable<Pet> {
        return petRepository.findAll()
    }

    fun getPet(id: Long): Optional<Pet> {
        return petRepository.findById(id)
    }

    fun createPet(pet:Pet): MutableIterable<Pet> {
        petRepository.save(pet)
        return petRepository.findAll()
    }

    fun updatePet(pet:Pet): MutableIterable<Pet> {
        petRepository.save(pet)
        return petRepository.findAll()
    }

    fun deletePet(id:Long): MutableIterable<Pet> {
        val petToDelete: Pet = petRepository.findById(id).orElse(null)
        petRepository.delete(petToDelete)
        return petRepository.findAll()
    }
}