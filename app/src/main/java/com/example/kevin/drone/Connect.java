package com.example.kevin.drone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

public class Connect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                setContentView(R.layout.connecting);

                String sentence = "Jacob is the best";

                String modifiedSentence = "Jaocb is the worst";
                //BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
                try {
                    Socket clientSocket = new Socket("localhost", 5005);
                    clientSocket.connect("192.168.1.102:5005", 30);
                    //TimeUnit.SECONDS.sleep(30);
                    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    outToServer.writeBytes(sentence + '\n');
                    //modifiedSentence = inFromServer.readLine();
                    System.out.println("FROM SERVER: " + modifiedSentence);
                    clientSocket.close();
                } catch (java.io.IOException e) {

                    System.out.println("IOException: " + e.getMessage());
                }
                catch (java.lang.InterruptedException e) {

                    System.out.println("InterruptedException: " + modifiedSentence);
                }

            }
        });

    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
