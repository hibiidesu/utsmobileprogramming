package pnj.uts.ti.nabil_falih_khairullah.alumni

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pnj.uts.ti.nabil_falih_khairullah.R

class AlumniAdapter(private val onClick: (AlumniClass) -> Unit):
    RecyclerView.Adapter<AlumniAdapter.AlumniViewHolder>(){

    var alumniList: ArrayList<AlumniClass> = ArrayList()

        class AlumniViewHolder(itemView: View, val onClick: (AlumniClass) -> Unit):
                RecyclerView.ViewHolder(itemView) {
                    val name: TextView = itemView.findViewById(R.id.nama_text_alumni)
                    val nim: TextView = itemView.findViewById(R.id.nim_text_alumni)
                    private var currentAlumni: AlumniClass? = null

                    init {
                        itemView.setOnClickListener{
                            currentAlumni?.let{
                                onClick(it)
                            }
                        }
                    }

                    fun bind (alumni: AlumniClass) {
                        currentAlumni = alumni

                        name.text = alumni.name
                        nim.text = alumni.nim
                    }
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumniViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return AlumniViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: AlumniViewHolder, position: Int) {
        val alumni = alumniList[position]
        holder.nim.text = alumni.nim
        holder.name.text = alumni.name
    }

    override fun getItemCount(): Int {
        return alumniList.count()
    }

    fun setItems(alumni: ArrayList<AlumniClass>) {
        this.alumniList = alumni
    }
}