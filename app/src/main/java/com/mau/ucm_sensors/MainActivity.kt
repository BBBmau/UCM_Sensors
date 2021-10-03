package com.mau.ucm_sensors

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.mau.ucm_sensors.bluetooth.model.BluetoothLogic

class MainActivity : AppCompatActivity() {
    private fun PackageManager.missingSystemFeature(name: String): Boolean = !hasSystemFeature(name)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()
    }

    private fun checkPermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            if(ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN),
                    0)

            }

            if(ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
                BluetoothLogic.enableBluetooth(this)
                Log.d("BluetoothLogic","enable Bluetooth")
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
        if (requestCode == 0 && grantResults.isNotEmpty()){
            for(i in grantResults.indices){
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED)
                    Log.d("Permission Request", "${permissions[i]} is granted")
            }
        }
    }

}