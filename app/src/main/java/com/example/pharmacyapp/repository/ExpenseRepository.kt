package com.example.pharmacyapp.repository

import com.example.pharmacyapp.data.ExpenseDao
import com.example.pharmacyapp.model.Expense

class ExpenseRepository(private val dao: ExpenseDao) {
    val all = dao.getAll()
    suspend fun insert(e: Expense) = dao.insert(e)
    suspend fun delete(e: Expense) = dao.delete(e)
}
