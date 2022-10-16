package com.serosoft.akakcecase.ui.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.serosoft.akakcecase.R
import com.serosoft.akakcecase.data.entity.Product
import com.serosoft.akakcecase.databinding.FragmentProductListBinding
import com.serosoft.akakcecase.ui.product.adapter.HorizontalProductAdapter
import com.serosoft.akakcecase.ui.product.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private lateinit var binding: FragmentProductListBinding

    private val viewModel: ProductListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.productListFragment = this

        viewModel.productList.observe(viewLifecycleOwner) {

            if (it.isNullOrEmpty()) {
                binding.txtError.visibility = View.VISIBLE
            } else {
                val adapter = ProductAdapter(it) { code ->
                    val action = ProductListFragmentDirections.productToDetail(code)
                    findNavController().navigate(action)

                }
                binding.productAdapter = adapter
                binding.txtError.visibility = View.GONE
            }
        }

        viewModel.horizontalProductList.observe(viewLifecycleOwner) {

            if (it.isNullOrEmpty()) {
                binding.txtError.visibility = View.VISIBLE
            } else {
                val adapter = HorizontalProductAdapter(it) { code ->
                    val action = ProductListFragmentDirections.productToDetail(code)
                    findNavController().navigate(action)
                }
                binding.horizontalProductAdapter = adapter
                binding.txtError.visibility = View.GONE
            }
        }
    }
}