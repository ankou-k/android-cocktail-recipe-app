package com.example.cocktailsrecipebook.datalayer.cloudDB

import com.google.firebase.firestore.FirebaseFirestore

object FirebaseInstance {
    val database: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }
}