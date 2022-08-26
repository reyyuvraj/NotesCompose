package com.example.notescompose.featurenote.presentation.notes

import com.example.notescompose.featurenote.domain.model.Note
import com.example.notescompose.featurenote.domain.util.NoteOrder
import com.example.notescompose.featurenote.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
