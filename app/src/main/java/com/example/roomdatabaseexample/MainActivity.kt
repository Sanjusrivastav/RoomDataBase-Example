package com.example.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    lateinit var dataBase :ContactDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataBase = Room.databaseBuilder(applicationContext,ContactDataBase :: class.java,"ContactDB").build()
        dataBase.contactDao().insertContact(Contact(1,"Sanjana",203920930))
    }
}