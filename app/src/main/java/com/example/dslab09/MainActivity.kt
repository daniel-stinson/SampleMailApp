package com.example.dslab09

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val drawerLayout: DrawerLayout=findViewById(R.id.myDrawerLayout)
    val navView: NavigationView = findViewById(R.id.myDrawerView)

    myToggle = ActionBarDrawerToggle(this,drawerLayout,0,0)

    myDrawerLayout.addDrawerListener(myToggle)

    myToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    navView.setNavigationItemSelectedListener{
        when (it.itemId) {
            R.id.sentId -> {
                Snackbar.make(findViewById(R.id.sentId),"Your email has been" +
                        " sent successfully",Snackbar.LENGTH_LONG).show()
                         }
            R.id.outboxId -> {
                Snackbar.make(findViewById(R.id.outboxId),"This is your outbox " +
                        "folder",Snackbar.LENGTH_LONG).show()
                            }
            R.id.spamId -> {
                Snackbar.make(findViewById(R.id.spamId),"This is your spam" +
                        "folder",Snackbar.LENGTH_LONG).show()
                        }
            R.id.calendarId-> {
                Snackbar.make(findViewById(R.id.calendarId),"This is your" +
                        "calendar", Snackbar.LENGTH_LONG).show()
                            }
            R.id.contactsId -> {
                startActivity(Intent(this,Contacts::class.java))}
            }
            true
        }
    }

override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if(myToggle.onOptionsItemSelected(item)) {
        return true
            }
        return super.onOptionsItemSelected(item)
        }
}
