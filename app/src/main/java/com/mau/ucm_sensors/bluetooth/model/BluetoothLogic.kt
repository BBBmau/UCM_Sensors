package com.mau.ucm_sensors.bluetooth.model

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

// Model for bluetooth capability

object bluetoothLogic :AppCompatActivity() {

    fun checkPermission(state: Context, activity : Activity){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            if(ContextCompat.checkSelfPermission(state,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                    1)
                Log.d("BluetoothLogic","Permission was not Granted")
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d("BluetoothLogic", "In onRequestPermissionsResult")
        if (requestCode == 1 && grantResults.isNotEmpty()){
            for(i in grantResults.indices){
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED)
                    Log.d("Permission Request", "${permissions[i]} is granted")
            }
        }
    }
}