package com.example.myapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.models.Recipe
import com.example.myapplication.models.RecipeViewModel

class RecipeDetailFragment : Fragment() {

    private lateinit var recipeImageView: ImageView
    private lateinit var recipeNameTextView: TextView
    private lateinit var recipeDescriptionTextView: TextView
    private val viewModel: RecipeViewModel by viewModels()


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipe_detail, container, false)

        recipeImageView = view.findViewById(R.id.recipe_image)
        recipeNameTextView = view.findViewById(R.id.recipe_name)
        recipeDescriptionTextView = view.findViewById(R.id.recipe_description)

        val recipeId = arguments?.getInt("recipeId")
        recipeId?.let {
            observeRecipeDetail(it)
        }

        return view
    }

    private fun observeRecipeDetail(recipeId: Int) {
        val recipe = viewModel.getRecipeById(recipeId)
        recipe?.let {
            recipeImageView.setImageResource(it.imageResId)
            recipeNameTextView.text = it.name
            recipeDescriptionTextView.text = it.description
        }
    }
}