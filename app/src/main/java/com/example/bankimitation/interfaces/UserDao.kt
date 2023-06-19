package com.example.bankimitation.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bankimitation.classes.User

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("SELECT name FROM users")
    fun getName(): String

    @Query("SELECT password FROM USERS")
    fun getPassword(): Int

    @Query("DELETE FROM users")
    fun nukeTable()

    @Insert
    fun add(user: User)

    @Query("DELETE FROM users WHERE id = :id")
    fun remove(id: Int)

}