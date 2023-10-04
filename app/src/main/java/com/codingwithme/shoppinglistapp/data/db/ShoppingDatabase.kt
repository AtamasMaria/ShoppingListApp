package com.codingwithme.shoppinglistapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codingwithme.shoppinglistapp.data.db.entityes.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object {
        @Volatile // аннотация, означающая что права на этот экземпляр будут видны другим потокам
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()


        //operator + invoke  означает, что функция выполняется каждый раз, когда мы создаем экземпляр БД наших покупок.
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            //В случае если instance = null, то блок synchronized(LOCK) заблокирует на этот поток, так что никакие другие потоки не смогут вызвать экземпляр БД пока не будет выполнен следующий блок кода.
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, ShoppingDatabase::class.java, "ShoppingDB.db").build()
    }
}