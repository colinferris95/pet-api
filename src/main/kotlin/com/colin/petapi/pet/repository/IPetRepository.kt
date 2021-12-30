package com.colin.petapi.pet.repository

import com.colin.petapi.pet.model.Pet
import org.springframework.data.repository.CrudRepository

@org.springframework.stereotype.Repository
interface IPetRepository : CrudRepository<Pet, Long> {
}