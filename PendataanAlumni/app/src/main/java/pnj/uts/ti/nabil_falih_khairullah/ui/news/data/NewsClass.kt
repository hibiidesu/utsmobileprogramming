package pnj.uts.ti.nabil_falih_khairullah.ui.news.data

import androidx.annotation.DrawableRes

data class NewsClass (
    val id: Long,
    @DrawableRes
    val image: Int?,
    val title: String,
    val content: String
)