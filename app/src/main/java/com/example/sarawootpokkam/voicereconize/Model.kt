package com.example.sarawootpokkam.voicereconize

data class Model(var arrStr: ArrayList<String>? = null) {

    fun text(): String? {
        arrStr?.forEach {
            return when (it.toLowerCase()) {
                "hello" -> "ควยไร"
                else -> "ไม่รู้จักเลยควย"
            }
        }
        return null
    }
}