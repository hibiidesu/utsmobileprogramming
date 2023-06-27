package pnj.uts.ti.nabil_falih_khairullah.ui.profile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pnj.uts.ti.nabil_falih_khairullah.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private lateinit var sharedPref: SharedPreferences

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = pnj.uts.ti.nabil_falih_khairullah.databinding.FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textView: TextView = binding.textProfile
        profileViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.logoutButton.setOnClickListener(){
            logout()
        }

        val sharedPref = activity?.getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        val sharedEmail = sharedPref?.getString("userEmail", "")
        val sharedNIM =  sharedPref?.getString("userNIM", "")
        val sharedNama =  sharedPref?.getString("userNama", "")
        val sharedKelas =  sharedPref?.getString("userKelas", "")

        binding.emailText.text = sharedEmail
        binding.nimText.text = sharedNIM
        binding.namaText.text = sharedNama
        binding.kelasText.text = sharedKelas
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun logout(){
        sharedPref.edit().clear().apply()
        activity?.finish()
    }
}