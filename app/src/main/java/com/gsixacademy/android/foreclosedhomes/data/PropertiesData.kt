package com.gsixacademy.android.foreclosedhomes.data

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class PropertiesData() : Parcelable {
    var city : String? = null
    var id : Int? = null
    var address : String? = null
    var description : String? = null
    var property : String? = null
    var contact : String? = null
    var telephone : String? = null
    var price : String? = null
    var size : String? = null

    constructor(parcel: Parcel) : this(){
        city = parcel.readString()
        id = parcel.readInt()
        address = parcel.readString()
        description = parcel.readString()
        price = parcel.readString()
        size = parcel.readString()
        property = parcel.readString()
        contact = parcel.readString()
        telephone = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(city)
        id?.let { parcel.writeInt(it) }
        parcel.writeString(description)
        parcel.writeString(address)
        parcel.writeString(property)
        parcel.writeString(size)
        parcel.writeString(price)
        parcel.writeString(contact)
        parcel.writeString(telephone)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PropertiesData>{
        override fun createFromParcel(parcel: Parcel): PropertiesData {
            return PropertiesData(parcel)
        }

        override fun newArray(size: Int): Array<PropertiesData?> {
            return arrayOfNulls(size)
        }
    }

}
