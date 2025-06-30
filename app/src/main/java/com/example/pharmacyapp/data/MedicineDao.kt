package com.example.pharmacyapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pharmacyapp.model.Medicine

@Dao
interface MedicineDao {
    @Query("SELECT * FROM medicines ORDER BY name ASC")
    fun getAll(): LiveData<List<Medicine>>

    @Query("SELECT * FROM medicines WHERE expiryDate < :today")
    fun getExpired(today: String): LiveData<List<Medicine>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(medicine: Medicine)

    @Delete
    suspend fun delete(medicine: Medicine)
}
