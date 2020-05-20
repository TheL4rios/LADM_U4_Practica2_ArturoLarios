package mx.edu.ittepic.ladm_u4_practica2

import android.annotation.SuppressLint
import android.graphics.*
import android.graphics.Canvas
import android.view.View
import kotlin.math.abs

class Canvas(main : MainActivity) : View(main)
{
    val EEVEE = "eevee"
    val UMBREON = "UMBREON"

    private var r = 25
    private var g = 158
    private var b = 218

    private var imageX = 100f

    private var shapes : Shapes = Shapes(this)
    private val eevee : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.eevee)
    private val umbreon : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.umbreon)

    init {
        shapes.setImage(eevee)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val p = Paint()

        with(shapes)
        {
            canvas?.let { c ->
                p.color = Color.rgb(r, g, b)
                colorSky(p, c)

                p.color = Color.YELLOW
                drawSun(p, c)

                p.color = Color.rgb(53, 104, 45)
                drawGrass(p, c)

                p.color = Color.WHITE
                drawCloud(p, c)

                drawImage(p, c, imageX, height - height * 0.3f)
            }
        }

        invalidate()
    }

    fun moveImage(imgX : Float)
    {
        // imgX < 0 -> right
        // imgX > 0 -> left
        if (imgX < 0)
            imageX += abs(imgX) * 5
        else if (imgX > 0)
            imageX -= abs(imgX) * 5
    }

    fun changeImage(pokemon : String)
    {
        when(pokemon)
        {
            this.EEVEE -> {
                shapes.setImage(eevee)
                r = 25
                g = 158
                b = 218
            }
            this.UMBREON -> {
                shapes.setImage(umbreon)
                r = 0
                g = 0
                b = 0
            }
        }
    }
}