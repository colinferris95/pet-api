package com.colin.petapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Pet(val id:Int, val name: String,val description: String) {

}