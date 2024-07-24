package com.example.tanishq.flashcardquizz;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Flashcard.class}, version = 1, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FlashcardDao flashcardDao();
}
