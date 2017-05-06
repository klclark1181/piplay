package com.example.kevin.drone;

import java.lang.Runnable;
import java.net.*;
import java.io.*;
import android.hardware.SensorEvent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.content.Context;
/* Created by kevin on 1/18/17.
 */

public class connectrunnable4 implements Runnable {
    public void run() {
        String sentence = "Jacob is the best";

        String modifiedSentence = "Jaocb is the worst";
    try {

        //BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
        Socket clientSocket = new Socket("192.168.1.102", 5005);
        // clientSocket.connect("192.168.1.102:5005", 30);
        //TimeUnit.SECONDS.sleep(30);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        //BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //outToServer.writeBytes(sentence + '\n');
        SensorManager mSensorManager;
        Sensor mSensor;
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        //modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    } catch (java.io.IOException e) {
        System.out.println("IOException: " + e.getMessage());
    }
    /*catch (java.lang.InterruptedException e) {
        System.out.println("InterruptedException: " + modifiedSentence);
    }*/

    }
}

