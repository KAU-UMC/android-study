package com.example.flo

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flo.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity(){ // 안드로이드에서 Activity의 기능을 사용할 수 있도록 만든 클래스

    lateinit var binding : ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.songDownIb.setOnClickListener{
            finish()
        }
        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(false)
        }

        binding.songPauseIv.setOnClickListener{
            setPlayerStatus(true)
        }
        if (intent.hasExtra("title") && intent.hasExtra("singer")) // intent에 있다면
        {
            binding.songMusicTitleTv.text = intent.getStringExtra("title") // textView의 text를 intent의 title key값으로 바꿔줌
            binding.songSingerNameTv.text = intent.getStringExtra("singer") // textView의 text를 intent의 singer key값으로 바꿔줌
        }
    }

    fun setPlayerStatus(isPlaying : Boolean) {
        if (isPlaying) {
            binding.songMiniplayerIv.visibility = View.VISIBLE // 재생 버튼 보이게
            binding.songPauseIv.visibility = View.GONE // 정지 버튼 안보이게
        }
        else { // 재생 중이 아닐 때
            binding.songMiniplayerIv.visibility = View.GONE // 재생 버튼 안보이게
            binding.songPauseIv.visibility = View.VISIBLE // 정지 버튼 보이게
        }
    }
}