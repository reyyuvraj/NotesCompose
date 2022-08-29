package com.example.notescompose.featurenote.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notescompose.ui.theme.SkyBlue
import com.example.notescompose.ui.theme.Teal

@Entity
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(SkyBlue, Color.Cyan, Color.LightGray, Teal)
    }
}

class InvalidNoteException(message: String) : Exception(message)
