package com.ekyc.extendedfabbutton

import android.graphics.drawable.GradientDrawable.Orientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnScrollChangeListener
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.rcv)
        val btnFab: ExtendedFloatingActionButton = findViewById(R.id.btnFab)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val emailList = mutableListOf<Email>()

        emailList.add(Email("Meeting Reminder", "Don't forget our meeting at 10 AM."))
        emailList.add(Email("Welcome!", "Thank you for signing up!"))
        emailList.add(Email("Invoice", "Your invoice #12345 is attached."))
        emailList.add(Email("Offer Alert", "Exclusive deals just for you!"))
        emailList.add(Email("Security Alert", "A new login was detected."))
        emailList.add(Email("Event Update", "Your event starts in 2 hours."))
        emailList.add(Email("Newsletter", "Check out our latest updates."))
        emailList.add(Email("Subscription", "Your subscription has been renewed."))
        emailList.add(Email("Support Ticket", "Your issue has been resolved."))
        emailList.add(Email("Happy Birthday!", "Wishing you a great day!"))
        emailList.add(Email("Security Alert", "A new login was detected."))
        emailList.add(Email("Event Update", "Your event starts in 2 hours."))
        emailList.add(Email("Newsletter", "Check out our latest updates."))
        emailList.add(Email("Subscription", "Your subscription has been renewed."))
        emailList.add(Email("Support Ticket", "Your issue has been resolved."))
        emailList.add(Email("Happy Birthday!", "Wishing you a great day!"))
        recyclerView.adapter = Adapter(emailList)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                Log.d("TAGGGG", "COUNT: dy=${recyclerView.childCount}")

                if (dy > 30 && btnFab.isExtended) {
                    // Scrolling down, shrink FAB
                    btnFab.shrink()
                }
                if (dy < -30 && !btnFab.isExtended) {
                    // Scrolling up, extend FAB
                    btnFab.extend()
                }

                /*  direction:
                  1 → Checks if scrolling down is possible.
                  -1 → Checks if scrolling up is possible.
                  Return Value:
  true → If the RecyclerView can scroll in the given direction.
  false → If it cannot scroll in the given direction (i.e., reached the start or end).
                  */
                if (!recyclerView.canScrollVertically(-1)) {
                    btnFab.extend()
                }

            }
        })


    }
}