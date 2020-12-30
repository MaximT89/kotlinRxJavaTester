package com.example.kotlintest.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personTable")
class PersonTable(
    @ColumnInfo var name: String?,
    @ColumnInfo var age: Int?,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}