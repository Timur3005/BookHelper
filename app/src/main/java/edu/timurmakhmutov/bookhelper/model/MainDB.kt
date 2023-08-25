package edu.timurmakhmutov.bookhelper.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Book::class], version = 1)
abstract class MainDB: RoomDatabase() {

    abstract fun getDao(): Dao

    companion object{
        fun getDB(context: Context): MainDB {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "DB").build()
        }
    }

}