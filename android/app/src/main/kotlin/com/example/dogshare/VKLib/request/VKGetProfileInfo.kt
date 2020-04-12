package com.example.dogshare.VKLib.request

import com.example.dogshare.VKLib.model.VKProfileInfo
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject
import java.util.ArrayList

class VKGetProfileInfo: VKRequest<VKProfileInfo> {
    constructor(): super("account.getProfileInfo") {
    }

    override fun parse(r: JSONObject): VKProfileInfo {
        val res = r.getJSONObject("response")
        return VKProfileInfo.parse(res)
    }

}