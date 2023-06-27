package pnj.uts.ti.nabil_falih_khairullah.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _textTitle = MutableLiveData<String>().apply {
        value = "Aplikasi Alumni"
    }
    val textTitle: LiveData<String> = _textTitle

    private val _textContent = MutableLiveData<String>().apply {
        value = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pellentesque fringilla odio a congue. Morbi a consequat ex. Quisque ac maximus massa. Sed tellus turpis, efficitur nec nunc pellentesque, rutrum lacinia neque. Nam non purus interdum, maximus diam quis, posuere sem. Phasellus sagittis eros massa, quis mollis risus gravida vitae. Phasellus pretium elementum mi in aliquet. In ac commodo sapien. Donec sapien sem, convallis eget turpis a, varius fringilla tellus. Praesent a feugiat nulla, in ullamcorper libero. Duis eu enim nec arcu posuere condimentum. Donec sit amet metus sed velit varius volutpat. Proin a pretium metus. Nunc ut ligula quis dui tempus porttitor ut hendrerit diam. Nullam est urna, consectetur rhoncus commodo ut, dictum in neque. Donec quis volutpat velit, sed ultrices lorem."
    }
    val textContent: LiveData<String> = _textContent
}