package com.gsixacademy.android.foreclosedhomes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import com.gsixacademy.android.foreclosedhomes.data.PropertiesData
import com.gsixacademy.android.foreclosedhomes.data.PropertiesModel

class MainActivity : AppCompatActivity() {

    var propertiesModel: PropertiesModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}