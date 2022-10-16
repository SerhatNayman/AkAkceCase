package com.serosoft.akakcecase.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.serosoft.akakcecase.R
import com.serosoft.akakcecase.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    private val product:DetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_detail,container,false)
        binding.detailFragment = this
        binding.tvModelDt.text = product.product.name
        binding.tvMarkaDt.text= product.product.dropRatio.toString()

        return binding.root

    }


}