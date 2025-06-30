package com.example.pharmacyapp.repository

import com.example.pharmacyapp.data.SupplierDao
import com.example.pharmacyapp.model.Supplier

class SupplierRepository(private val dao: SupplierDao) {
    val all = dao.getAll()
    suspend fun insert(s: Supplier) = dao.insert(s)
    suspend fun delete(s: Supplier) = dao.delete(s)
}
