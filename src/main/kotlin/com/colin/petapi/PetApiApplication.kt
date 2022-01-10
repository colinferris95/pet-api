package com.colin.petapi

import com.colin.petapi.message.MessagePackage
import com.colin.petapi.owner.OwnerPackage
import com.colin.petapi.ownersToPets.OwnersToPetsPackage
import com.colin.petapi.pet.PetPackage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackageClasses = [OwnerPackage::class, PetPackage::class, OwnersToPetsPackage::class, MessagePackage::class])
@EntityScan(basePackageClasses = [OwnerPackage::class, PetPackage::class, OwnersToPetsPackage::class, MessagePackage::class])
class PetApiApplication




fun main(args: Array<String>) {
    runApplication<PetApiApplication>(*args)
}

