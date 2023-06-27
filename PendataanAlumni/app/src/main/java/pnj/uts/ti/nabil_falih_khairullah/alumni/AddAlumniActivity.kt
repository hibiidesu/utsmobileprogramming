package pnj.uts.ti.nabil_falih_khairullah.alumni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import pnj.uts.ti.nabil_falih_khairullah.Container
import pnj.uts.ti.nabil_falih_khairullah.R
import pnj.uts.ti.nabil_falih_khairullah.SqliteService

class AddAlumniActivity : AppCompatActivity() {

    private lateinit var nimAlumni: EditText
    private lateinit var nameAlumni: EditText
    private lateinit var bdayPlaceAlumni: EditText
    private lateinit var bdayDateAlumni: EditText
    private lateinit var addressAlumni: EditText
    private lateinit var religionAlumni: EditText
    private lateinit var phoneAlumni: EditText
    private lateinit var entryYearAlumni: EditText
    private lateinit var gradYearAlumni: EditText
    private lateinit var jobAlumni: EditText
    private lateinit var positionAlumni: EditText
    private lateinit var saveAlumni: Button
    private lateinit var sqliteService: SqliteService

    private fun initComponents(){
        nimAlumni = findViewById(R.id.nimEdit)
        nameAlumni = findViewById(R.id.nameEdit)
        bdayPlaceAlumni = findViewById(R.id.bdayPlaceEdit)
        bdayDateAlumni = findViewById(R.id.bdayDateEdit)
        addressAlumni = findViewById(R.id.addressEdit)
        religionAlumni = findViewById(R.id.religionEdit)
        phoneAlumni = findViewById(R.id.phoneEdit)
        entryYearAlumni = findViewById(R.id.entryYearEdit)
        gradYearAlumni = findViewById(R.id.gradYearEdit)
        jobAlumni = findViewById(R.id.jobEdit)
        positionAlumni = findViewById(R.id.positionEdit)
        saveAlumni = findViewById(R.id.saveButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_alumni)
        sqliteService = SqliteService(this)

        initComponents()
        saveAlumni.setOnClickListener{
            val alumniClass = AlumniClass(
                nim = nimAlumni.text.toString(),
                name = nameAlumni.text.toString(),
                bdayPlace = bdayPlaceAlumni.text.toString(),
                bdayDate = bdayDateAlumni.text.toString(),
                address = addressAlumni.text.toString(),
                religion = religionAlumni.text.toString(),
                phone = phoneAlumni.text.toString(),
                entryYear = entryYearAlumni.text.toString(),
                gradYear = gradYearAlumni.text.toString(),
                job = jobAlumni.text.toString(),
                position = positionAlumni.text.toString()
            )
            val savedData = sqliteService.addAlumni(alumniClass)
            if (savedData > -1){
                finish()
                val sendIntent = Intent(this, Container::class.java)
                startActivity(sendIntent)
            } else {
                Toast.makeText(this, "Gagal Menambahkan Data Alumni", Toast.LENGTH_SHORT)
            }
        }
    }
}