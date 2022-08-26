package com.example.notescompose.featurenote.domain.usecase

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote,
    val getNote: GetNote
) // this is the class that we inject into the view-model
