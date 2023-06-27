package pnj.uts.ti.nabil_falih_khairullah.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pnj.uts.ti.nabil_falih_khairullah.ui.news.data.NewsClass
import pnj.uts.ti.nabil_falih_khairullah.ui.news.data.NewsDataSource

class NewsDetailViewModel(private val dataSource: NewsDataSource): ViewModel() {

//    fun getNewsForId(id: Long) : NewsClass? {
//        return dataSource.getNewsForId(id)
//    }
}

//class NewsListDetailViewModelFactory(private val context: NewsDetail) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(NewsDetailViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return NewsDetailViewModel(
//                dataSource = NewsDataSource.getDataSource(context.resources)
//            ) as T
//        }
//        throw IllegalArgumentException("Unknown viewmodel class")
//    }
//}