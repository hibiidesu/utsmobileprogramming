package pnj.uts.ti.nabil_falih_khairullah.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pnj.uts.ti.nabil_falih_khairullah.ui.news.data.NewsDataSource

class NewsViewModel(val dataSource: NewsDataSource) : ViewModel() {

//    val newsLiveData = dataSource.getNewsList()

    private val _text = MutableLiveData<String>().apply {
        value = "Daftar Berita terkini"
    }
    val text: LiveData<String> = _text
}
//
//class NewsListViewModelFactory(private val context: NewsFragment) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return NewsViewModel(
//                dataSource = NewsDataSource.getDataSource(context.resources)
//                    ) as T
//        }
//        throw IllegalArgumentException("Unknown viewmodel class")
//    }
//}