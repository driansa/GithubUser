package com.drians.android.githubuser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.drians.android.githubuser.R
import com.drians.android.githubuser.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter (private val context: Context, private val user: List<User>,
                   private val listener: (User) -> Unit)
    : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.item_user, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(user[position], listener)
    }

    override fun getItemCount(): Int = user.size

    class ViewHolder (containerView: View) : RecyclerView.ViewHolder(containerView){
        fun bind(user: User, listener: (User) -> Unit) {
            with(itemView){
                txt_location.text = user.location
                txt_name.text = user.name
                user.avatar?.let { Glide.with(itemView).load(it).into(itemView.img_avatar) }
                setOnClickListener { listener(user) }
            }
        }
    }

}