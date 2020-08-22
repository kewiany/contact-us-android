package xyz.kewiany.contactus

import android.app.Application

class ContactUsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MainModel()
    }
}
