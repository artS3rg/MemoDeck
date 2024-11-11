package com.artinc.memodeck.ui.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.artinc.memodeck.ui.References.BackgroundUI
import com.artinc.memodeck.ui.theme.Orange

@Composable
fun CardActivity() {
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
                imageVector = Icons.Rounded.Add,
                contentDescription = null
            )
        }
    }
}