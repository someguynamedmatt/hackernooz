package com.my.hackernooz.views

import android.content.Context
import android.widget.ListView
import com.my.hackernooz.MainActivity
import com.my.hackernooz.RecipeAdapter
import org.jetbrains.anko.*

/**
 * Created by my on 6/28/17.
 */
class RecipeView(context: Context): ListView(context){
    fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            listView {

            }
        }
    }
}
