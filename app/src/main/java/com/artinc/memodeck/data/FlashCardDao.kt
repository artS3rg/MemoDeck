package com.artinc.memodeck.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FlashcardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: Flashcard)

    @Query("SELECT * FROM flashcards WHERE category = :category")
    fun getCardsByCategory(category: String): Flow<List<Flashcard>>

    @Query("SELECT * FROM flashcards")
    fun getAllCards(): Flow<List<Flashcard>>
}
