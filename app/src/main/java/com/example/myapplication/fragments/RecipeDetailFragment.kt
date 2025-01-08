package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.models.Recipe

class RecipeDetailFragment : Fragment() {

    private lateinit var recipeImageView: ImageView
    private lateinit var recipeNameTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipe_detail, container, false)

        recipeImageView = view.findViewById(R.id.recipe_image)
        recipeNameTextView = view.findViewById(R.id.recipe_name)


        val recipeId = arguments?.getInt("recipeId")
        val recipe = getRecipeById(recipeId)

        recipe?.let {
            recipeImageView.setImageResource(it.imageResId)
            recipeNameTextView.text = it.name
        }

        return view
    }

    private fun getRecipeById(recipeId: Int?): Recipe? {
        return recipeId?.let { id ->
            listOf(
                Recipe(1, "Pasta Description", R.drawable.pasta),
                Recipe(2, "Pizza  Description", R.drawable.pizza),
                Recipe(3, "Burger Description", R.drawable.burger)
            ).find { it.id == id }
        }
    }
}