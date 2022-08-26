package com.example.notescompose.featurenote.presentation.addeditnote

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)