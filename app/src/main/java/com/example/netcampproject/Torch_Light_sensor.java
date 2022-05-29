package com.example.netcampproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class Torch_Light_sensor extends AppCompatActivity implements SensorEventListener{
        CameraManager cameraManager;
        SensorManager sensorManager;
        Sensor sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_torch__light_sensor);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        cameraManager=(CameraManager) getSystemService(CAMERA_SERVICE);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.values[0]>1){
            try {
                String s=cameraManager.getCameraIdList()[0];
                cameraManager.setTorchMode(s, true);
            }
            catch (Exception e){

            }
        }
        else {
            try {
                String s=cameraManager.getCameraIdList()[0];
                cameraManager.setTorchMode(s, false);

            } catch (Exception e) {

            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}