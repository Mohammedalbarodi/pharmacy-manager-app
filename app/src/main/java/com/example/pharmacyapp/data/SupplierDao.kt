package com.example.pharmacyapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pharmacyapp.model.Supplier

@Dao
interface SupplierDao {
    @Query("SELECT * FROM suppliers ORDER BY name ASC")
    fun getAll(): LiveData<List<Supplier>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(supplier: Supplier)

    @Delete
    suspend fun delete(supplier: Supplier)
}
