package com.kalyani.flashlightusingjava

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.kalyani.flashlightusingjava.databinding.ActivityFlastLightKotlinBinding
import java.lang.Exception

class FlashLightActivityKotlin : AppCompatActivity() {

    private lateinit var binding: ActivityFlastLightKotlinBinding
    private lateinit var cameraManager: CameraManager
    private var state = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlastLightKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager

        binding.torchBtn.setOnClickListener {
            if (!state) {
                try {
                    val camId = cameraManager.cameraIdList[0]
                    cameraManager.setTorchMode(camId, true)
                    state = true
                    binding.torchBtn.setImageResource(R.drawable.torch_on)
                } catch (e: Exception) {}
                
            } else {
                try {
                    val camId = cameraManager.cameraIdList[0]
                    cameraManager.setTorchMode(camId, false)
                    state = false
                    binding.torchBtn.setImageResource(R.drawable.torch_off)
                } catch (e: Exception) {}
            }
        }
    }
}