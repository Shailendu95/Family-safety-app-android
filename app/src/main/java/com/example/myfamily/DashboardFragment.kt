package com.example.myfamily

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfamily.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class DashboardFragment : Fragment(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // Initialize the map asynchronously
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        return view
    }

    override fun onMapReady(googleMap: GoogleMap) {
        Log.d("DashboardFragment", "Map is ready")
        map = googleMap

        // Set an example location (New Delhi) and move the camera
        val latLng = LatLng(28.7041, 77.1025) // Coordinates for New Delhi
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f)) // Zoom level 15
        map.addMarker(MarkerOptions().position(latLng).title("Marker in New Delhi")) // Optional marker
    }

    companion object {
        @JvmStatic
        fun newInstance() = DashboardFragment()
    }
}
