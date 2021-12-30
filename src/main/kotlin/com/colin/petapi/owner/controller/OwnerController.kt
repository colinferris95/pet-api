package com.colin.petapi.owner.controller

import com.colin.petapi.owner.model.Owner
import com.colin.petapi.owner.service.OwnerService
import com.colin.petapi.pet.model.Pet
import com.colin.petapi.service.MessageService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@RestController
@EnableWebMvc
class OwnerController {

    @Autowired
    private lateinit var ownerService: OwnerService

    @Autowired
    private lateinit var messageService: MessageService

    @GetMapping("/owners")
    @ResponseBody
    fun get(): ResponseEntity<Any> {

        try{
            val jsonData: String = Gson().toJson(ownerService.getOwners())
            val successResponse: String = messageService.responseFormat("true",jsonData)
            return ResponseEntity(successResponse, HttpStatus.OK)
        }
        catch(exception: Exception){
            val failureResponse: String = messageService.responseFormat("false","ERROR: ${messageService.notFound(exception.message!!,"owner")} ")
            return ResponseEntity(failureResponse, HttpStatus.OK)
        }

    }

    @PostMapping("/owners")
    fun post(@RequestBody owner: Owner): ResponseEntity<Any> {
        try{
            val jsonData: String = Gson().toJson(ownerService.createOwner(owner))
            val successResponse: String = messageService.responseFormat("true",jsonData)
            return ResponseEntity(successResponse, HttpStatus.OK)
        }
        catch(exception: Exception){
            val failureResponse: String = messageService.responseFormat("false","ERROR: ${messageService.unableToSave(exception.message!!,"owner")} ")
            return ResponseEntity(failureResponse, HttpStatus.OK)
        }
    }


    @PutMapping("/owners")
    fun put(@RequestBody owner: Owner): ResponseEntity<Any> {
        try{
            val jsonData: String = Gson().toJson(ownerService.updateOwner(owner))
            val successResponse: String = messageService.responseFormat("true",jsonData)
            return ResponseEntity(successResponse, HttpStatus.OK)
        }
        catch(exception: Exception){
            val failureResponse: String = messageService.responseFormat("false","ERROR: ${messageService.unableToSave(exception.message!!,"owner")} ")
            return ResponseEntity(failureResponse, HttpStatus.OK)
        }
    }

    @DeleteMapping("/owners")
    fun delete(@RequestParam(name = "id", required = true) id: Long? = null): ResponseEntity<Any> {
        try{
            val jsonData: String = Gson().toJson(ownerService.deleteOwner(id!!))
            val successResponse: String = messageService.responseFormat("true",jsonData)
            return ResponseEntity(successResponse, HttpStatus.OK)
        }
        catch(exception: Exception){
            val failureResponse: String = messageService.responseFormat("false","ERROR: ${messageService.unableToDelete(exception.message!!,"owner")} ")
            return ResponseEntity(failureResponse, HttpStatus.OK)
        }
    }
}