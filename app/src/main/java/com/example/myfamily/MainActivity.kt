package com.example.myfamily

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
     val permissions = arrayOf(
         Manifest.permission.ACCESS_FINE_LOCATION,
         Manifest.permission.CAMERA,
         Manifest.permission.READ_CONTACTS
     )
    val permissionCode = 78

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        askForPermission()

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_bar);
        bottomBar.setOnItemSelectedListener {

            if(it.itemId==R.id.nav_guard)
            {

                inflateFragement(GuardFragement.newInstance())

            }else if(it.itemId == R.id.nav_home)
            {

                inflateFragement(HomeFragment.newInstance());
            }
            else if(it.itemId == R.id.nav_dashboard)
            {
                inflateFragement(DashboardFragment.newInstance())

            }

            else
            {
                inflateFragement(ProfileFragment.newInstance())
            }


            true;
        }
    }

    private fun askForPermission() {
        ActivityCompat.requestPermissions(this,permissions,permissionCode)
    }


    private fun inflateFragement(newInstance: Fragment)
    {
        val transanction = supportFragmentManager.beginTransaction();
        transanction.replace(R.id.container, newInstance)
        transanction.commit();


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == permissionCode){
            if(allPermissionGranted()){
                openCamera()
            }else{

            }
        }
    }

    private fun openCamera() {
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        startActivity(intent)
    }

    private fun allPermissionGranted(): Boolean {
        for(item in permissions){
            if(ContextCompat.checkSelfPermission(this,item) != PackageManager.PERMISSION_GRANTED){
                return false
            }
        }
        return true
    }

}
