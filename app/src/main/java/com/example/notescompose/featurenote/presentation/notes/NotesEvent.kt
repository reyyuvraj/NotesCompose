package com.example.notescompose.featurenote.presentation.notes

import com.example.notescompose.featurenote.domain.model.Note
import com.example.notescompose.featurenote.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}
