package com.example.week4vp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.week4vp.R
import com.example.week4vp.model.Car

class CarViewModel : ViewModel() {
    var carList by mutableStateOf(
        listOf(
            Car(
                1,
                "Tiggo 9 CSH",
                "Auto",
                "PHEV",
                2024,
                "5,000 km",
                "Rp 350.000.000",
                "Semarang",
                "The Chery Tiggo 9 CSH is a flagship mid-size SUV that combines luxury, modern technology, and plug-in hybrid efficiency. Featuring a bold front grille, premium interior amenities, and advanced driver-assistance systems, it offers a sophisticated and comfortable ride for families.",
                R.drawable.tiggo,
                true
            ),
            Car(
                2,
                "Honda CRV",
                "Auto",
                "PETROL",
                2013,
                "15,200 km",
                "Rp 260.000.000",
                "Semarang",
                "The Honda CR-V is a highly popular compact crossover SUV known for its reliability, spacious cabin, and smooth ride. With its sleek exterior design, versatile cargo space, and modern safety features, it remains a top choice for urban commuting and family road trips.",
                R.drawable.crv,
                false
            ),
            Car(
                3,
                "Toyota Yaris Cross",
                "Auto",
                "HYBRID",
                2024,
                "30,500 km",
                "Rp 310.000.000",
                "Semarang",
                "The Toyota Yaris Cross is a stylish compact crossover designed for city living. It offers an elevated driving position, sharp exterior styling, and great fuel efficiency—especially in its hybrid variant—making it agile, practical, and eco-friendly.",
                R.drawable.yariscross,
                true
            ),
            Car(
                4,
                "Daihatsu Xenia",
                "Manual",
                "PETROL",
                2022,
                "28,000 km",
                "Rp 210.000.000",
                "Semarang",
                "The Daihatsu Xenia is a practical and budget-friendly multi-purpose vehicle (MPV) widely popular for family transportation. It offers a spacious 7-seater interior, efficient fuel consumption, and reliable performance tailored for everyday driving.",
                R.drawable.xenia,
                false
            ),
            Car(
                5,
                "Toyota Yaris",
                "Auto",
                "PETROL",
                2021,
                "52,400 km",
                "Rp 245.000.000",
                "Semarang",
                "The Toyota Yaris is a sporty compact hatchback designed for nimble urban driving. Known for its aggressive front styling, responsive handling, and high maneuverability, it is ideal for navigating tight city streets with ease.",
                R.drawable.yaris,
                false
            ),
            Car(
                6,
                "Toyota Innova",
                "Auto",
                "DIESEL",
                2021,
                "90,400 km",
                "Rp 345.000.000",
                "Solo",
                "The Toyota Innova Reborn is a legendary MPV celebrated for its exceptional durability, comfortable multi-row seating, and strong performance. Available in reliable gasoline and diesel options, it is a trusted choice for long-distance family travel.",
                R.drawable.reborn,
                false
            ),
            Car(
                7,
                "Daihatsu Ayla",
                "Manual",
                "PETROL",
                2019,
                "82,200 km",
                "Rp 145.000.000",
                "Surabaya",
                "The Daihatsu Ayla is a compact city car built for affordability, fuel efficiency, and easy parking. Its small footprint and lightweight build make it a perfect entry-level hatchback for daily city commutes.",
                R.drawable.ayla,
                false
            ),
            Car(
                8,
                "Honda HRV",
                "Auto",
                "PETROL",
                2023,
                "40,700 km",
                "Rp 315.000.000",
                "Sidoarjo",
                "The Honda HR-V is a stylish subcompact crossover SUV that stands out with its coupe-like roofline and modern aesthetic. It features Honda's versatile interior layout, sporty handling, and a full suite of smart technology.",
                R.drawable.hrv,
                false
            ),
            Car(
                9,
                "Jaecoo J5",
                "Auto",
                "ELECTRIC",
                2026,
                "1,400 km",
                "Rp 285.000.000",
                "Jakarta",
                "The Jaecoo J5 is a modern compact SUV featuring a rugged yet premium design aesthetic. Built for adventurous lifestyles, it blends smart connected tech, efficient powertrain options, and strong road presence.",
                R.drawable.j5,
                true
            ),
            Car(
                10,
                "MG 4 EV",
                "Auto",
                "ELECTRIC",
                2026,
                "2,900 km",
                "Rp 345.000.000",
                "Jakarta",
                "The MG 4 EV is an all-electric hatchback that showcases futuristic design, sharp handling, and impressive electric range. Built on a dedicated EV platform, it provides instant acceleration, a high-tech cabin, and zero-emissions driving.",
                R.drawable.mg4,
                false
            )
        )
    )
        private set

    var selectedCar by mutableStateOf<Car?>(null)
        private set

    fun toggleFavorite(carId: Int) {
        carList = carList.map { car ->
            if (car.id == carId) {
                val updatedCar = car.copy(isFavorite = !car.isFavorite)
                if (selectedCar?.id == carId) {
                    selectedCar = updatedCar
                }
                updatedCar
            } else {
                car
            }
        }
    }

    fun selectCar(car: Car?) {
        selectedCar = car
    }
}