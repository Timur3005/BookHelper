package edu.timurmakhmutov.bookhelper.home

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.timurmakhmutov.bookhelper.R
import edu.timurmakhmutov.bookhelper.adapters.MainBooksAdapter
import edu.timurmakhmutov.bookhelper.databinding.FragmentHomeBinding
import edu.timurmakhmutov.bookhelper.model.Book

class HomeFragment : Fragment(), MainBooksAdapter.Listener {

    private lateinit var adapter: MainBooksAdapter
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, HomeViewModelFactory(activity?.application!!))[HomeViewModel::class.java]



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        updateData()
    }

    private fun initRecycler(){
        adapter = MainBooksAdapter(this)
        binding.usersBooks.layoutManager = LinearLayoutManager(context)
        binding.usersBooks.adapter = adapter

    }

    private fun updateData(){
        viewModel.booksLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

    override fun onClick(book: Book) {
        TODO("Not yet implemented")
    }

    override fun longOnClick(book: Book, view: View) {
        viewModel.deleteBook(book)
    }

}