package com.example.pharmacyapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.pharmacyapp.data.PharmacyDatabase
import com.example.pharmacyapp.model.Medicine
import com.example.pharmacyapp.repository.MedicineRepository
import kotlinx.coroutines.launch

class MedicineViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: MedicineRepository
    val all: LiveData<List<Medicine>>

    init {
        val dao = PharmacyDatabase.getDatabase(application).medicineDao()
        repo = MedicineRepository(dao)
        all = repo.all
    }

    fun insert(m: Medicine) = viewModelScope.launch { repo.insert(m) }
    fun delete(m: Medicine) = viewModelScope.launch { repo.delete(m) }
}
