package com.example.pharmacyapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pharmacyapp.model.Expense

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAll(): LiveData<List<Expense>>

    @Insert
    suspend fun insert(expense: Expense)

    @Delete
    suspend fun delete(expense: Expense)
}
