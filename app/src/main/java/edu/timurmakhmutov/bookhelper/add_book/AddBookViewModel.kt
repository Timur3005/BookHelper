package edu.timurmakhmutov.bookhelper.add_book

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import edu.timurmakhmutov.bookhelper.model.Book
import edu.timurmakhmutov.bookhelper.model.MainDB
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddBookViewModel(application: Application): AndroidViewModel(application) {

    private val db = MainDB.getDB(application)

    fun insertBook(book: Book){
        GlobalScope.launch {
            db.getDao().insertBook(book)
        }
    }

}