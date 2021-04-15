package com.nadhifa.finalnewsprojectapp

import android.content.Context
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nadhifa.finalnewsprojectapp.model.ArticlesItem
import kotlinx.android.synthetic.main.list_news_item.view.*

class NewsAdapter(var context: Context,var listNews: List<ArticlesItem?>?) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(news: ArticlesItem) {
            with(itemView) {
                tv_title_items.text = news.title
                tv_date_item.text = news.publishedAt
                tv_duration_item.text = news.author

                Glide.with(context).load(news.urlToImage).centerCrop().into(iv_item_news)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(listNews?.get(position)!!)
    }

    override fun getItemCount(): Int = listNews!!.size

}
