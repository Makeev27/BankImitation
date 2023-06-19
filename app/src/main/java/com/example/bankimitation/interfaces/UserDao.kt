package com.example.bankimitation.interfaces

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bankimitation.classes.User

@Dao
public interface UserDao {

    @Query ("SELECT * FROM users")
    fun getAllNotes(): LiveData<List<User>>

    @Insert
    fun add(user: User)

    @Query("DELETE FROM users WHERE id = :id")
    fun remove(id: Int)

}