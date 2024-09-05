package com.nasa.practise2.model

import android.os.Parcel
import android.os.Parcelable


data class CountryItem(
    val capital: String?,
    val code: String?,
    val currency: Any?,
    val demonym: String?,
    val flag: String?,
    val language: Any?,
    val name: String,
    val malu: String,
    val region: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        TODO("currency"),
        parcel.readString(),
        parcel.readString(),
        TODO("language"),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(capital)
        parcel.writeString(code)
        parcel.writeString(demonym)
        parcel.writeString(flag)
        parcel.writeString(name)
        parcel.writeString(malu)
        parcel.writeString(region)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CountryItem> {
        override fun createFromParcel(parcel: Parcel): CountryItem {
            return CountryItem(parcel)
        }

        override fun newArray(size: Int): Array<CountryItem?> {
            return arrayOfNulls(size)
        }
    }
}
