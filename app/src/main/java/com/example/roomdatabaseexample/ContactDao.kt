package com.example.roomdatabaseexample

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact : Contact)

    @Update
    suspend fun updateContact(contact : Contact)

    @Delete
     fun deleteContact(contact : Contact)

    @Query("SELECT * FROM contact")
    fun getQuery() : LiveData<List<Contact>>

}