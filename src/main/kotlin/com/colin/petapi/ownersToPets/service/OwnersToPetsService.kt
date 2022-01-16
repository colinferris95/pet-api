package com.colin.petapi.ownersToPets.service

import com.colin.petapi.owner.model.Owner
import com.colin.petapi.owner.repository.IOwnerRepository
import com.colin.petapi.ownersToPets.model.OwnersToPets
import com.colin.petapi.ownersToPets.repository.IOwnersToPetsRepository
import com.colin.petapi.message.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Service
import java.util.*

@Service
class OwnersToPetsService {

    @Autowired
    private lateinit var ownersToPetsRepository: IOwnersToPetsRepository

    @Autowired
    private lateinit var messageService: MessageService


    fun getOwnersToPets(): Iterable<OwnersToPets> {
        val foundOwnersToPets : Iterable<OwnersToPets> = ownersToPetsRepository.findAll()
        return foundOwnersToPets
    }

    fun getOwnersToPetsById(id:Long): List<OwnersToPets>? {
        val foundOwnersToPets: List<OwnersToPets>? = ownersToPetsRepository.findByOwnersId(id)
        return foundOwnersToPets
    }

    fun createOwnersToPets(ownersToPets: OwnersToPets): Iterable<OwnersToPets> {
        ownersToPetsRepository.save(ownersToPets)
        val foundOwnersToPets : Iterable<OwnersToPets> = ownersToPetsRepository.findAll()
        return foundOwnersToPets
    }

    fun deleteOwnersToPets(id:Long): Iterable<OwnersToPets> {
        val ownersToPetsToDelete: OwnersToPets = ownersToPetsRepository.findById(id).orElse(null)
        ownersToPetsRepository.delete(ownersToPetsToDelete)
        val foundOwnersToPets : Iterable<OwnersToPets> = ownersToPetsRepository.findAll()
        return foundOwnersToPets
    }

}