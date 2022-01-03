package com.colin.petapi.ownersToPets.controller

import com.colin.petapi.ownersToPets.service.OwnersToPetsService
import com.colin.petapi.service.MessageService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@RestController
@EnableWebMvc
class OwnersToPetsController {


    @Autowired
    private lateinit var ownersToPetsService: OwnersToPetsService
    @Autowired
    private lateinit var messageService: MessageService

    @GetMapping("/ownersToPets")
    @ResponseBody
    fun get(): ResponseEntity<Any> {

        try{
            val jsonData: String = Gson().toJson(ownersToPetsService.getOwnersToPets())
            val successResponse: String = messageService.responseFormat("true",jsonData)
            return ResponseEntity(successResponse, HttpStatus.OK)
        }
        catch(exception: Exception){
            val failureResponse: String = messageService.responseFormat("false","ERROR: ${messageService.notFound(exception.message!!,"ownersToPets")} ")
            return ResponseEntity(failureResponse, HttpStatus.OK)
        }

    }
}