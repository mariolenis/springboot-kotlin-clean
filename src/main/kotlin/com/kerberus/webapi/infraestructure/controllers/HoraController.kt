package com.kerberus.webapi.infraestructure.controllers

import io.reactivex.Single
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import com.kerberus.webapi.domain.models.Saludo
import java.util.*

@RestController
class HoraController {

    @GetMapping()
    fun helloWorld() = "hello World in SpingBootKotlin"

    @GetMapping("/saludo")
    fun saludo() = Saludo("Hola desde Kotlin")

    @GetMapping("/hora")
    fun horaActual(): Single<Any> {
        return Single.just(Date())
                .map { SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format(it) }
                .map { object {
                    val saludo = "Hora actual"
                    val hora = it
                }}



    }
}