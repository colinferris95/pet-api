package com.colin.petapi.service

import org.springframework.stereotype.Service

@Service
class PetService {
    fun getPets(): String {
        return "List of Pets"
    }
}