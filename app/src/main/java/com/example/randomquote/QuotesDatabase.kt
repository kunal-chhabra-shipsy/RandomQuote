package com.example.randomquote

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Results::class] , version = 1)
abstract class QuotesDatabase: RoomDatabase() {

    abstract fun getQuotesDao() : QuotesDAO

    companion object {


        @Volatile
        private var INSTANCE: QuotesDatabase? = null

        fun getDatabase(context: Context): QuotesDatabase {

            if (INSTANCE == null) {

                synchronized(this) {

                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        QuotesDatabase::class.java,
                        "quotesDB"
                    ).build()

                }

            }

            return INSTANCE!!

        }
    }


}