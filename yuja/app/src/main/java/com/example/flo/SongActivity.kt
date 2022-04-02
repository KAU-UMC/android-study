package com.example.flo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flo.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    lateinit var binding : ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.songDownIb.setOnClickListener {
            finish()
        }

        binding.songMiniplayerIv.setOnClickListener {
            setPlayStatus(false)
        }

        binding.songPauseIv.setOnClickListener {
            setPlayStatus(true)
        }

        //데이터를 받아왔다면(intent에 title&singer가 있는지 확인)
       if (intent.hasExtra("title") && intent.hasExtra("singer")) {
           //텍스트 변경
           binding.songTitleTv.text = intent.getStringExtra("title")
           binding.songSingerTv.text = intent.getStringExtra("singer")
       }
    }

    fun setPlayStatus(isPlaying: Boolean) {
        if(isPlaying){
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        }
        else {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
    }
}