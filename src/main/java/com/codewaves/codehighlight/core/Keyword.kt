package com.codewaves.codehighlight.core

import com.google.gson.Gson
import com.google.gson.JsonObject
import java.security.Key

/**
 * Created by Sergej Kravcenko on 5/14/2017.
 * Copyright (c) 2017 Sergej Kravcenko
 */

data class Keyword(
   val value: String,
   val className: String = "keyword",
   val relevance: Int = 0
)

fun keywords(vararg keywords: Any): List<Keyword> = keywords.flatMap {
   when (it) {
      is Keyword -> listOf(it)
      is List<*> -> it as? List<Keyword> ?: it.flatMap { keywords(it!!) }
      else -> listOf(Keyword(value = it.toString()))
   }
}

fun keywordsJson(jsonString: String): List<Keyword> {
   val noComms = jsonString.trim().split("\n").map { it.split("//").first() }.joinToString("")
   return noComms.split(",").filter { it.isNotBlank() }.map {
      val parts = it.split("=", limit = 2)
      Keyword(
         className = if (parts.size > 1) parts.first().trim() else "keyword",
         value = parts[1].trim().substringAfter('"').substringBeforeLast('"')
      )
   }
}
