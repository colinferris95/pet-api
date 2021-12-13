package com.colin.petapi.service

import com.colin.petapi.model.Pet
import com.colin.petapi.repository.IPetRepository
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import org.json.JSONArray
import org.json.JSONTokener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class PetService {

    @Autowired
    private lateinit var petRepository: IPetRepository

    @Autowired
    private lateinit var messageService: MessageService

    var parser: JsonParser = JsonParser()
    val gson = Gson()

    fun getPets(): Iterable<Pet> {
            val foundPets : Iterable<Pet> = petRepository.findAll()
            return foundPets

    }

    fun getPet(id: Long): Iterable<Pet> {
        val foundPets : Iterable<Pet> = petRepository.findAll()
        return foundPets
    }

    fun createPet(pet:Pet): Iterable<Pet> {
        petRepository.save(pet)
        val foundPets : Iterable<Pet> = petRepository.findAll()
        return foundPets
    }

    fun updatePet(pet:Pet): Iterable<Pet> {
        petRepository.save(pet)
        val foundPets : Iterable<Pet> = petRepository.findAll()
        return foundPets
    }

    fun deletePet(id:Long): Iterable<Pet> {
        val petToDelete: Pet = petRepository.findById(id).orElse(null)
        petRepository.delete(petToDelete)
        val foundPets : Iterable<Pet> = petRepository.findAll()
        return foundPets
    }
}