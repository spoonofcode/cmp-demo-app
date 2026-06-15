package com.spoonofcode.cmpdemoapp

import KoinInitializer
import android.app.Application

class CMPDemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}