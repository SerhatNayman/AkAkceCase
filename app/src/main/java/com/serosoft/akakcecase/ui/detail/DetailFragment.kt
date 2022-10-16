package com.serosoft.akakcecase.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.serosoft.akakcecase.R
import com.serosoft.akakcecase.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val viewModel: DetailViewModel by viewModels()

    private val product: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailFragment = this

        viewModel.getDetailProduct(product.code)

        viewModel.detailProduct.observe(viewLifecycleOwner) {
            if (it == null) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            } else {
                binding.tvMarkaDt.text = it.mkName
                binding.tvModelDt.text = it.productName
                binding.ratingBar.rating = it.rating!!.toFloat()
                binding.txtCountOfPricesDt.text =
                    "${it.countOfPrices} satıcı içinde kargo dahil en ucuz fiyat seçeneği"
                binding.txtPriceDt.text = it.price.toString()
                if (it.freeShipping == true) {
                    binding.txtFreeShippingDt.text = "Ücretsiz Kargo"
                } else {
                    binding.txtFreeShippingDt.visibility = View.GONE
                }
                binding.txtLastUpdateDt.text = "Son güncelleme: ${it.lastUpdate} "

                Glide.with(binding.imgDetail).load(it.imageUrl).into(binding.imgDetail)

            }
        }
    }
}