package com.maruf.firebaseauth.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.google.android.material.tabs.TabLayoutMediator
import com.maruf.firebaseauth.ChatFragment
import com.maruf.firebaseauth.ProfileFragment
import com.maruf.firebaseauth.UsersFragment
import com.maruf.firebaseauth.databinding.FragmentHomeBinding
import com.maruf.firebaseauth.model.userInfo.UserInfo
import com.maruf.firebaseauth.viewPagerAdapter.ViewPager2Adapter
import com.maruf.firebaseauth.viewmodel.FirebaseViewModel


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,null,false)

        setTab()

        return binding.root
    }
    private fun setTab() {
        val tabNameArray = arrayOf("Home","Chat","Profile")


        val viewPagerAdapter =
            ViewPager2Adapter(childFragmentManager, viewLifecycleOwner.lifecycle).apply {
                addFragment(UsersFragment())
                addFragment(ChatFragment())
                addFragment(ProfileFragment())

            }
        binding.apply {
            vpMain.apply {
                adapter = viewPagerAdapter
            }

            TabLayoutMediator(tabCategory, vpMain) { tab, position ->
                tab.text = tabNameArray[position]
            }.attach()

        }
    }


}