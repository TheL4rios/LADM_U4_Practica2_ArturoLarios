package mx.edu.ittepic.ladm_u4_practica2

import android.graphics.Bitmap
import android.graphics.Paint
import android.view.View
import android.graphics.Canvas

class Shapes(private val v : View)
{
    private lateinit var image : Bitmap
    private var width : Float = 0f

    private val radio = 300f

    fun drawSun(p : Paint, canvas : Canvas)
    {
        canvas.drawCircle(v.width.toFloat(), 0f, radio, p)
    }

    fun colorSky(p : Paint, canvas : Canvas)
    {
        canvas.drawRect(0f, 0f, v.width.toFloat(), v.height.toFloat(), p)
    }

    fun drawGrass(p : Paint, canvas : Canvas)
    {
        canvas.drawRect(0f, v.height.toFloat(), v.width.toFloat(), v.height.toFloat() - (v.height * 0.25f), p)
    }

    fun drawCloud(p : Paint, canvas : Canvas)
    {
        canvas.drawCircle(v.width * 0.277f, 400f, 100f, p)
        canvas.drawCircle(v.width * 0.277f, 600f, 100f, p)
        canvas.drawCircle(v.width * 0.37f, 500f, 100f, p)
        canvas.drawCircle(v.width * 0.185f, 500f, 100f, p)
    }

    fun setImage(image : Bitmap)
    {
        this.image = image
        width = image.width.toFloat()
    }

    fun drawImage(p : Paint, canvas : Canvas, x : Float, y : Float)
    {
        canvas.drawBitmap(image, x, y, p)
    }
}