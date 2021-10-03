package br.com.lucasguiss.kotlinswaggerapi.service

import br.com.lucasguiss.kotlinswaggerapi.model.Car
import org.springframework.stereotype.Service

@Service
class CarService {

    companion object {
        private val carRepository: MutableMap<Long, Car> = mutableMapOf()
    }

    fun createCar(car: Car) {
        carRepository[car.id] = car
    }

    fun findAll(): MutableCollection<Car> = carRepository.values

}