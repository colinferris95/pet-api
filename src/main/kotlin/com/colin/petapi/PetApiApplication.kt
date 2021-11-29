package com.colin.petapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PetApiApplication

fun main(args: Array<String>) {
    runApplication<PetApiApplication>(*args)
}
