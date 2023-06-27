package pnj.uts.ti.nabil_falih_khairullah.alumni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import pnj.uts.ti.nabil_falih_khairullah.SqliteService
import pnj.uts.ti.nabil_falih_khairullah.databinding.ActivityAlumniListBinding

class AlumniList : AppCompatActivity() {

    private lateinit var binding: ActivityAlumniListBinding
    private lateinit var sqliteService: SqliteService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlumniListBinding.inflate(layoutInflater)
        sqliteService = SqliteService(this)
        setContentView(binding.root)

        val alumniAdapter = AlumniAdapter { alumniClass -> adapterOnClick(alumniClass) }
        alumniAdapter.setItems(sqliteService.readAlumni())
        binding.recyclerView.adapter = alumniAdapter
    }

    private fun adapterOnClick(alumni: AlumniClass) {
//        val intent = Intent(this, AlumniDetail::class.java)
//        intent.putExtra("nim", alumni.nim)
//        intent.putExtra("name", alumni.name)
//        intent.putExtra("bdayPlace", alumni.bdayPlace)
//        intent.putExtra("bdayDate", alumni.bdayDate)
//        intent.putExtra("address", alumni.address)
//        intent.putExtra("religion", alumni.religion)
//        intent.putExtra("phone", alumni.phone)
//        intent.putExtra("entryYear", alumni.entryYear)
//        intent.putExtra("gradYear", alumni.gradYear)
//        intent.putExtra("job", alumni.job)
//        intent.putExtra("position", alumni.position)
//
//        startActivity(intent)
    }
}