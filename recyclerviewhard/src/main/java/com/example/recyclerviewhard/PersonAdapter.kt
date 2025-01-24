package com.example.recyclerviewhard

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PersonAdapter(private var context: Context) :
    RecyclerView.Adapter<PersonAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var data: List<Person> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView1: ImageView = itemView.findViewById(R.id.imageView1)
        var nameTextView1: TextView = itemView.findViewById(R.id.nameTextView1)
        var companyTextView1: TextView = itemView.findViewById(R.id.companyTextView1)
        val likedImageView: ImageView = itemView.findViewById(R.id.likedImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = inflater.inflate(R.layout.item_person, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val person = data[position]

        val color =
            if (person.isLiked) R.color.red else R.color.gray // Цвет "сердца", если пользователь был лайкнут

        holder.nameTextView1 = person.name as TextView
        holder.companyTextView1 = person.companyName as TextView // Отрисовка компании пользователя
        holder.likedImageView.setColorFilter( // Отрисовка цвета "сердца"
            ContextCompat.getColor(context, color),
            android.graphics.PorterDuff.Mode.SRC_IN
        )
        Glide.with(context).load(person.photo)
            .circleCrop() // Отрисовка фотографии пользователя с помощью библиотеки Glide
            .error(R.drawable.ic_launcher_background)
            .into(holder.imageView1)
    }

}