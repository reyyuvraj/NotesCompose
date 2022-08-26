package com.example.notescompose.featurenote.domain.usecase

import com.example.notescompose.featurenote.domain.model.Note
import com.example.notescompose.featurenote.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int) : Note? {
        return repository.getNoteById(id)
    }
}