package com.example.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var dataBase :ContactDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataBase = ContactDataBase.getDataBase(this,)
//        dataBase = Room.databaseBuilder(applicationContext,ContactDataBase :: class.java,"ContactDB").build()

        GlobalScope.launch {
            dataBase.contactDao().insertContact(Contact(1,"Sanjana",203920930, Date(), isActive = 1))
        }
    }
}