package com.example.roomdatabaseexample

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.time.Instant

@Database(entities = [Contact :: class], version = 2)
@TypeConverters(Convertors::class)

abstract  class ContactDataBase : RoomDatabase() {
     abstract fun contactDao() : ContactDao
     companion object{
          val migration_1_2 = object : Migration(1,2){

               override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
               }
          }
          @Volatile
          private var INSTANT : ContactDataBase? = null
          fun getDataBase(context : Context): ContactDataBase {
               if (INSTANT == null){
                    synchronized(this){
                         INSTANT = Room.databaseBuilder(context.applicationContext,ContactDataBase :: class.java,"ContactDB")
                              . addMigrations(migration_1_2)
                              .build()
                    }
               }
               return  INSTANT!!
          }
     }
}