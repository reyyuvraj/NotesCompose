package com.example.notescompose.featurenote.domain.usecase

import com.example.notescompose.featurenote.domain.model.Note
import com.example.notescompose.featurenote.domain.repository.NoteRepository
import com.example.notescompose.featurenote.domain.util.NoteOrder
import com.example.notescompose.featurenote.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(private val repository: NoteRepository) {

    //whichever view-model calls this should be able to tell what ordering it wants
    //and the function should return the list in the requested format
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when(noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }

                is OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}
//use cases should only have one single function that should be called from the outside , they
//can have private function to make code more readable but only one public function
//operator invoke helps in calling our class like a function
