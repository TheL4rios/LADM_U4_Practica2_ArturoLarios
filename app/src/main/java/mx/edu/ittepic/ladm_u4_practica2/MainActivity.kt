package mx.edu.ittepic.ladm_u4_practica2

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SensorEventListener {

    private var mSensorManager : SensorManager ?= null
    private var mAccelerometer : Sensor ?= null
    private var mProximity : Sensor ?= null
    private var canvas : Canvas ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        canvas = Canvas(this)

        setContentView(canvas)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mProximity = mSensorManager?.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        mSensorManager?.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_GAME)
        mSensorManager?.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onPause() {
        super.onPause()

        mSensorManager?.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent)
    {
        if (event.sensor.type == Sensor.TYPE_PROXIMITY)
        {
            val proximity = event.values[0]
            canvas?.let { c ->
                if (proximity == 0f)
                    c.changeImage(c.UMBREON)
                else
                    c.changeImage(c.EEVEE)
            }
        }

        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER)
        {
            val x = event.values[0]
            canvas?.moveImage(x)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int){}
}
