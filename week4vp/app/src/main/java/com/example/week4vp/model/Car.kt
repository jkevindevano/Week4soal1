package com.example.week4vp.model

data class Car(
    val id: Int,
    val name: String,
    val transmission: String,
    val fuelType: String,
    val year: Int,
    val mileage: String,
    val price: String,
    val location: String,
    val description: String,
    val imageRes: Int,
    var isFavorite: Boolean = false
)