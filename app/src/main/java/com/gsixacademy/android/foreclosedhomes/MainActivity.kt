package com.gsixacademy.android.foreclosedhomes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.google.firebase.database.*
import com.gsixacademy.android.foreclosedhomes.data.PropertiesModel

class MainActivity : AppCompatActivity() {

    lateinit var database:DatabaseReference
    var propertiesModel : PropertiesModel? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
        database = FirebaseDatabase.getInstance().reference
        initialiseFirebaseDatabase()

    }

    private fun initialiseFirebaseDatabase (){
        val postListener = object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                propertiesModel = snapshot.getValue(PropertiesModel :: class.java)
            }
        }

        database.addValueEventListener(postListener)
    }
}