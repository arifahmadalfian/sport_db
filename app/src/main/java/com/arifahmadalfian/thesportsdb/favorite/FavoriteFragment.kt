package com.arifahmadalfian.thesportsdb.favorite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifahmadalfian.thesportsdb.R
import com.arifahmadalfian.thesportsdb.core.ui.SportAdapter
import com.arifahmadalfian.thesportsdb.core.ui.ViewModelFactory
import com.arifahmadalfian.thesportsdb.databinding.FragmentFavoriteBinding
import com.arifahmadalfian.thesportsdb.detail.DetailSportActivity

class FavoriteFragment : Fragment() {

    private lateinit var favoriteViewModel: FavoriteViewModel

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val sportAdapter = SportAdapter()
            sportAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailSportActivity::class.java)
                intent.putExtra(DetailSportActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            val factory = ViewModelFactory.getInstance(requireActivity())
            favoriteViewModel = ViewModelProvider(this, factory).get(FavoriteViewModel::class.java)

            favoriteViewModel.favoriteSport.observe(viewLifecycleOwner, { dataSport ->
                sportAdapter.setData(dataSport)
                binding.viewEmpty.root.visibility = if (dataSport.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvSport) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = sportAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}