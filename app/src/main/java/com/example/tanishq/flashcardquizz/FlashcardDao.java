package com.example.tanishq.flashcardquizz;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface FlashcardDao {
    @Query("SELECT * FROM Flashcard")
    List<Flashcard> getAll();

    @Insert
    void insertAll(Flashcard flashcards);

    @Delete
    void delete(Flashcard flashcard);

}
