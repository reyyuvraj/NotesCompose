package com.example.notescompose.featurenote.domain.usecase

import com.example.notescompose.featurenote.domain.model.InvalidNoteException
import com.example.notescompose.featurenote.domain.model.Note
import com.example.notescompose.featurenote.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }

        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}