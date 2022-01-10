package com.colin.petapi.ownersToPets.repository

import com.colin.petapi.ownersToPets.model.OwnersToPets
import org.springframework.data.repository.CrudRepository

@org.springframework.stereotype.Repository
interface IOwnersToPetsRepository: CrudRepository<OwnersToPets, Long> {
    fun findByOwnersId(id:Long) : List<OwnersToPets>?
}

