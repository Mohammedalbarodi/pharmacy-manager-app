package com.example.pharmacyapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pharmacyapp.model.*

@Database(entities = [Medicine::class, Supplier::class, Expense::class], version = 1)
abstract class PharmacyDatabase : RoomDatabase() {
    abstract fun medicineDao(): MedicineDao
    abstract fun supplierDao(): SupplierDao
    abstract fun expenseDao(): ExpenseDao

    companion object {
        @Volatile private var instance: PharmacyDatabase? = null

        fun getDatabase(context: Context): PharmacyDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    PharmacyDatabase::class.java,
                    "pharmacy_db"
                ).build().also { instance = it }
            }
    }
}
