package com.codingwithme.shoppinglistapp.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.codingwithme.shoppinglistapp.data.db.entityes.ShoppingItem
import com.codingwithme.shoppinglistapp.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {
    fun upset(item : ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upset(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    suspend fun getAllShoppingList() = repository.getAllShoppingList()

}