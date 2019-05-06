package com.example.starwars.util

import android.content.Context
import java.io.BufferedReader
import javax.inject.Inject


class FileUtil @Inject constructor(){
    fun fileToBufferedReader(context: Context, filePath: String) : BufferedReader{
        val am = context.getAssets()
        return  am.open(filePath).bufferedReader()
    }
}