package pnj.uts.ti.nabil_falih_khairullah

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import pnj.uts.ti.nabil_falih_khairullah.SqliteService.Companion.TABLE_NAME
import pnj.uts.ti.nabil_falih_khairullah.alumni.AlumniClass


class SqliteService(context: Context) : SQLiteOpenHelper(context, DBNAME, null, DBVER) {
    companion object {
        const val DBVER = 1
        const val DBNAME = "alumni.db"
        const val TABLE_NAME = "alumni"
        const val ID = "id"
        const val NAME = "nama"
        const val NIM = "nim"
        const val BDAY_PLACE = "tempat_lahir"
        const val BDAY_DATE = "tanggal_lahir"
        const val ADDRESS = "alamat"
        const val RELIGION = "agama"
        const val PHONE = "telp"
        const val ENTRY_YEAR = "tahun_masuk"
        const val GRAD_YEAR = "tahun_lulus"
        const val JOB = "pekerjaan"
        const val POSITION = "jabatan"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${TABLE_NAME} (" +
                    "${ID} INTEGER PRIMARY KEY," +
                    "${NIM} TEXT," +
                    "${NAME} TEXT," +
                    "${BDAY_PLACE} TEXT," +
                    "${BDAY_DATE} TEXT," +
                    "${ADDRESS} TEXT," +
                    "${RELIGION} TEXT," +
                    "${PHONE} TEXT," +
                    "${ENTRY_YEAR} TEXT," +
                    "${GRAD_YEAR} TEXT," +
                    "${JOB} TEXT," +
                    "${POSITION} TEXT)"
        db!!.execSQL(SQL_CREATE_ENTRIES)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLE_NAME}"
        db!!.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    fun addAlumni(alumni:AlumniClass):Long {

        // Gets the data repository in write mode
        val db = this.writableDatabase

        // Create a new map of values, where column names are the keys
        val values = ContentValues()
        values.put(ID, alumni.id)
        values.put(NIM, alumni.nim)
        values.put(NAME, alumni.name)
        values.put(BDAY_PLACE, alumni.bdayPlace)
        values.put(BDAY_DATE, alumni.bdayDate)
        values.put(ADDRESS, alumni.address)
        values.put(RELIGION, alumni.religion)
        values.put(PHONE, alumni.phone)
        values.put(ENTRY_YEAR, alumni.entryYear)
        values.put(GRAD_YEAR, alumni.gradYear)
        values.put(JOB, alumni.job)
        values.put(POSITION, alumni.position)



        // Insert the new row, returning the primary key value of the new row
        val newRowId = db.insert(TABLE_NAME, null, values)
        Log.i("newId", newRowId.toString())
        db.close()
        return newRowId
    }

    @SuppressLint("Range")
    fun readAlumni(): ArrayList<AlumniClass> {
        val db = this.readableDatabase

        val alumniList: ArrayList<AlumniClass> = ArrayList()

        val query = "SELECT * FROM $TABLE_NAME"
        var cursor: Cursor?
        try {
            cursor = db.rawQuery(query, null)
        } catch (e:Exception){
            db.execSQL(query)
            return ArrayList()
        }

        Log.i("cursor", cursor.count.toString())

        var id: Int
        var nim: String
        var namaAlumni: String
        var tempatLahir: String
        var tanggalLahir: String
        var alamat: String
        var agama: String
        var noTelepon: String
        var tahunLulus: String
        var tahunMasuk: String
        var pekerjaan: String
        var jabatan: String
        if (cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                nim = cursor.getString(cursor.getColumnIndex( "nim"))
                namaAlumni = cursor.getString(cursor.getColumnIndex( "nama"))
                tempatLahir = cursor.getString(cursor.getColumnIndex( "tempat_lahir"))
                tanggalLahir = cursor.getString(cursor.getColumnIndex( "tanggal_lahir"))
                alamat = cursor.getString(cursor.getColumnIndex( "alamat"))
                agama = cursor.getString(cursor.getColumnIndex( "agama"))
                noTelepon = cursor.getString(cursor.getColumnIndex( "telp"))
                tahunLulus = cursor.getString(cursor.getColumnIndex( "tahun_lulus"))
                tahunMasuk = cursor.getString(cursor.getColumnIndex( "tahun_masuk"))
                pekerjaan = cursor.getString(cursor.getColumnIndex( "pekerjaan"))
                jabatan = cursor.getString(cursor.getColumnIndex( "jabatan"))

                Log.i("test", alumniList.count().toString())

                val alumni = AlumniClass(id, nim, namaAlumni,
                    tempatLahir, tanggalLahir, alamat, agama, noTelepon, tahunLulus, tahunMasuk, pekerjaan, jabatan)
                alumniList.add(alumni)
            }while (cursor.moveToNext())
        }
        Log.i("test", alumniList.count().toString())
        return alumniList
    }
}