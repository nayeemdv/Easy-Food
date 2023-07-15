package com.example.easyfood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.easyfood.databinding.PopularItemsBinding
import com.example.easyfood.pojo.MealByCategory

class MostPopularAdapter : RecyclerView.Adapter<MostPopularAdapter.MostPopularViewHolder>() {
    lateinit var onItemClick:((MealByCategory) -> Unit)

    //we have two option either pass it through constructor or assign like this
    private var mealList = ArrayList<MealByCategory>()
    fun setMeals(mealList: ArrayList<MealByCategory>) {
        this.mealList = mealList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularViewHolder {
        return MostPopularViewHolder(
            PopularItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    override fun onBindViewHolder(holder: MostPopularViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(mealList[position].strMealThumb)
            .into(holder.binding.imgPopularMealItem)
        holder.itemView.setOnClickListener {
            onItemClick.invoke(mealList[position])
        }
    }

    inner class MostPopularViewHolder( val binding: PopularItemsBinding) :
        RecyclerView.ViewHolder(binding.root)
}