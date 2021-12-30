package com.colin.petapi.service

import com.google.gson.Gson
import org.json.JSONTokener
import org.springframework.stereotype.Service

@Service
class MessageService {

    fun notFound(exception:String,modelName:String): String {
        return "${modelName} not found ERROR: ${exception}"
    }

    fun unableToSave(exception:String,modelName:String): String {
        return "${modelName} not able to save ERROR: ${exception}"
    }

    fun unableToDelete(exception:String,modelName:String): String {
        return "${modelName} not able to delete ERROR: ${exception}"
    }

    fun unkownError(exception:String,modelName:String): String {
        return "Unknown ${modelName} service error contact IT ERROR: ${exception}"
    }

    fun responseFormat(success:String, data: String): String {
        val jsonString: String = Gson().toJson("{\"success\":\"${success}\",\"data\":${data}}")
        //jsonString.replace("\\\"", "\"")
        val jsonFormattedString : String =  JSONTokener(jsonString).nextValue().toString();
        return jsonFormattedString
    }
}