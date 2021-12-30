package com.colin.petapi.pet.controller

import com.colin.petapi.pet.model.Pet
import com.colin.petapi.service.MessageService
import com.colin.petapi.pet.service.PetService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@RestController
@EnableWebMvc
class PetController {
    @Autowired
    private lateinit var petService: PetService

    @Autowired
    private lateinit var messageService: MessageService


    @GetMapping("/pets")
    @ResponseBody
    fun get(): ResponseEntity<Any> {
        try{
            val jsonData: String = Gson().toJson(petService.getPets())
            val successResponse: String = messageService.responseFormat("true",jsonData)
            return ResponseEntity(successResponse, HttpStatus.OK)
        }
        catch(exception: Exception){
            val failureResponse: String = messageService.responseFormat("false","ERROR: ${messageService.notFound(exception.message!!,"pet")} ")
            return ResponseEntity(failureResponse, HttpStatus.OK)
        }
    }

    @GetMapping("/pets/:id")
    fun getById(@RequestParam(name = "id", required = true) id: Long? = null): ResponseEntity<Any> {
        try{
            val jsonData: String = Gson().toJson(petService.getPet(id!!))
            val successResponse: String = messageService.responseFormat("true",jsonData)
            return ResponseEntity(successResponse, HttpStatus.OK)
        }
        catch(exception: Exception){
            val failureResponse: String = messageService.responseFormat("false","ERROR: ${messageService.notFound(exception.message!!,"pet")} ")
            return ResponseEntity(failureResponse, HttpStatus.OK)
        }
    }

    @PostMapping("/pets")
    fun post(@RequestBody pet: Pet): ResponseEntity<Any> {
        try{
            val jsonData: String = Gson().toJson(petService.createPet(pet))
            val successResponse: String = messageService.responseFormat("true",jsonData)
            return ResponseEntity(successResponse, HttpStatus.OK)
        }
        catch(exception: Exception){
            val failureResponse: String = messageService.responseFormat("false","ERROR: ${messageService.unableToSave(exception.message!!,"pet")} ")
            return ResponseEntity(failureResponse, HttpStatus.OK)
        }
    }

    @PutMapping("/pets")
    fun put(@RequestBody pet: Pet): ResponseEntity<Any> {
        try{
            val jsonData: String = Gson().toJson(petService.updatePet(pet))
            val successResponse: String = messageService.responseFormat("true",jsonData)
            return ResponseEntity(successResponse, HttpStatus.OK)
        }
        catch(exception: Exception){
            val failureResponse: String = messageService.responseFormat("false","ERROR: ${messageService.unableToSave(exception.message!!,"pet")} ")
            return ResponseEntity(failureResponse, HttpStatus.OK)
        }
    }

    @DeleteMapping("/pets")
    fun delete(@RequestParam(name = "id", required = true) id: Long? = null): ResponseEntity<Any> {
        try{
            val jsonData: String = Gson().toJson(petService.deletePet(id!!))
            val successResponse: String = messageService.responseFormat("true",jsonData)
            return ResponseEntity(successResponse, HttpStatus.OK)
        }
        catch(exception: Exception){
            val failureResponse: String = messageService.responseFormat("false","ERROR: ${messageService.unableToDelete(exception.message!!,"pet")} ")
            return ResponseEntity(failureResponse, HttpStatus.OK)
        }
    }
}