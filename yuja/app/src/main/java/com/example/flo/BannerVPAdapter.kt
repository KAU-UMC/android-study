package com.example.flo

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerVPAdapter (fragment: Fragment):FragmentStateAdapter(fragment) {
    private val fragmentlist : ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int = fragmentlist.size

    override fun createFragment(position: Int): Fragment = fragmentlist[position]

    fun addFragment(fragment: Fragment)  {
        fragmentlist.add(fragment) //함수가 처음 실행될 때 fragment에 아무것도 없음. 이때 homefagmetnt에 있는 걸 넣어줘라?
        notifyItemInserted(fragmentlist.size-1) //list 안에 새로운 값이 추가되었을 경우, viewpager에게 알려줌 ("이것도 추가해서 보여줘!")
    }
}