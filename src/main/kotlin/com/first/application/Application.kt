package com.first.application

import io.javalin.Javalin

import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import com.first.person.PersonController
import com.first.person.personRepository

fun main() {
    JavalinApp(7000).init()
}

class JavalinApp(private val port: Int) {

    fun init(): Javalin {
    
        val app = Javalin.create().start(port)
    
       val personController = PersonController(personRepository)
        
        app.get("/") { ctx->ctx.result(App().greeting) }
        app.get("/welcome") { ctx->ctx.result("Welcome to the first program in javalin") }
        app.get("/api/person/:id", personController::getPerson)

        return app
    }
}