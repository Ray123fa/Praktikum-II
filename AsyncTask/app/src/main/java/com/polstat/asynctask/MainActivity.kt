package com.polstat.asynctask

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.FutureTask

class MainActivity : AppCompatActivity() {

    private var imageView: ImageView? = null
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.asyncTask)
        imageView = findViewById(R.id.image)

        button?.setOnClickListener {
            // Menggunakan ExecutorService dan FutureTask
            val executor: ExecutorService = Executors.newFixedThreadPool(1)
            val futureTask = FutureTask(DownloadTask("https://stis.ac.id/media/source/up.png"))
            executor.execute(futureTask)

            try {
                val bmImg = futureTask.get() // Mendapatkan hasil dari FutureTask
                imageView?.setImageBitmap(bmImg)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            }

            executor.shutdown()
        }
    }

    // Callable untuk mendownload gambar secara asynchronous
    private class DownloadTask(private val imageUrl: String) : Callable<Bitmap?> {
        override fun call(): Bitmap? {
            return try {
                val url = URL(imageUrl)
                val conn = url.openConnection() as HttpURLConnection
                conn.doInput = true
                conn.connect()
                val inputStream: InputStream = conn.inputStream
                val options = BitmapFactory.Options()
                options.inPreferredConfig = Bitmap.Config.RGB_565
                BitmapFactory.decodeStream(inputStream, null, options)
            } catch (e: IOException) {
                e.printStackTrace()
                null
            }
        }
    }
}
