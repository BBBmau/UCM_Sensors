package com.mau.ucm_sensors.bluetooth.model


import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.Intent
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.startActivityForResult

// Model for bluetooth capability

object BluetoothLogic {
    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

    fun enableBluetooth(activity: AppCompatActivity) {
        if(bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
        }
        if (bluetoothAdapter?.isEnabled == false) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(activity,enableBtIntent,0,null)
        }
        else{
            Log.d("Bluetooth", "Bluetooth is On.")
            //scanLeDevice()
        }

    }

    private fun scanLeDevice(){
        val bluetoothLeScanner = bluetoothAdapter?.bluetoothLeScanner
        var scanning = false
        val handler = Handler()
        val leScanCallback : ScanCallback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult?) {
                super.onScanResult(callbackType, result)
                Log.d("scanLeDevice", "Scanning Result")
            }
        }

// Stops scanning after 10 seconds.
        val SCAN_PERIOD: Long = 1000

        if (!scanning) { // Stops scanning after a pre-defined scan period.
            handler.postDelayed({
                scanning = false
                bluetoothLeScanner?.stopScan(leScanCallback)
                                }, SCAN_PERIOD)
            scanning = true
            bluetoothLeScanner?.startScan(leScanCallback)
        } else {
            scanning = false
            bluetoothLeScanner?.stopScan(leScanCallback)
        }
    }
}