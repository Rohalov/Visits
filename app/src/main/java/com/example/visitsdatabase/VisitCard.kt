package com.example.visitsdatabase

import android.os.Parcel
import android.os.Parcelable


data class VisitCard(
    val doctorName: String,
    val patientName: String,
    val date: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(doctorName)
        parcel.writeString(patientName)
        parcel.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VisitCard> {
        override fun createFromParcel(parcel: Parcel): VisitCard {
            return VisitCard(parcel)
        }

        override fun newArray(size: Int): Array<VisitCard?> {
            return arrayOfNulls(size)
        }
    }
}