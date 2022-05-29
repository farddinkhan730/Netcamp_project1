package com.example.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;

public class Torch_Acelerometer extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    Sensor sensor;
    CameraManager cameraManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch__acelerometer);
        getSupportActionBar().setTitle("Torch App ");
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        cameraManager=(CameraManager)getSystemService(CAMERA_SERVICE);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x=event.values[0];
        float y=event.values[1];
        float z=event.values[2];
        int x1=(int)x;
        int y1=(int)y;
        int z1=(int)z;
        if(x1!=0){
            String s= null;
            try {
                String s2 = cameraManager.getCameraIdList()[0];
                cameraManager.setTorchMode(s2,true);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }

        }
        else {
            try {
                String s1 = cameraManager.getCameraIdList()[0];
                cameraManager.setTorchMode(s1,false);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}