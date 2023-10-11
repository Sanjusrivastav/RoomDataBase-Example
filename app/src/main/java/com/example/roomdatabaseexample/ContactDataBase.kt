package com.example.roomdatabaseexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.time.Instant

@Database(entities = [Contact :: class] , version = 1)
abstract  class ContactDataBase : RoomDatabase() {

     abstract fun contactDao() : ContactDao

     companion object{
          @Volatile
          private var INSTANT : ContactDataBase? = null
          fun getDataBase(context : Context): ContactDataBase {
               if (INSTANT == null){
                    synchronized(this){
                         INSTANT = Room.databaseBuilder(context.applicationContext,ContactDataBase :: class.java,"ContactDB").build()
                    }
               }
               return  INSTANT!!

          }

     }
}