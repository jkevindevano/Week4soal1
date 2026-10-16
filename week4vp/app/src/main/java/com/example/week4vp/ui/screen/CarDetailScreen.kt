package com.example.week4vp.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week4vp.model.Car

val PrimaryOrange = Color(0xFFFF5722)
val LightOrangeBg = Color(0xFFFFEBEE)
val LightOrangeBorder = Color(0xFFFFCDD2)
val ScreenBackground = Color(0xFFF5F5F7)
val CardContentBg = Color(0xFFF9F9F9)
val SpecCardBg = Color(0xFFFFFFFF)
val TextGrayColor = Color(0xFF888888)

@Composable
fun CarDetailScreen(
    car: Car,
    onBack: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
            ) {
                Image(
                    painter = painterResource(id = car.imageRes),
                    contentDescription = car.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Surface(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 16.dp, bottom = 36.dp),
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFFFFEF0)
                ) {
                    Text(
                        text = car.fuelType.uppercase(),
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFE65100)
                    )
                }
            }

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-24.dp)),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                color = CardContentBg
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = car.name,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        IconButton(onClick = onFavoriteClick) {
                            Icon(
                                imageVector = if (car.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = "Favorite",
                                tint = if (car.isFavorite) PrimaryOrange else Color.Gray,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(PrimaryOrange, shape = CircleShape)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = car.location,
                            fontSize = 14.sp,
                            color = TextGrayColor
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = LightOrangeBg,
                        border = BorderStroke(1.dp, LightOrangeBorder)
                    ) {
                        Text(
                            text = car.price,
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFD32F2F)
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "SPECIFICATIONS",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextGrayColor,
                        letterSpacing = 1.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            SpecCard(title = "YEAR", value = car.year.toString(), modifier = Modifier.weight(1f))
                            SpecCard(title = "MILEAGE", value = car.mileage, modifier = Modifier.weight(1f))
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            SpecCard(title = "TRANSMISSION", value = car.transmission, modifier = Modifier.weight(1f))
                            SpecCard(title = "FUEL TYPE", value = car.fuelType, modifier = Modifier.weight(1f))
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "ABOUT THIS CAR",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextGrayColor,
                        letterSpacing = 1.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = car.description,
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        lineHeight = 22.sp
                    )

                    Spacer(modifier = Modifier.height(100.dp))
                }
            }
        }

        IconButton(
            onClick = onBack,
            modifier = Modifier
                .padding(20.dp)
                .size(44.dp)
                .background(Color.White, shape = CircleShape)
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }

        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            color = Color.White,
            shadowElevation = 16.dp,
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedIconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier.size(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = IconButtonDefaults.outlinedIconButtonColors(
                        containerColor = if (car.isFavorite) LightOrangeBg else Color.White
                    ),
                    border = BorderStroke(1.dp, if (car.isFavorite) PrimaryOrange else LightOrangeBorder)
                ) {
                    Icon(
                        imageVector = if (car.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (car.isFavorite) PrimaryOrange else Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Button(
                    onClick = { },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryOrange)
                ) {
                    Text(
                        text = "Contact Seller",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun SpecCard(title: String, value: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        color = SpecCardBg,
        shadowElevation = 2.dp,
        border = BorderStroke(0.5.dp, Color(0xFFEEEEEE))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = TextGrayColor
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = value,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}