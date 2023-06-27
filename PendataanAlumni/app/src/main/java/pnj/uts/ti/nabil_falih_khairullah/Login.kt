package pnj.uts.ti.nabil_falih_khairullah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class Login : AppCompatActivity() {

    //Defining layout using lateinit cuz its "best code practices"
    private lateinit var logo: ImageView
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    //initializing layout components
    private fun initComponents(){
        logo = findViewById(R.id.logo)
        emailEditText = findViewById(R.id.emailEdit)
        passwordEditText = findViewById(R.id.passwordEdit)
        loginButton = findViewById(R.id.loginButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initComponents()
        logo.setImageResource(R.drawable.pnj)
        //when button pressed verification starts
        loginButton.setOnClickListener{ verification() }
    }

    private fun verification(): Boolean{
        //Hardcoded user info
        val trueEmail = "falih@pnj.com"
        val truePassword = "12345678"

        //User info from input
        val curEmail = emailEditText.text.toString()
        val curPassword  = passwordEditText.text.toString()
        Log.i("checks", curEmail)
        Log.i("checks", curPassword)

        //If conditional for verify
        if (curEmail != trueEmail){
            Toast.makeText(applicationContext, "Email anda salah!", Toast.LENGTH_SHORT).show()
            return false
        }
        else if (curPassword != truePassword){
            Toast.makeText(applicationContext, "Password anda salah!", Toast.LENGTH_SHORT).show()
            return false
        }

        //writing shared preference
        val sharedPref = getSharedPreferences("userInfo", MODE_PRIVATE)
        with (sharedPref.edit()) {
            putString("userEmail", trueEmail)
            putString("userNIM", "2107411060")
            putString("userNama", "Nabil Falih Khairullah")
            putString("userKelas", "TI4B")
            apply()
        }

        //Intent to open MainActivity
        val sendIntent = Intent(this, Container::class.java)
        startActivity(sendIntent)
        return true
    }
}