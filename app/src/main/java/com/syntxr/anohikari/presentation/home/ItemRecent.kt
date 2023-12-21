package com.syntxr.anohikari.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.syntxr.anohikari.ui.theme.AnoHikariTheme

@Composable
fun ItemRecent(
    modifier: Modifier = Modifier
){
    Card(
        modifier.clickable {  },
        colors = CardDefaults
            .cardColors(
            containerColor = Color(0x42121212)
        ),
        border = BorderStroke(0.8.dp, Color.White)
    ) {
        Box(
            modifier
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Al-Fatihah : 1",
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.8.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemRecentPreview(){
    AnoHikariTheme {
        ItemRecent()
    }
}