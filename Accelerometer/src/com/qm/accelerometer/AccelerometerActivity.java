package com.qm.accelerometer;

import com.qm.accelerometer.R;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.view.Menu;

public class AccelerometerActivity extends Activity {
    /** Start accelerometer readings */
    protected Button start = null;
    /** Stop accelerometer readings */
    protected Button stop = null;
    protected TextView X = null;
    protected TextView Y = null;
    protected TextView Z = null;
    protected TextView SUM = null;
    protected TextView AVG = null;
    private SensorManager sensorManager = null;
    private Boolean supported = null;
    private boolean accelerometerRunning = false;
    private static AccelerometerActivity accelerometerListener = null;
    private Sensor sensor = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        start = (Button) findViewById(R.id.button1);
        stop = (Button) findViewById(R.id.button2);
        X = (TextView)  findViewById(R.id.textView1);
        Y = (TextView)  findViewById(R.id.textView2);
        Z = (TextView)  findViewById(R.id.textView3);
        SUM = (TextView)  findViewById(R.id.textView4);
        AVG = (TextView)  findViewById(R.id.textView5);

        start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startAccelerometer();
            }
        });

        stop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAccelerometer();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_accelerometer, menu);
        return true;
    }

    /**
     * Starts the program.
     */
    private void startAccelerometer() {
        if (isSupported()) {
            startListening(this);
        }
    }

    /**
     * Stops the program.
     */
    private void stopAccelerometer() {
        if (isListening()) {
            stopListening();
        }
    }

    /**
     * Returns true if the manager is listening to orientation changes.
     */
    private boolean isListening() {
        return accelerometerRunning;
    }

    /**
     * Returns true if at least one accelerometer sensor is available.
     */
    private boolean isSupported() {
        if (supported == null) {
            if (getBaseContext() != null) {
                sensorManager = (SensorManager)
                        getSystemService(Context.SENSOR_SERVICE);
                List<Sensor> acclerometerSensor =
                        sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
                supported = acclerometerSensor.size() > 0;
            } else {
                supported = false;
            }
        }

        return supported;
    }

    /**
     * Registers a accelerometerListener and start listening.
     *
     * @param accelerometerListener callback for accelerometer events
     */
    private void startListening(AccelerometerActivity al) {
        List<Sensor> sensors =
                sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (sensors.size() > 0) {
            sensor = sensors.get(0);
            accelerometerRunning = sensorManager.registerListener(
                sensorEventListener,
                sensor,
                SensorManager.SENSOR_DELAY_NORMAL
            );
            accelerometerListener = al;
        }
    }

    /**
     * Unregisters listeners.
     */
    private void stopListening() {
        accelerometerRunning = false;

        try {
            if (sensorManager != null && sensorEventListener != null) {
                sensorManager.unregisterListener(sensorEventListener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onAccelerationChanged(float x, float y, float z) {
        X.setText("X: " + String.valueOf(x));
        Y.setText("Y: " + String.valueOf(y));
        Z.setText("Z: " + String.valueOf(z));

        float sum = x + y + z;
        SUM.setText("Sum: " + String.valueOf(sum));
        float avg = sum/3;
        AVG.setText("Avg: " + String.valueOf(avg));
    }

    /**
     * The accelerometerListener that listen to events from the accelerometer
     * accelerometerListener.
     */
    private static SensorEventListener sensorEventListener = new
            SensorEventListener() {
        private float x = 0;
        private float y = 0;
        private float z = 0;

        public void onAccuracyChanged(Sensor sensor, int accuracy) {}

        public void onSensorChanged(SensorEvent event) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];
            accelerometerListener.onAccelerationChanged(x, y, z);
        }
    };
}
