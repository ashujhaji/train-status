package io.tnine.trainstatus

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import io.tnine.trainstatus.Utils.Config

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        var mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

        mFirebaseRemoteConfig.setConfigSettings(FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(true)
                .build())

        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults)

        val cacheExpiration: Long = 0
        mFirebaseRemoteConfig.fetch(cacheExpiration)
                .addOnCompleteListener {
                    if (it.isSuccessful()) {

                        // After config data is successfully fetched, it must be activated before newly fetched
                        // values are returned.
                        Log.d("Test", mFirebaseRemoteConfig.getString("abcd"))
                        mFirebaseRemoteConfig.activateFetched()
                        mFirebaseRemoteConfig.activateFetched()
                        Log.d("Test", mFirebaseRemoteConfig.getString("abcd"))
                        if (!mFirebaseRemoteConfig.getString("abcd").isEmpty()) {
                            Config.myApiKey = mFirebaseRemoteConfig.getString("abcd")
                        } else {
                            Log.e("empty string", "")
                        }

                    } else {
                        Toast.makeText(this, "Fetch Failed",
                                Toast.LENGTH_SHORT).show()
                    }
                }

    }
}