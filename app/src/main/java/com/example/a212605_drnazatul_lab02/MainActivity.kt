package com.example.a212605_drnazatul_lab02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a212605_drnazatul_lab02.ui.theme.A212605_DrNazatul_Lab02Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


val Green = Color(0xFF7DC832)
val Dark  = Color(0xFF1A1A1A)
val Gray  = Color(0xFFF5F5F5)
val Red   = Color(0xFFD32F2F)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A212605_DrNazatul_Lab02Theme {
                HomeScreen()
            }
        }
    }
}


@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {

        // All screen content goes here
        Column(modifier = Modifier.weight(1f)) {
            TopBar()
            SearchBar()
            StoriesRow()
            PromoBanner()
            CategoriesSection()
            NearToYouSection()
        }

        BottomNavBar()
    }
}


@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Green)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "📍 WQ9C+2H, 43600 Bangi, Selangor",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notifications",
            tint = Color.White
        )
    }
}


@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Green)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(Color.White, shape = RoundedCornerShape(24.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text(text = "Search stores and food") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        }

        if (searchText.isNotEmpty()) {
            Text(
                text = "Searching for: $searchText",
                color = Green,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )
        }
    }
}


@Composable
fun StoriesRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        StoryCircle(emoji = "🍱")
        StoryCircle(emoji = "🏨")
        StoryCircle(emoji = "🎂")
        StoryCircle(emoji = "🫐")
        StoryCircle(emoji = "☕")
    }
}

@Composable
fun StoryCircle(emoji: String) {
    Box(
        modifier = Modifier
            .size(56.dp)
            .background(Gray, shape = RoundedCornerShape(50)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = emoji, fontSize = 24.sp)
    }
}


@Composable
fun PromoBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(120.dp)
            .background(Red, shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "🍱", fontSize = 32.sp)
            Text(text = "RM8.80 LUNCH BENTO!", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "Berjaya × ReMeal", color = Color.White, fontSize = 12.sp)
        }
    }
}


@Composable
fun CategoriesSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Categories", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CategoryItem(emoji = "🛍️", label = "Mystery\nBags")
            CategoryItem(emoji = "🍽️", label = "Dine-In")
            CategoryItem(emoji = "🥘", label = "Meals")
            CategoryItem(emoji = "🍰", label = "Desserts")
            CategoryItem(emoji = "🥐", label = "Bread")
        }
    }
}

@Composable
fun CategoryItem(emoji: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(Color(0xFFDFF5A0), shape = RoundedCornerShape(50)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = emoji, fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = label, fontSize = 10.sp, textAlign = TextAlign.Center)
    }
}


@Composable
fun NearToYouSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Near to you →", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(12.dp))

        FoodCard(
            emoji = "🍽️",
            name = "Weekdays Dine-In Lunch",
            price = "RM 83.75",
            oldPrice = "RM 167.50",
            discount = "50% off",
            location = "Sunset Terrace, Sunway Resort",
            time = "14:00 - 15:00"
        )

        Spacer(modifier = Modifier.height(16.dp))

        FoodCard(
            emoji = "🎂",
            name = "Sweet Cake House",
            price = "RM 12.00",
            oldPrice = "RM 20.00",
            discount = "40% off",
            location = "Jalan Cake, Bangi",
            time = "10:00 - 18:00"
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun FoodCard(
    emoji: String,
    name: String,
    price: String,
    oldPrice: String,
    discount: String,
    location: String,
    time: String
)
{ var isSaved by remember { mutableStateOf(false)}

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Gray, shape = RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = emoji, fontSize = 28.sp)
        }

        Spacer(modifier = Modifier.width(12.dp))


        Column {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = price, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = oldPrice, fontSize = 12.sp, color = Color.Gray)
            }

        }

        IconButton(onClick = { isSaved = !isSaved }) {
            Icon(
                imageVector = if (isSaved) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "Save",
                tint = if (isSaved) Red else Color.Gray
            )
        }
    }
}


@Composable
fun BottomNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = Green)
            Text(text = "Home", fontSize = 11.sp, color = Green)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Parcels", tint = Color.Gray)
            Text(text = "Parcels", fontSize = 11.sp, color = Color.Gray)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = Icons.Default.List, contentDescription = "Orders", tint = Color.Gray)
            Text(text = "Orders", fontSize = 11.sp, color = Color.Gray)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Account", tint = Color.Gray)
            Text(text = "Account", fontSize = 11.sp, color = Color.Gray)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    A212605_DrNazatul_Lab02Theme {
        HomeScreen()
    }
}