package com.example.notescompose.di

import android.app.Application
import androidx.room.Room
import com.example.notescompose.featurenote.data.datasource.NoteDatabase
import com.example.notescompose.featurenote.data.repository.NoteRepositoryImpl
import com.example.notescompose.featurenote.domain.repository.NoteRepository
import com.example.notescompose.featurenote.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }// we can inject these use-cases into view-model and access these two use cases
}
// if you have many features then we can have one module per feature
