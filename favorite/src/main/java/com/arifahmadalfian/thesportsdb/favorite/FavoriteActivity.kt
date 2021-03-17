package com.arifahmadalfian.thesportsdb.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifahmadalfian.thesportsdb.core.ui.SportAdapter
import com.arifahmadalfian.thesportsdb.detail.DetailSportActivity
import com.arifahmadalfian.thesportsdb.favorite.databinding.ActivityFavoriteBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity: AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModels by viewModel()

    private var _binding: ActivityFavoriteBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        _binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

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
