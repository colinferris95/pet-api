package com.colin.petapi.owner.repository

import com.colin.petapi.owner.model.Owner
import org.springframework.data.repository.CrudRepository


@org.springframework.stereotype.Repository
interface IOwnerRepository: CrudRepository<Owner, Long> {
}