package br.com.lucasguiss.kotlinswaggerapi.model

import io.swagger.annotations.ApiModelProperty

data class Car(
    @ApiModelProperty("Identifier of the car", required = true, example = "1")
    val id: Long,
    @ApiModelProperty("Model of the", required = true, example = "Sandero")
    val model: String,
    @ApiModelProperty("Year of the car", required = true, example = "2009")
    val year: Int,
    @ApiModelProperty("Brand name of the car", required = true, example = "Renault")
    val brand: String
)