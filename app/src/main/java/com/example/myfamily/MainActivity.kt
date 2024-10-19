package com.example.myfamily

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_bar);
        bottomBar.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.nav_guard -> {

                    inflateFragement(GuardFragement.newInstance())

                }
                R.id.nav_home -> {

                    inflateFragement(HomeFragment.newInstance());
                }
                R.id.nav_dashboard -> {
                    inflateFragement(DashboardFragment.newInstance())

                }
                R.id.nav_profile -> {
                    inflateFragement(ProfileFragment.newInstance())
                }
            }


            true;
        }

        bottomBar.selectedItemId = R.id.nav_home

    }



    private fun inflateFragement(newInstance: Fragment)
    {
        val transanction = supportFragmentManager.beginTransaction();
        transanction.replace(R.id.container, newInstance)
        transanction.commit();


    }

}










