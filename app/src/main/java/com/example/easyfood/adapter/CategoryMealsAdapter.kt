package com.example.easyfood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easyfood.databinding.MealItemsBinding
import com.example.easyfood.pojo.MealByCategory

class CategoryMealsAdapter :
    RecyclerView.Adapter<CategoryMealsAdapter.CategoryMealsViewHolder>() {
    lateinit var onItemClick:((MealByCategory) -> Unit)
    private var mealsList = ArrayList<MealByCategory>()

    fun setMealsList(mealsList: List<MealByCategory>) {
        this.mealsList = mealsList as ArrayList<MealByCategory>
        notifyDataSetChanged()
    }


    inner class CategoryMealsViewHolder(val binding: MealItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMealsViewHolder {
        return CategoryMealsViewHolder(
            MealItemsBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return mealsList.size
    }

    override fun onBindViewHolder(holder: CategoryMealsViewHolder, position: Int) {
        Glide.with(holder.itemView).load(mealsList[position].strMealThumb)
            .into(holder.binding.ivMealImg)
        holder.binding.tvMealTitle.text = mealsList[position].strMeal

        holder.itemView.setOnClickListener {
            onItemClick.invoke(mealsList[position])
        }
    }
}