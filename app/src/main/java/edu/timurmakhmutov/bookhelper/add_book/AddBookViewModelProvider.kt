package edu.timurmakhmutov.bookhelper.add_book

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddBookViewModelProvider(private val application: Application): ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddBookViewModel(application) as T
    }
}