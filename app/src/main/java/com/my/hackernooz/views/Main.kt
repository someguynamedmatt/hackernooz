package com.my.hackernooz.views

import android.content.Context
import android.support.design.R.id.center
import android.widget.ListView
import com.my.hackernooz.MainActivity
import com.my.hackernooz.R
import com.my.hackernooz.Recipe
import com.my.hackernooz.RecipeAdapter
import org.jetbrains.anko.*

/**
 * Created by my on 6/27/17.
 */
class MainView(adapter: RecipeAdapter, context: Context): AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            relativeLayout {
                textView("Shit").lparams {
                    centerHorizontally()
                }
            }
            listView {
                textView(adapter.toString()).lparams {
                    width = matchParent
                }
            }
        }
    }
}