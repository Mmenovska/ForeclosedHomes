package com.gsixacademy.android.foreclosedhomes.fragment


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.foreclosedhomes.MainActivity
import com.gsixacademy.android.foreclosedhomes.R
import com.gsixacademy.android.foreclosedhomes.adapters.PropertiesAdapter
import com.gsixacademy.android.foreclosedhomes.adapters.PropertiesDataClickEvent
import com.gsixacademy.android.foreclosedhomes.data.PropertiesData
import com.gsixacademy.android.foreclosedhomes.data.PropertiesModel
import kotlinx.android.synthetic.main.recyclerview_layout.*


class PropertiesFragment : Fragment() {

    lateinit var propertiesAdapter : PropertiesAdapter
    var propertiesModel : PropertiesModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recyclerview_layout,container,false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val properties = (activity as MainActivity).propertiesModel?.imoti?: ArrayList()
        val filteredProperties : ArrayList<PropertiesData> = ArrayList()
        val cityClicked = arguments?.getString("cityClicked")?:""
        for (item in properties){
            if (item != null && item.city == cityClicked){
                filteredProperties.add(item)
            }
        }

        propertiesAdapter = PropertiesAdapter(filteredProperties){
            if (it is PropertiesDataClickEvent.PropertiesDataItemClicked){
              Log.d ("propertyClicked", "" +it.propertiesData.property)
              var bundle = Bundle()
              bundle.putString("propertyDescription", it.propertiesData.description)
                bundle.putString("propertyAddress", it.propertiesData.address)
                bundle.putString("propertyInfo", it.propertiesData.property)
                bundle.putString("propertySize", it.propertiesData.size)
                bundle.putString ("propertyContact", it.propertiesData.contact)
                bundle.putString("propertyPrice", it.propertiesData.price)
                bundle.putString("propertyTelephone", it.propertiesData.telephone)
                findNavController().navigate(R.id.action_propertiesFragment_to_propertyDetailsFragment,bundle)


            }
        }

        propertiesRv.adapter = propertiesAdapter

    }



    }