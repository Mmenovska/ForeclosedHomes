package com.gsixacademy.android.foreclosedhomes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsixacademy.android.foreclosedhomes.R
import com.gsixacademy.android.foreclosedhomes.data.PropertiesData
import kotlinx.android.synthetic.main.property_layout.view.*

class PropertiesAdapter ( val propertiesData : ArrayList<PropertiesData>, val propertiesDataClickEvent : (PropertiesDataClickEvent) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.property_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return propertiesData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myViewHolder = holder as MyViewHolder
        myViewHolder.bindData(propertiesData[position],position)
    }

    inner class MyViewHolder (view : View) : RecyclerView.ViewHolder(view){
        fun bindData (propertiesData : PropertiesData, position: Int){
            itemView.descriptionTv.text = propertiesData.description
            itemView.addressTv.text = propertiesData.address
            itemView.propertyTv.text = propertiesData.property
            itemView.sizeTv.text = propertiesData.size
            itemView.contactTv.text = propertiesData.contact
            itemView.property_main.setOnClickListener {
                propertiesDataClickEvent.invoke(PropertiesDataClickEvent.PropertiesDataItemClicked(propertiesData))
            }

        }
    }

}
