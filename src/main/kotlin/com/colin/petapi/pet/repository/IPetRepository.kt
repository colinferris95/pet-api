package com.colin.petapi.pet.repository

import com.colin.petapi.pet.model.Pet
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

@org.springframework.stereotype.Repository
interface IPetRepository : CrudRepository<Pet, Long> {

    @Query("""
        SELECT p
        FROM Pet p
        where p.id IN(:ids)

    """
    )
    fun findPetsByMultipleId(ids:ArrayList<Long>): List<Pet>
}