package com.gsixacademy.android.foreclosedhomes.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gsixacademy.android.foreclosedhomes.MainActivity
import com.gsixacademy.android.foreclosedhomes.R
import com.gsixacademy.android.foreclosedhomes.data.PropertiesModel
import kotlinx.android.synthetic.main.details_layout.*

class PropertyDetailsFragment : Fragment() {
    var propertiesModel: PropertiesModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return return inflater.inflate(R.layout.details_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        propertiesModel = (activity as MainActivity).propertiesModel
        val propertyDescription = arguments?.getString("propertyDescription") ?: ""
        val propertyAddress = arguments?.getString("propertyAddress") ?: ""
        val propertySize = arguments?.getString("propertySize") ?: ""
        val propertyPrice = arguments?.getString("propertyPrice") ?: ""
        val propertyContact = arguments?.getString("propertyContact") ?: ""
        val propertyTelephone = arguments?.getString("propertyTelephone") ?: ""
        val propertyInfo = arguments?.getString("propertyInfo") ?: ""

        descriptionTv.text = propertyDescription
        addressTv.text = propertyAddress
        propertyTv.text = propertyInfo
        sizeTv.text = propertySize
        priceTv.text = propertyPrice
        contactTv.text = propertyContact
        telephoneTv.text = propertyTelephone
        telephoneTv.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + propertyTelephone))
            startActivity(callIntent)

        }

    }

}