package com.serosoft.akakcecase.ui.product.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serosoft.akakcecase.R
import com.serosoft.akakcecase.data.entity.HorizontalProduct
import com.serosoft.akakcecase.databinding.ItemCardHorizontalBinding
import com.serosoft.akakcecase.ui.product.ProductListViewModel

class HorizontalProductAdapter(
    var mContext: Context,
    var productHorizontalList: List<HorizontalProduct>,
    var viewModel: ProductListViewModel
) : RecyclerView.Adapter<HorizontalProductAdapter.CardDesign>() {

    inner class CardDesign(binding: ItemCardHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: ItemCardHorizontalBinding

        init {
            this.binding = binding
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: ItemCardHorizontalBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_card_horizontal, parent, false)
        return CardDesign(binding)
    }


    override fun onBindViewHolder(holder: CardDesign, position: Int) {
        val product = productHorizontalList[position]
        val p = holder.binding
        p.txtNameHr.text = "${product.name}"
        p.txtPriceHr.text = "${product.price} TL"
        p.txtCountOfPricesHr.text = "${product.countOfPrices} satıcı >"
        p.txtFollowCountHr.text = "${product.followCount} +takip"
        Glide.with(p.imgProductHr).load(product.imageUrl).into(p.imgProductHr)
        p.cardviewHr.setOnClickListener { }

    }


    override fun getItemCount(): Int {
        return productHorizontalList.size
    }

}