package com.example.dogshare.VKLib.meth

import android.util.Log
import com.example.dogshare.VKLib.model.VKProfileInfo
import com.example.dogshare.VKLib.model.VKUser
import com.example.dogshare.VKLib.request.VKGetProfileInfo
import com.example.dogshare.VKLib.request.VKGetUsers
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback

class Meth {
    fun getUsers() {
        val callback = object : VKApiCallback<List<VKUser>> {
            override fun success(result: List<VKUser>) {
                Log.d("getUsers", "success");
            }

            override fun fail(error: Exception) {
                Log.d("getUsers", "fail");
            }
        }

        VK.execute(VKGetUsers(), callback)
    }

    fun getProfile() {
        val callback = object : VKApiCallback<VKProfileInfo> {
            override fun success(result: VKProfileInfo) {
                Log.d("getProfile", "success");
            }

            override fun fail(error: Exception) {
                Log.d("getProfile", "fail");
            }
        }

        VK.execute(VKGetProfileInfo(), callback)
    }
}