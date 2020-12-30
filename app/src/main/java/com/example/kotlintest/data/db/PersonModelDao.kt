package com.example.kotlintest.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface PersonModelDao {

    @Insert
    fun insertPerson(personModel: PersonTable)

    @Delete
    fun deletePerson(personModel: PersonTable)

    @Update
    fun updatePerson(personModel: PersonTable)

}
