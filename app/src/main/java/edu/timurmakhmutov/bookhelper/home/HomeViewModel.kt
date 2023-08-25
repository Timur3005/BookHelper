package edu.timurmakhmutov.bookhelper.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import edu.timurmakhmutov.bookhelper.model.Book
import edu.timurmakhmutov.bookhelper.model.MainDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel(application: Application): AndroidViewModel(application) {

    init {
        showAllBooks()
    }

    val booksLiveData = MutableLiveData<List<Book>>()

    private val db = MainDB.getDB(application)



    fun showAllBooks(){
        GlobalScope.launch(Dispatchers.Main) {
            db.getDao().getAllBooks().asLiveData().observeForever {
                booksLiveData.value = it
            }
        }
    }

    fun deleteBook(book: Book){
        GlobalScope.launch {
            db.getDao().deleteBook(book)
        }
    }

}