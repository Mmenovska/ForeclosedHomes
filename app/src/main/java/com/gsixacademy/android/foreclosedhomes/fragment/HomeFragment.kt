package com.gsixacademy.android.foreclosedhomes.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.foreclosedhomes.MainActivity
import com.gsixacademy.android.foreclosedhomes.R
import com.gsixacademy.android.foreclosedhomes.adapters.CityAdapter
import com.gsixacademy.android.foreclosedhomes.data.PropertiesModel
import com.gsixacademy.android.foreclosedhomes.data.SpinnerModel
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {
    lateinit var cityList : ArrayList<SpinnerModel>
    lateinit var cityAdapter : CityAdapter
    var propertiesModel : PropertiesModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val itemClicked = arguments?.getString("itemClicked")

        propertiesModel = (activity as MainActivity).propertiesModel

        var cities : HashSet<String> = HashSet()
        if (propertiesModel!= null && propertiesModel?.imoti != null)
            for (item in propertiesModel!!.imoti!!) {
                if (item != null) {
                    cities.add(item.city.toString())
                }
            }

        val array = arrayOfNulls<String>(cities.size)
        cityAdapter = CityAdapter(requireActivity(),cities.toArray(array))
        city_spinner.adapter = cityAdapter

        button_next.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("cityClicked",city_spinner.selectedItem.toString())
            bundle.putString("selectedItem",arguments?.getString("itemClicked"))
            findNavController().navigate(R.id.action_homeFragment_to_propertiesFragment,bundle)
        }


    }
}