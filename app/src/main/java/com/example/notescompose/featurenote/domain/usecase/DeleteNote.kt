package com.example.notescompose.featurenote.domain.usecase

import com.example.notescompose.featurenote.domain.model.Note
import com.example.notescompose.featurenote.domain.repository.NoteRepository

class DeleteNote(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}
