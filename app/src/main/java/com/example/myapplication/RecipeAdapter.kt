package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.Recipe

class RecipeAdapter(
    private var recipes: List<Recipe>,
    private val listener: OnRecipeClickListener
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    fun updateRecipes(newRecipes: List<Recipe>) {
        recipes = newRecipes
        notifyDataSetChanged()
    }

    interface OnRecipeClickListener {
        fun onItemClicked(recipeId: Int)
        fun onActionClicked(recipeId: Int, action: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount() = recipes.size

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.recipe_image)
        private val textView: TextView = itemView.findViewById(R.id.recipe_name)
        private val likeButton: Button = itemView.findViewById(R.id.like_button)

        fun bind(recipe: Recipe) {
            imageView.setImageResource(recipe.imageResId)
            textView.text = recipe.name
            itemView.setOnClickListener {
                listener.onItemClicked(recipe.id)
            }
            likeButton.setOnClickListener {
                listener.onActionClicked(recipe.id, "like")
            }
        }
    }


}