package com.mau.ucm_sensors.bluetooth.model

import android.bluetooth.BluetoothDevice
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mau.ucm_sensors.bluetooth.bluetoothTransfer

class LeDeviceListAdapter : BaseAdapter() {
    lateinit var mLeDevices : ArrayList<BluetoothDevice>
    lateinit var mInflator : LayoutInflater

    fun addDevice(device : BluetoothDevice){
        if(!mLeDevices.contains(device))
            mLeDevices.add(device)
    }

    fun getDevice(position : Int): BluetoothDevice {
        return mLeDevices[position]
    }

    fun clear(){
        mLeDevices.clear()
    }

    override fun getCount() : Int{
        return mLeDevices.size
    }

    override fun getItem(i : Int): BluetoothDevice {
        return mLeDevices[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View? {
        val viewHolder : RecyclerView.ViewHolder

        // Code for Implementation in ListView
        if(view == null){
            // inserts R.layout of where the listView will be
        }

        return view
    }
}