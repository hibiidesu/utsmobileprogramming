package pnj.uts.ti.nabil_falih_khairullah

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import pnj.uts.ti.nabil_falih_khairullah.alumni.AddAlumniActivity
import pnj.uts.ti.nabil_falih_khairullah.alumni.AlumniList
import pnj.uts.ti.nabil_falih_khairullah.databinding.ActivityContainerBinding

class Container : AppCompatActivity() {

    private lateinit var binding: ActivityContainerBinding
    private lateinit var sharedPref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = getSharedPreferences("User_Info", MODE_PRIVATE)

        binding = ActivityContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_container)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_news, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.optionAddAlumni -> {
                val sendIntent = Intent(this, AddAlumniActivity::class.java)
                startActivity(sendIntent)
                true
            }
            R.id.optionAlumni -> {
                val sendIntent = Intent(this, AlumniList::class.java)
                startActivity(sendIntent)
                true
            }
            R.id.optionLogout -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun logout(){
        sharedPref.edit().clear().apply()
        finish()
    }
}