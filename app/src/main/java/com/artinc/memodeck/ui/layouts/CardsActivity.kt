package com.artinc.memodeck.ui.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artinc.memodeck.ui.References.BackgroundUI
import com.artinc.memodeck.ui.References.CardUI
import com.artinc.memodeck.ui.theme.Orange
import com.artinc.memodeck.ui.theme.White

@Composable
fun CardsActivity() {
    var currentCard by remember { mutableIntStateOf(1) }
    val countCard = 2

    BackgroundUI()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        FloatingActionButton(
            containerColor = Orange,
            contentColor = Color.White,
            onClick = { /*TODO*/ }
        ) {
            Icon(
                modifier = Modifier
                    .size(30.dp),
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = null
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "$currentCard / $countCard",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(40.dp))
        CardUI()
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                enabled = currentCard != 1,
                colors = IconButtonColors(
                    contentColor = Color.White,
                    disabledContentColor = Color.Gray,
                    containerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent
                ),
                onClick = {
                    currentCard--
                }
            ) {
                Icon(
                    modifier = Modifier
                        .size(40.dp),
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = null
                )
            }
            IconButton(
                enabled = currentCard != countCard,
                colors = IconButtonColors(
                    contentColor = Color.White,
                    disabledContentColor = Color.Gray,
                    containerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent
                ),
                onClick = {
                    currentCard++
                }
            ) {
                Icon(
                    modifier = Modifier
                        .size(40.dp),
                    imageVector = Icons.Rounded.ArrowForward,
                    contentDescription = null
                )
            }
        }
    }
}