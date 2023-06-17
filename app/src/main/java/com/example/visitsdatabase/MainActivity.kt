package com.example.visitsdatabase

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    val visits = ArrayList<VisitCard>()
    private lateinit var visitAdapter: VisitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val visitRecyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        visitRecyclerView.layoutManager = layoutManager

        visitAdapter = VisitAdapter(visits)
        visitRecyclerView.adapter = visitAdapter

        val createVisitButton: Button = findViewById(R.id.button1)
        createVisitButton.setOnClickListener {
            val intent = Intent(this, CreateVisit::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val visit = data?.getParcelableExtra<VisitCard>("newVisit")
            visit?.let {
                visits.add(it)
                visitAdapter.notifyDataSetChanged()
            }
        }
    }
}