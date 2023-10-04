package com.codingwithme.shoppinglistapp.data.repositories

import com.codingwithme.shoppinglistapp.data.db.ShoppingDatabase
import com.codingwithme.shoppinglistapp.data.db.entityes.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upset(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    suspend fun getAllShoppingList() = db.getShoppingDao().getAllShoppingItems()
}