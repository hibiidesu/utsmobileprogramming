package pnj.uts.ti.nabil_falih_khairullah.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pnj.uts.ti.nabil_falih_khairullah.R
import pnj.uts.ti.nabil_falih_khairullah.ui.news.data.NewsClass
import pnj.uts.ti.nabil_falih_khairullah.ui.news.data.NewsData

class NewsAdapter(private val onClick: (NewsClass) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

        class NewsViewHolder(itemView: View, val onClick: (NewsClass) -> Unit) :
                RecyclerView.ViewHolder(itemView) {
                    private val newsText: TextView = itemView.findViewById(R.id.news_text)
                    private val newsImage: ImageView = itemView.findViewById(R.id.news_image)
                    private var currentNews: NewsClass? = null

                    init {
                        itemView.setOnClickListener{
                            currentNews?.let{
                                onClick(it)
                            }
                        }
                    }

                    fun bind(news: NewsClass) {
                        currentNews = news

                        newsText.text = news.title
                        if (news.image != null) {
                            newsImage.setImageResource(news.image)
                        } else {
                            newsImage.setImageResource(R.drawable.pnj)
                        }
                    }
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view, onClick)
    }

    override fun getItemCount(): Int {
        return NewsData().loadData().count()
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
//            val news = getItem(position)
            val dataset = NewsData().loadData()
            val news = dataset[position]
            holder.bind(news)
        }
    }

object NewsDiffCallback : DiffUtil.ItemCallback<NewsClass>(){
    override fun areItemsTheSame(oldItem: NewsClass, newItem: NewsClass): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NewsClass, newItem: NewsClass): Boolean {
        return oldItem.id == newItem.id
    }
}