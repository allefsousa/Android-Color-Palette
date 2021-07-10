package com.developer.colorpalette

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.developer.colorpalette.databinding.ActivityMainBinding


const val IMAGE = "https://images.unsplash.com/photo-1625806786037-2af608423424?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this)
            .load(IMAGE)
            .into(binding.image)

        Glide.with(this).asBitmap()
            .load(IMAGE)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    Palette.from(resource).generate { palette ->

                        palette?.let { paletteNo ->
                            binding.viewDarkVibrant.setBackgroundColor(paletteNo.getDarkVibrantColor(R.color.black))
                            binding.viewDarkMuted.setBackgroundColor(paletteNo.getDarkMutedColor(R.color.black))
                            binding.viewLightMuted.setBackgroundColor(paletteNo.getLightMutedColor(R.color.black))
                            binding.viewLightVibrant.setBackgroundColor(paletteNo.getLightVibrantColor(R.color.black))
                            binding.viewMuted.setBackgroundColor(paletteNo.getMutedColor(R.color.black))
                            binding.viewVibrant.setBackgroundColor(paletteNo.getVibrantColor(R.color.black))
                            binding.viewDominant.setBackgroundColor(paletteNo.getDominantColor(R.color.black))
                            binding.root.setBackgroundColor(paletteNo.getVibrantColor(R.color.black))

                        }
                    }
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                }

            })
    }
}