package com.example.pharmacyapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicines")
data class Medicine(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val barcode: String?,
    val quantity: Int,
    val price: Double,
    val expiryDate: String,
    val supplierId: Int?
)
