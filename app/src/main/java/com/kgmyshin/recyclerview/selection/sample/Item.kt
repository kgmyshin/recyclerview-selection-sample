package com.kgmyshin.recyclerview.selection.sample

import android.os.Parcel
import android.os.Parcelable

data class Item(
        val id: Long,
        val title: String,
        val subTitle: String
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readLong(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeLong(id)
        writeString(title)
        writeString(subTitle)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Item> = object : Parcelable.Creator<Item> {
            override fun createFromParcel(source: Parcel): Item = Item(source)
            override fun newArray(size: Int): Array<Item?> = arrayOfNulls(size)
        }
    }
}
