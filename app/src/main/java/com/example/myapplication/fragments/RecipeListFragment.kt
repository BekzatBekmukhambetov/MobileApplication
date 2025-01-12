package com.example.myapplication.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.RecipeAdapter
import com.example.myapplication.models.Recipe
import com.example.myapplication.models.RecipeViewModel
import kotlinx.coroutines.launch

class RecipeListFragment : Fragment(), RecipeAdapter.OnRecipeClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private val viewModel: RecipeViewModel by viewModels()

    private val adapter by lazy { RecipeAdapter(emptyList(), this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipe_list, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        searchView = view.findViewById(R.id.search_view)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        setupSearchView()
        observeRecipes()

        return view
    }

    private fun setupSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.search(newText.orEmpty())
                return true
            }
        })
    }

    private fun observeRecipes() {
        lifecycleScope.launch {
            viewModel.recipes.collect { recipes ->
                adapter.updateRecipes(recipes)
            }
        }
    }

    override fun onItemClicked(recipeId: Int) {
        val fragment = RecipeDetailFragment().apply {
            arguments = Bundle().apply {
                putInt("recipeId", recipeId)
            }
        }
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onActionClicked(recipeId: Int, action: String) {
        Toast.makeText(requireContext(), "Action $action on item $recipeId", Toast.LENGTH_SHORT).show()
    }
}