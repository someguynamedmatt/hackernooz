package com.my.hackernooz

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import com.my.hackernooz.services.Http
import com.my.hackernooz.views.MainView
import com.my.hackernooz.views.RecipeView
import org.jetbrains.anko.setContentView
import android.widget.ArrayAdapter




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val http: Http = Http()
        //http.get("/askstories.json?print=pretty")
        //http.get("/item/14651665.json?print=pretty")
// 1
        var mListView = RecipeView(this)
        val recipeList = Recipe.getRecipesFromFile("recipes.json", this)
// 2
        val listItems = arrayOfNulls<String>(recipeList.size)
// 3
        for (i in 0..recipeList.size - 1) {
            val recipe = recipeList[i]
            listItems[i] = recipe.title
        }
// 4
        val adapter = RecipeAdapter(this, recipeList)
        mListView.adapter = adapter
        setContentView(mListView)

        /*
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        */
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        // menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        /*
        if (id == R.id.action_settings) {
            return true
        }
        */

        return super.onOptionsItemSelected(item)
    }
}
