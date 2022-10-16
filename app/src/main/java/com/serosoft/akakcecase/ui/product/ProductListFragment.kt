package com.serosoft.akakcecase.ui.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.serosoft.akakcecase.R
import com.serosoft.akakcecase.data.entity.Product
import com.serosoft.akakcecase.databinding.FragmentProductListBinding
import com.serosoft.akakcecase.ui.product.adapter.HorizontalProductAdapter
import com.serosoft.akakcecase.ui.product.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {
    private lateinit var viewModel: ProductListViewModel
    private lateinit var binding: FragmentProductListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_product_list, container, false
        )

        binding.productListFragment = this

        viewModel.productList.observe(viewLifecycleOwner) {

            val adapter = ProductAdapter(requireContext(), it!!, viewModel)
            binding.productAdapter = adapter
            listControl(it)

        }

        viewModel.horizontalProductList.observe(viewLifecycleOwner) {
            val adapter = HorizontalProductAdapter(requireContext(), it!!, viewModel)
            binding.horizontalProductAdapter = adapter
        }



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: ProductListViewModel by viewModels()
        viewModel = tempViewModel

    }

    override fun onResume() {
        super.onResume()

    }

    fun listControl(list: List<Product>) {
        if (list.isEmpty()) {
            binding.txtError.visibility = View.VISIBLE
        } else {
            binding.txtError.visibility = View.GONE
        }
    }


}