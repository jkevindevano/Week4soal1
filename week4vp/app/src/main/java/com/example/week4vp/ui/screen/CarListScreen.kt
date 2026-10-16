package com.example.week4vp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week4vp.model.Car
import com.example.week4vp.ui.widgets.CarItemCard
import com.example.week4vp.viewmodel.CarViewModel

@Composable
fun CarListScreen(viewModel: CarViewModel) {
    Spacer(modifier = Modifier.height(8.dp))
    if (viewModel.selectedCar != null) {
        CarDetailScreen(
            car = viewModel.selectedCar!!,
            onBack = { viewModel.selectCar(null) },
            onFavoriteClick = {
                viewModel.selectedCar?.let {
                    viewModel.toggleFavorite(it.id)
                }
            }
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "On Sale", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Find your perfect ride", fontSize = 14.sp, color = Color.Gray)
                }

                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFECEE))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = null, tint = Color.Red, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        val savedCount = viewModel.carList.count { it.isFavorite }
                        Text(text = "$savedCount saved", color = Color.Red, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(viewModel.carList) { car ->
                    CarItemCard(
                        car = car,
                        onFavoriteClick = { viewModel.toggleFavorite(car.id) },
                        onCardClick = { viewModel.selectCar(car) }
                    )
                }
            }
        }
    }
}

