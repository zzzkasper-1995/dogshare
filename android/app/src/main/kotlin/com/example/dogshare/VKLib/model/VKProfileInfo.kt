package com.example.dogshare.VKLib.model

import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class VKProfileInfo(
        val id: Int = 0,
        val firstName: String = "",
        val lastName: String = "",
        val sex: Int = 0,
        val phone: String = "") : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeInt(sex)
        parcel.writeString(phone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VKProfileInfo> {
        override fun createFromParcel(parcel: Parcel): VKProfileInfo {
            return VKProfileInfo(parcel)
        }

        override fun newArray(size: Int): Array<VKProfileInfo?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject)
            = VKProfileInfo(
                    id = json.optInt("id", 0),
                    firstName = json.optString("first_name", ""),
                    lastName = json.optString("last_name", ""),
                    sex = json.optInt("sex", 0),
                    phone = json.optString("phone", "")
            )

    }
}