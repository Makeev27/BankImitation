package com.example.bankimitation.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bankimitation.classes.User
import com.example.bankimitation.interfaces.UserDao

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    companion object {
        var instance: UserDatabase? = null

        private const val DB_NAME = "user.db"

        @Synchronized
        fun getInstance(application: Application): UserDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    application,
                    UserDatabase::class.java,
                    DB_NAME
                ).build()
            }
            return instance!!
        }
    }

    public abstract fun userDao(): UserDao
}