package com.colin.petapi.repository

import com.colin.petapi.model.Pet
import org.springframework.data.repository.CrudRepository

@org.springframework.stereotype.Repository
interface IPetRepository : CrudRepository<Pet, Long> {
}