package edu.timurmakhmutov.bookhelper.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import edu.timurmakhmutov.bookhelper.model.Book
import edu.timurmakhmutov.bookhelper.model.MainDB
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel(application: Application): AndroidViewModel(application) {

    private val booksLiveData = MutableLiveData<List<Book>>()

    private val db = MainDB.getDB(application)

    private fun showAllBooks(){
        GlobalScope.launch {
            db.getDao().getAllBooks().asLiveData().observeForever {
                booksLiveData.value = it
            }
        }
    }

    private fun deleteBook(book: Book){
        GlobalScope.launch {
            db.getDao().deleteBook(book)
        }
    }

}