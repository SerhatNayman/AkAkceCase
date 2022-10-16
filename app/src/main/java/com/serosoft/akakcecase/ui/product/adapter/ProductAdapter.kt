package com.serosoft.akakcecase.ui.product.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serosoft.akakcecase.R
import com.serosoft.akakcecase.data.entity.Product
import com.serosoft.akakcecase.databinding.ItemCardVerticalBinding


class ProductAdapter(
    var productList: List<Product>,
    private val onItemClick: (Int) -> Unit

) : RecyclerView.Adapter<ProductAdapter.CardDesign>() {

    inner class CardDesign(private val binding: ItemCardVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            with(binding) {
                txtName.text = "${product.name}"
                txtPrice.text = "${product.price} TL"
                txtCountOfPrices.text = "${product.countOfPrices} satıcı >"
                txtFollowCount.text = "${product.followCount} +takip"
                chip.text = "${product.dropRatio}"
                Glide.with(imgProduct).load(product.imageUrl).into(imgProduct)
                carviewVr.setOnClickListener {
                    product.code?.let { onItemClick(it) }
                }

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCardVerticalBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_card_vertical, parent, false)
        return CardDesign(binding)
    }


    override fun onBindViewHolder(holder: CardDesign, position: Int) =
        holder.bind(productList[position])


    override fun getItemCount() = productList.size

}

