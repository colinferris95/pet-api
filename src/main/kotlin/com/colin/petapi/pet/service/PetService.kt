package com.colin.petapi.pet.service

import com.colin.petapi.owner.OwnerPackage
import com.colin.petapi.ownersToPets.OwnersToPetsPackage
import com.colin.petapi.pet.PetPackage
import com.colin.petapi.pet.model.Pet
import com.colin.petapi.pet.repository.IPetRepository
import com.colin.petapi.message.service.MessageService
import com.google.gson.Gson
import com.google.gson.JsonParser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service


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
        //fix
        val foundPets : Iterable<Pet> = petRepository.findAll()
        return foundPets
    }

    fun createPet(pet: Pet): Iterable<Pet> {
        petRepository.save(pet)
        val foundPets : Iterable<Pet> = petRepository.findAll()
        return foundPets
    }

    fun updatePet(pet: Pet): Iterable<Pet> {
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

    fun getPetsById(ids:ArrayList<Long>): Iterable<Pet>{
        val foundPets : Iterable<Pet> = petRepository.findPetsByMultipleId(ids)
        return foundPets
    }
}