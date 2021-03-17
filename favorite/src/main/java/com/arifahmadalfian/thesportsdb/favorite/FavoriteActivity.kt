package com.arifahmadalfian.thesportsdb.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifahmadalfian.thesportsdb.core.ui.SportAdapter
import com.arifahmadalfian.thesportsdb.detail.DetailSportActivity
import com.arifahmadalfian.thesportsdb.di.DynamicFeatureDependencies
import com.arifahmadalfian.thesportsdb.favorite.databinding.ActivityFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors

@AndroidEntryPoint
class FavoriteActivity: AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModels by viewModels()

    private var _binding: ActivityFavoriteBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {

        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    DynamicFeatureDependencies::class.java
                )
            )
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
        _binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Favorite Sports"

        getFavoriteData()
    }

    private fun getFavoriteData() {
        val sportAdapter = SportAdapter()
        sportAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailSportActivity::class.java)
            intent.putExtra(DetailSportActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteSport.observe(this, { dataSport ->
            sportAdapter.setData(dataSport)
            binding.viewEmpty.root.visibility = if (dataSport.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvSport) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = sportAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
