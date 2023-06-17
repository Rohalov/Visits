package com.example.visitsdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.visitsdatabase.databinding.ListItemLayoutBinding

class VisitAdapter(private val visits: ArrayList<VisitCard>) :
    RecyclerView.Adapter<VisitAdapter.VisitHolder>() {

    class VisitHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ListItemLayoutBinding.bind(item)
        fun bind(visit: VisitCard) = with(binding) {
            textViewPatientName.text = visit.patientName
            textViewData.text = visit.date
            textViewNameDoctor.text = visit.doctorName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return VisitHolder(v)
    }

    override fun onBindViewHolder(holder: VisitHolder, position: Int) {
        val visit = visits[position]
        holder.bind(visit)
    }

    override fun getItemCount(): Int {
        return visits.size
    }
}