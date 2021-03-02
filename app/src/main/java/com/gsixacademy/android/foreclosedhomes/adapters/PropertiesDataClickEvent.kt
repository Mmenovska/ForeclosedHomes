package com.gsixacademy.android.foreclosedhomes.adapters

import com.gsixacademy.android.foreclosedhomes.data.PropertiesData

sealed class PropertiesDataClickEvent {
    data class PropertiesDataItemClicked ( val propertiesData : PropertiesData): PropertiesDataClickEvent()

}
