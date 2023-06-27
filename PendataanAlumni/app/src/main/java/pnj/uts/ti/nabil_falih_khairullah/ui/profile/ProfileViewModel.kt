package pnj.uts.ti.nabil_falih_khairullah.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Data Diri Pengguna"
    }
    val text: LiveData<String> = _text
}