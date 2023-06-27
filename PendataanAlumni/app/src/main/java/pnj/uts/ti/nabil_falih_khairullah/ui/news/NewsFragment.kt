package pnj.uts.ti.nabil_falih_khairullah.ui.news

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pnj.uts.ti.nabil_falih_khairullah.databinding.FragmentNewsBinding
import pnj.uts.ti.nabil_falih_khairullah.ui.news.data.NewsClass

const val NEWS_ID = "news id"

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val newsViewModel =
//            ViewModelProvider(this).get(NewsViewModel::class.java)

        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textNews
//        newsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        val newsAdapter = NewsAdapter { newsClass -> adapterOnClick(newsClass) }
        val recycleView = binding.recyclerView
        recycleView.adapter = newsAdapter

//        newsViewModel.newsLiveData.observe(viewLifecycleOwner, {
//            it?.let {
//                newsAdapter.submitList(it as MutableList<NewsClass>)
//            }
//        })

        return root
    }

    private fun adapterOnClick(news: NewsClass) {
        val intent = Intent(context, NewsDetail::class.java)
        intent.putExtra("image", news.image)
        intent.putExtra("title", news.title)
        intent.putExtra("content", news.content)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}