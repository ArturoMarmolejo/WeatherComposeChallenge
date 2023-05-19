package com.arturomarmolejo.weathercomposechallenge.presentation.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.arturomarmolejo.weathercomposechallenge.R
import com.arturomarmolejo.weathercomposechallenge.data.model.weather.Weather
import com.arturomarmolejo.weathercomposechallenge.data.model.weather.domain.AllWeatherDom
import com.arturomarmolejo.weathercomposechallenge.utils.IMG_URL1
import com.arturomarmolejo.weathercomposechallenge.utils.IMG_URL2
import com.arturomarmolejo.weathercomposechallenge.utils.getDirection

@Composable
fun WeatherView(
    currentWeather: AllWeatherDom,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier
    ){
        items(currentWeather.weather){
            WeatherCard(
                currentWeather = currentWeather,
                weather = it
            )
        }
        item {
            TemperatureCard(currentWeather = currentWeather)
        }
        item {
            StatusCard(currentWeather = currentWeather)
        }
        item {
            WindCard(currentWeather = currentWeather)
        }
        item {
            CloudCard(currentWeather = currentWeather)
        }
        item {
            RainCard(currentWeather = currentWeather)
        }
        item {
            SunCard(currentWeather = currentWeather)
        }
    }
}

@Composable
fun WeatherCard(
    currentWeather: AllWeatherDom,
    weather: Weather
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            Column(
                modifier = Modifier.weight(1F)
            ) {
                if(weather.icon!=null){
                    AsyncImage(
                        model = "$IMG_URL1${weather.icon}$IMG_URL2",
                        contentDescription = weather.main?:""
                    )
                }
                Text(
                    text = weather.main ?: "Unknown",
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                modifier = Modifier.weight(1F)
            ) {
                Text(
                    text = weather.description ?: "Unknown",
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Column(
                        modifier = Modifier.weight(1F)
                    ) {
                        Text(
                            text = "Minimum",
                            modifier = Modifier
                                .padding(16.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Maximum",
                            modifier = Modifier
                                .padding(16.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column(
                        modifier = Modifier.weight(1F)
                    ) {
                        Text(
                            text = currentWeather.conditions.tempMin.toString(),
                            modifier = Modifier
                                .padding(16.dp),
                            fontSize = 12.sp,
                        )
                        Text(
                            text = currentWeather.conditions.tempMax.toString(),
                            modifier = Modifier
                                .padding(16.dp),
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TemperatureCard(
    currentWeather: AllWeatherDom
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Temperature",
            modifier = Modifier
                .padding(16.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = currentWeather.conditions.temp.toString(),
            modifier = Modifier
                .padding(16.dp),
            fontSize = 20.sp,
        )
    }
}

@Composable
fun StatusCard(
    currentWeather: AllWeatherDom
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row {
            Column(
                modifier = Modifier.weight(1F)
            ) {
                Text(
                    text = "Pressure",
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Humidity",
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                modifier = Modifier.weight(1F)
            ) {
                Text(
                    text = currentWeather.conditions.pressure.toString(),
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 12.sp,
                )
                Text(
                    text = currentWeather.conditions.humidity.toString(),
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun WindCard(
    currentWeather: AllWeatherDom
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.baseline_air_24),
                contentDescription = "wind",
                modifier = Modifier
                    .weight(1F)
                    .padding(16.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(16.dp)
            ) {
                Text(
                    text = currentWeather.wind.deg.getDirection(),
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 14.sp,
                )
                Text(
                    text = currentWeather.wind.speed.toString(),
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun CloudCard(
    currentWeather: AllWeatherDom
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.baseline_cloud_24),
                contentDescription = "clouds",
                modifier = Modifier
                    .weight(1F)
                    .padding(16.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(16.dp)
            ) {
                Text(
                    text = "${currentWeather.clouds}%",
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 20.sp,
                )
            }
        }
    }
}

@Composable
fun RainCard(
    currentWeather: AllWeatherDom
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.baseline_water_drop_24),
                contentDescription = "rain",
                modifier = Modifier
                    .weight(1F)
                    .padding(16.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(16.dp)
            ) {
                currentWeather.rain.h1?.let {
                    Text(
                        text = "1h: $it",
                        modifier = Modifier
                            .padding(16.dp),
                        fontSize = 12.sp,
                    )
                }
                currentWeather.rain.h3?.let {
                    Text(
                        text = "3h: $it",
                        modifier = Modifier
                            .padding(16.dp),
                        fontSize = 12.sp,
                    )
                }
            }
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.baseline_severe_cold_24),
                contentDescription = "snow",
                modifier = Modifier
                    .weight(1F)
                    .padding(16.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(16.dp)
            ) {
                currentWeather.snow.h1?.let {
                    Text(
                        text = "1h: $it",
                        modifier = Modifier
                            .padding(16.dp),
                        fontSize = 12.sp,
                    )
                }
                currentWeather.snow.h3?.let {
                    Text(
                        text = "3h: $it",
                        modifier = Modifier
                            .padding(16.dp),
                        fontSize = 12.sp,
                    )
                }
            }
        }
    }
}

@Composable
fun SunCard(
    currentWeather: AllWeatherDom
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.baseline_wb_sunny_24),
                contentDescription = "sunset",
                modifier = Modifier
                    .weight(1F)
                    .padding(16.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Sunrise: ${currentWeather.sunrise}",
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 20.sp,
                )
                Text(
                    text = "Sunset: ${currentWeather.sunset}",
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 20.sp,
                )
            }
        }
    }
}
