package com.artinc.memodeck.data

@Dao
interface FlashcardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: Flashcard)

    @Query("SELECT * FROM flashcards WHERE category = :category")
    fun getCardsByCategory(category: String): Flow<List<Flashcard>>

    @Query("SELECT * FROM flashcards")
    fun getAllCards(): Flow<List<Flashcard>>
}
