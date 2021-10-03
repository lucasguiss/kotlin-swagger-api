package br.com.lucasguiss.kotlinswaggerapi.controller

import br.com.lucasguiss.kotlinswaggerapi.model.Car
import br.com.lucasguiss.kotlinswaggerapi.service.CarService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@Api("Car API")
@RestController
@RequestMapping(path = ["car"])
class CarController(
    private val service: CarService
) {

    @ApiOperation(
        value = "Create a car",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        code = 201
    )
    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createCar(@RequestBody car: Car): ResponseEntity<Car> {
        return if (Objects.isNull(car)) {
            ResponseEntity.badRequest().build()
        } else {
            service.createCar(car)
            ResponseEntity.ok().build()
        }
    }

    @ApiOperation(
        value = "Find all cars",
        produces = MediaType.APPLICATION_JSON_VALUE,
        code = 200
    )
    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAll() = service.findAll()

}