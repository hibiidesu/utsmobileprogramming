package pnj.uts.ti.nabil_falih_khairullah.ui.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import pnj.uts.ti.nabil_falih_khairullah.R

class NewsDetail : AppCompatActivity() {

//    private val newsDetailViewModel by viewModels<NewsDetailViewModel> {
//        NewsListDetailViewModelFactory(this)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

//        var currentNewsId: Long? = null

        val newsTitle: TextView = findViewById(R.id.news_detail_name)
        val newsImage: ImageView = findViewById(R.id.news_detail_image)
        val newsContent: TextView = findViewById(R.id.news_detail_content)
        val exitButton: Button = findViewById(R.id.news_detail_button)

        newsImage.setImageResource(intent.getIntExtra("image", 0))
        newsTitle.setText(intent.getStringExtra("title"))
        newsContent.setText(intent.getStringExtra("content"))

        exitButton.setOnClickListener{finish()}

//        val bundle: Bundle? = intent.extras
//        if (bundle != null) {
//            currentNewsId = bundle.getLong(NEWS_ID)
//        }
//
//        currentNewsId?.let {
//            val currentNews = newsDetailViewModel.getNewsForId(it)
//            newsTitle.text = currentNews?.title
//            if (currentNews?.image == null) {
//                newsImage.setImageResource(R.drawable.pnj)
//            } else {
//                newsImage.setImageResource(currentNews.image)
//            }
//            newsContent.text = currentNews?.content
//
//            exitButton.setOnClickListener{finish()}
//        }
    }
}