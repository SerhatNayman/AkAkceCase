package com.serosoft.akakcecase.ui.product.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serosoft.akakcecase.R
import com.serosoft.akakcecase.data.entity.Product
import com.serosoft.akakcecase.data.entity.ProductResponse
import com.serosoft.akakcecase.databinding.ItemCardVerticalBinding
import com.serosoft.akakcecase.ui.product.ProductListViewModel

class ProductAdapter(
    var mContext: Context,
    var productList: List<Product>,
    var viewModel: ProductListViewModel
) : RecyclerView.Adapter<ProductAdapter.CardDesign>() {

    inner class CardDesign(binding: ItemCardVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: ItemCardVerticalBinding

        init {
            this.binding = binding
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: ItemCardVerticalBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_card_vertical, parent, false)
        return CardDesign(binding)
    }


    override fun onBindViewHolder(holder: CardDesign, position: Int) {
        val product = productList[position]
        val p = holder.binding
        p.txtName.text = "${product.name}"
        p.txtPrice.text = "${product.price} TL"
        p.txtCountOfPrices.text = "${product.countOfPrices} satıcı >"
        p.txtFollowCount.text = "${product.followCount} +takip"
        p.chip.text = "${product.dropRatio}"
        Glide.with(p.imgProduct).load(product.imageUrl).into(p.imgProduct)
        p.carviewVr.setOnClickListener {}


    }


    override fun getItemCount(): Int {
        return productList.size
    }

}

