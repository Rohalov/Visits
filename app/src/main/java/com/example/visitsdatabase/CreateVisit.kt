package com.example.visitsdatabase

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity

class CreateVisit : ComponentActivity() {

    private val doctors = arrayOf(
        "John Dorian",
        "Elliot Reid",
        "Perry Cox",
        "Carla Espinosa",
        "Christopher Turk"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_visit_activity)

        val dateEditText: EditText = findViewById(R.id.editTextDate)
        val doctorSpinner: Spinner = findViewById(R.id.spinnerDoctor)
        val doctorAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, doctors.map { it })
        doctorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        doctorSpinner.adapter = doctorAdapter

        val createVisitButton: Button = findViewById(R.id.createVisitButton)
        createVisitButton.setOnClickListener {
            val patientName = findViewById<EditText>(R.id.editTextName).text.toString()
            val date = dateEditText.text.toString()
            val selectedDoctor = doctors[doctorSpinner.selectedItemPosition]

            if (date.matches(Regex("\\d+"))) {
                val visit = VisitCard(selectedDoctor, patientName, date)

                val intent = Intent()
                intent.putExtra("newVisit", visit)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                dateEditText.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Неправильний формат дати (ДДММРРРР)", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}