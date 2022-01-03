package com.colin.petapi.ownersToPets.service

import com.colin.petapi.owner.model.Owner
import com.colin.petapi.owner.repository.IOwnerRepository
import com.colin.petapi.ownersToPets.model.OwnersToPets
import com.colin.petapi.ownersToPets.repository.IOwnersToPetsRepository
import com.colin.petapi.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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

}