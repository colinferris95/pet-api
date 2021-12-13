package com.colin.petapi.service

import com.google.gson.Gson
import org.json.JSONTokener
import org.springframework.stereotype.Service

@Service
class MessageService {

    fun petNotFound(exception:String): String {
        return "Pet not found ERROR: ${exception}"
    }

    fun petUnableToSave(exception:String): String {
        return "Pet not able to save ERROR: ${exception}"
    }

    fun petUnableToDelete(exception:String): String {
        return "Pet not able to delete ERROR: ${exception}"
    }

    fun petUnkownError(exception:String): String {
        return "Unknown pet service error contact IT ERROR: ${exception}"
    }

    fun responseFormat(success:String, data: String): String {
        val jsonString: String = Gson().toJson("{\"success\":\"${success}\",\"data\":${data}}")
        //jsonString.replace("\\\"", "\"")
        val jsonFormattedString : String =  JSONTokener(jsonString).nextValue().toString();
        return jsonFormattedString
    }
}