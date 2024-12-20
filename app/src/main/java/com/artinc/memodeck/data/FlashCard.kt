package com.artinc.memodeck.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flashcards")
data class Flashcard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val categoryId: Int,
    val question: String,
    val answer: String,
)