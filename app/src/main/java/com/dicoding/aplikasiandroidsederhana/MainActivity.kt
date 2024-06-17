package com.dicoding.aplikasiandroidsederhana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvAnimes: RecyclerView
    private val list = ArrayList<Anime>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Rekomendasi Top 10 Anime"

        rvAnimes = findViewById(R.id.rv_anime)
        rvAnimes.setHasFixedSize(true)

        list.addAll(getListAnimes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_about_page -> {
                val moveIntent = Intent(this@MainActivity,About::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListAnimes(): ArrayList<Anime> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataImage = resources.obtainTypedArray(R.array.data_image)
        val dataGenre = resources.getStringArray(R.array.data_genre)
        val dataAuthor= resources.getStringArray(R.array.data_author)
        val dataRating = resources.getStringArray(R.array.data_rating)
        val listAnime = ArrayList<Anime>()
        for(i in dataTitle.indices) {
            val anime = Anime(dataTitle[i], dataDescription[i], dataImage.getResourceId(i, -1),dataGenre[i],dataAuthor[i],
                dataRating[i].toDouble()
            )
            listAnime.add(anime)
        }
        return listAnime
    }

    private fun showRecyclerList() {
        rvAnimes.layoutManager = LinearLayoutManager(this)
        val listAnimeAdapter  = ListAnimeAdapter(list)
        rvAnimes.adapter = listAnimeAdapter

    }


}