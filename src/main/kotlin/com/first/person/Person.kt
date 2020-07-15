package com.first.person

import io.javalin.http.Context

class PersonController(private val data: Map<Int, Person>) {
    fun getPerson(ctx: Context) {
        ctx.pathParam("id").toInt().let {
            data[it]?.let { item ->
                ctx.json(item)
                return
            }
            ctx.status(404)
        }
    }
}

data class Person(val name: String, val age: Int)

// In-memory repository
val personRepository = hashMapOf(
        0 to Person("Priyanka", 27),
        1 to Person("Rahul", 34),
        2 to Person("Shurya", 2)
)