package com.example.myapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.RecipeAdapter
import com.example.myapplication.models.Recipe

class RecipeListFragment : Fragment(), RecipeAdapter.OnRecipeClickListener {

    private lateinit var recyclerView: RecyclerView
    private val recipes = listOf(
        Recipe(1, "Pasta", R.drawable.pasta),
        Recipe(2, "Pizza", R.drawable.pizza),
        Recipe(3, "Burger", R.drawable.burger)
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipe_list, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)

        val adapter = RecipeAdapter(recipes, this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return view
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