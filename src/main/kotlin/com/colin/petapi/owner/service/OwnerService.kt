package com.colin.petapi.owner.service

import com.colin.petapi.owner.model.Owner
import com.colin.petapi.owner.repository.IOwnerRepository
import com.colin.petapi.pet.model.Pet
import com.colin.petapi.pet.repository.IPetRepository
import com.colin.petapi.message.service.MessageService
import com.google.gson.Gson
import com.google.gson.JsonParser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Service

@Service
class OwnerService {


    @Autowired
    private lateinit var ownerRepository: IOwnerRepository

    @Autowired
    private lateinit var messageService: MessageService


    fun getOwners(): Iterable<Owner> {
        val foundOwners : Iterable<Owner> = ownerRepository.findAll()
        return foundOwners
    }


    fun createOwner(owner: Owner): Iterable<Owner> {
        ownerRepository.save(owner)
        val foundOwners : Iterable<Owner> = ownerRepository.findAll()
        return foundOwners
    }

    fun updateOwner(owner: Owner): Iterable<Owner> {
        ownerRepository.save(owner)
        val foundOwners : Iterable<Owner> = ownerRepository.findAll()
        return foundOwners
    }

    fun deleteOwner(id:Long): Iterable<Owner> {
        val ownerToDelete: Owner = ownerRepository.findById(id).orElse(null)
        ownerRepository.delete(ownerToDelete)
        val foundOwners : Iterable<Owner> = ownerRepository.findAll()
        return foundOwners
    }

}