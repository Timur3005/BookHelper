package edu.timurmakhmutov.bookhelper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.timurmakhmutov.bookhelper.R
import edu.timurmakhmutov.bookhelper.databinding.BookItemBinding
import edu.timurmakhmutov.bookhelper.model.Book

class MainBooksAdapter(private val listener: Listener) :
    ListAdapter<Book, MainBooksAdapter.MainViewHolder>(Comparator()) {

    class Comparator:DiffUtil.ItemCallback<Book>(){
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem==newItem
        }

    }

    class MainViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        private val binding = BookItemBinding.bind(view)
        fun bind(book: Book, listener: Listener){
            with(binding){
                bookName.text = book.name
                bookName.setOnClickListener {
                    listener.onClick(book)
                }
                bookName.setOnLongClickListener {
                    listener.longOnClick(book, view)
                    true
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    interface Listener{
        fun onClick(book: Book)
        fun longOnClick(book: Book, view: View)
    }
}