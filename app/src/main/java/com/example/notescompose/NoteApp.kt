package com.example.notescompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NoteApp: Application()
// to inject dependencies we need to provide these in modules
// in module we provide the dependencies that we need to provide with
// the given lifetime of these dependencies
