package com.serosoft.akakcecase.ui.product.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serosoft.akakcecase.R
import com.serosoft.akakcecase.data.entity.Product
import com.serosoft.akakcecase.databinding.ItemCardHorizontalBinding
import com.serosoft.akakcecase.ui.product.ProductListViewModel

class HorizontalProductAdapter(
    private var productHorizontalList: List<Product>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<HorizontalProductAdapter.CardDesign>() {

    inner class CardDesign(private val binding: ItemCardHorizontalBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {

            with(binding) {

                txtNameHr.text = "${product.name}"
                txtPriceHr.text = "${product.price} TL"
                txtCountOfPricesHr.text = "${product.countOfPrices} satıcı >"
                txtFollowCountHr.text = "${product.followCount} +takip"
                Glide.with(imgProductHr).load(product.imageUrl).into(imgProductHr)
                cardviewHr.setOnClickListener {
                    product.code?.let { onItemClick(it) }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCardHorizontalBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_card_horizontal, parent, false)
        return CardDesign(binding)
    }

    override fun onBindViewHolder(holder: CardDesign, position: Int) = holder.bind(productHorizontalList[position])

    override fun getItemCount() = productHorizontalList.size
}