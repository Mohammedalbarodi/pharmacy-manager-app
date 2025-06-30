package com.example.pharmacyapp.repository

import com.example.pharmacyapp.data.MedicineDao
import com.example.pharmacyapp.model.Medicine

class MedicineRepository(private val dao: MedicineDao) {
    val all = dao.getAll()
    fun getExpired(today: String) = dao.getExpired(today)
    suspend fun insert(m: Medicine) = dao.insert(m)
    suspend fun delete(m: Medicine) = dao.delete(m)
}
