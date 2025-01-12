package com.example.myapplication.models

import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import com.example.myapplication.models.Recipe

class RecipeViewModel : ViewModel() {
    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes

    private val allRecipes = listOf(
        Recipe(1, "Pasta", "Delicious pasta with tomato sauce", R.drawable.pasta),
        Recipe(2, "Pizza", "Cheesy pizza with pepperoni", R.drawable.pizza),
        Recipe(3, "Burger", "Juicy burger with fresh lettuce", R.drawable.burger)
    )

    fun search(query: String) {
        if (query.length < 3) {
            _recipes.value = allRecipes
        } else {
            _recipes.update {
                allRecipes.filter {
                    it.name.contains(query, ignoreCase = true) || it.description.contains(query, ignoreCase = true)
                }
            }
        }
    }

    init {
        _recipes.value = allRecipes
    }

    fun getRecipeById(recipeId: Int): Recipe? {
        return allRecipes.find { it.id == recipeId }
    }
}