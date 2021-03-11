package com.arifahmadalfian.thesportsdb.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.arifahmadalfian.thesportsdb.R
import com.arifahmadalfian.thesportsdb.core.domain.model.Sport
import com.arifahmadalfian.thesportsdb.core.ui.ViewModelFactory
import com.arifahmadalfian.thesportsdb.databinding.ActivityDetailSportBinding
import com.bumptech.glide.Glide

class DetailSportActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var detailSportViewModel: DetailSportViewModel
    private lateinit var binding: ActivityDetailSportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val factory = ViewModelFactory.getInstance(this)
        detailSportViewModel = ViewModelProvider(this, factory)[DetailSportViewModel::class.java]

        val detailSport = intent.getParcelableExtra<Sport>(EXTRA_DATA)
        showDetailSport(detailSport)
    }

    private fun showDetailSport(detailSport: Sport?) {
        detailSport?.let {
            supportActionBar?.title = detailSport.strSport
            binding.content.tvDetailDescription.text = detailSport.strSportDescription
            Glide.with(this@DetailSportActivity)
                    .load(detailSport.strSportThumb)
                    .into(binding.ivDetailImage)

            var statusFavorite = detailSport.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailSportViewModel.setFavoriteSport(detailSport, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }

    }
}