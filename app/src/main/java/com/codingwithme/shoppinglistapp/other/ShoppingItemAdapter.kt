package com.codingwithme.shoppinglistapp.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingwithme.shoppinglistapp.R
import com.codingwithme.shoppinglistapp.data.db.entityes.ShoppingItem
import com.codingwithme.shoppinglistapp.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.ivDelete
import kotlinx.android.synthetic.main.shopping_item.view.ivMinus
import kotlinx.android.synthetic.main.shopping_item.view.ivPlus
import kotlinx.android.synthetic.main.shopping_item.view.tvAmount
import kotlinx.android.synthetic.main.shopping_item.view.tvName


class ShoppingItemAdapter(
    val items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = "${curShoppingItem.amount}"
        holder.itemView.ivDelete.setOnClickListener{
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener{
            curShoppingItem.amount++
            viewModel.upset(curShoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener{
            if (curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                viewModel.upset(curShoppingItem)
            }

        }
    }

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}