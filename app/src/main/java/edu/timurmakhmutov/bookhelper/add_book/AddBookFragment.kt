package edu.timurmakhmutov.bookhelper.add_book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import edu.timurmakhmutov.bookhelper.R
import edu.timurmakhmutov.bookhelper.databinding.FragmentAddBookBinding
import edu.timurmakhmutov.bookhelper.databinding.FragmentHomeBinding
import edu.timurmakhmutov.bookhelper.model.Book

class AddBookFragment : Fragment() {

    private lateinit var binding: FragmentAddBookBinding
    private lateinit var viewModel: AddBookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentAddBookBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, AddBookViewModelProvider(activity?.application!!))[AddBookViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAddBook.setOnClickListener {
            insertBook(Book(null, binding.bookName.text.toString(), binding.progressList.text.toString().toInt(),
            binding.maxList.text.toString().toInt(), binding.review.text.toString())
            ) { navigate() }
        }
    }

    private fun insertBook(book: Book, nav: () -> Unit){
        viewModel.insertBook(book)
        nav()
    }

    private fun navigate(){
        findNavController().navigate(R.id.action_addBookFragment_to_homeFragment)
    }
}