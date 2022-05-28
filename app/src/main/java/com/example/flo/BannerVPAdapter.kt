package com.example.flo

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BannerVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){

    private val fragmentlist : ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int = fragmentlist.size // 데이터를 몇 개를 전달할 것이냐 / 함수 자체 초기화 방법 : 한줄만 작성 시

    override fun createFragment(position: Int): Fragment = fragmentlist[position] // fragment 생성, count 된 곳까지 반환

    fun addFragment(fragment: Fragment) { // 처음 생성시 list 빔, homeFragment 에서 추가해준 Fragment를 써주기 위함
        fragmentlist.add(fragment)
        notifyItemInserted(fragmentlist.size-1) // viewPager에 새로운 값이 추가되었다고 알려주기 위함, 추가된 위치를 넣음
    }


}