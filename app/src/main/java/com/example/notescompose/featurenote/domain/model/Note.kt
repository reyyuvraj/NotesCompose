package com.example.notescompose.featurenote.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(Color.Blue, Color.Cyan, Color.LightGray, Color.Black)
    }
}

class InvalidNoteException(message: String): Exception(message)
