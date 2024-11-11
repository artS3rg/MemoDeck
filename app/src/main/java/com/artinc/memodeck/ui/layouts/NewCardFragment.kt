package com.artinc.memodeck.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artinc.memodeck.ui.References.CardUI
import com.artinc.memodeck.ui.theme.Orange
import com.artinc.memodeck.ui.theme.Purple
import com.artinc.memodeck.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewCardFragment() {
    // Переменные состояния для хранения значений полей ввода
    var textFieldQuestion by remember { mutableStateOf(TextFieldValue("")) }
    var textFieldAnswer by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .systemBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Первое текстовое поле
            OutlinedTextField(
                value = textFieldQuestion,
                onValueChange = { textFieldQuestion = it },
                placeholder = { Text("Введите вопрос") },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = White,
                    unfocusedPlaceholderColor = Orange,
                    focusedPlaceholderColor = White,
                    focusedTextColor = White,
                    unfocusedTextColor = Color.Gray,
                    focusedBorderColor = Orange,
                    unfocusedBorderColor = Orange,
                ),
                modifier = Modifier.fillMaxWidth()
            )
            // Второе текстовое поле
            OutlinedTextField(
                value = textFieldAnswer,
                onValueChange = { textFieldAnswer = it },
                placeholder = { Text("Введите ответ") },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = White,
                    unfocusedPlaceholderColor = Orange,
                    focusedPlaceholderColor = White,
                    focusedTextColor = White,
                    unfocusedTextColor = Color.Gray,
                    focusedBorderColor = Orange,
                    unfocusedBorderColor = Orange,
                ),
                modifier = Modifier.fillMaxWidth(),
            )
            // Кнопка
            Button(
                onClick = { /* Обработчик нажатия */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                colors = ButtonColors(
                    contentColor = Color.White,
                    containerColor = Orange,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.DarkGray
                )
            ) {
                Text("Создать", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}