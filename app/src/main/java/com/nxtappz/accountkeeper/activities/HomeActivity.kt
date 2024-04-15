package com.nxtappz.accountkeeper.activities

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.nxtappz.accountkeeper.R
import com.nxtappz.accountkeeper.fragments.AddAccountFragment
import com.nxtappz.accountkeeper.fragments.ViewAccountsFragment

class HomeActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout;
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle;
    private lateinit var navigationView: NavigationView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_accounts -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, ViewAccountsFragment())
                        .commit();
                    closeDrawer();
                    true;
                }

                R.id.nav_new_account -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, AddAccountFragment())
                        .commit();
                    closeDrawer();
                    true;
                }

                else -> false
            }

        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, ViewAccountsFragment())
            .commit();

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // check conndition for drawer item with menu item
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            Log.d("Menu Id", "" + item.itemId);
            true
        } else {
            super.onOptionsItemSelected(item)
        }

    }

    private fun closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START)
    }
}