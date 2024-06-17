package com.dicoding.aplikasiandroidsederhana

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailAnime : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_anime)
        supportActionBar?.title = "Detail Anime"


        val dataAnime = intent.getParcelableExtra("key_anime") as? Anime

        val detailTitle: TextView = findViewById(R.id.detail_title)
        val detailDesc: TextView = findViewById(R.id.detail_desc)
        val detailImg: ImageView = findViewById(R.id.detail_img)
        val detailAuthor: TextView = findViewById(R.id.detail_author)
        val detailGenre:TextView  = findViewById(R.id.detail_genre)
        val detailRating:TextView = findViewById(R.id.detail_rating)

        detailTitle.text = dataAnime?.title
        detailDesc.text = dataAnime?.description
        detailImg.setImageResource(dataAnime!!.image)
        detailAuthor.text = dataAnime.author
        detailGenre.text = dataAnime.genre
        detailRating.text = dataAnime.rating.toString()

    }
}