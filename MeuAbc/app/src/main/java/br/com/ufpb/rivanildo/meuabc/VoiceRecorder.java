package br.com.ufpb.rivanildo.meuabc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.view.View;
import android.util.Log;
import android.media.MediaRecorder;
import android.media.MediaPlayer;
import java.io.IOException;


/**
 * Created by Rivanildo on 23/04/16.
 */
public class VoiceRecorder extends AppCompatActivity {
    private static final String LOG_TAG = "AudioRecordTest";
    private static String mFileName = null;;

    private MediaRecorder mRecorder = null;

    private MediaPlayer   mPlayer = null;

    private Button gravar;
    private Button reproduzir;

    public VoiceRecorder(Button gravar, Button reproduzir) {
        this.gravar = gravar;
        this.reproduzir = reproduzir;
    }

    public void onRecord() {
        boolean start;
        String buttonString = gravar.getText().toString();
        if(buttonString.equals("Iniciar")){
            start = true;
        }
        else{
            start = false;
        }

        if (start) {
            try {
                gravar.setText("Parar");
                startRecording();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            gravar.setText("Iniciar");
            reproduzir.setEnabled(true);
            stopRecording();
        }
    }

    public void onPlay() { //reproduzir
        boolean start;
        String buttonString = reproduzir.getText().toString();
        if(buttonString.equals("Reproduzir")){
            start = true;
        }
        else{
            start = false;
        }
        if (start) {
            reproduzir.setText("Parar");
            startPlaying();
        } else {
            reproduzir.setText("Reproduzir");
            stopPlaying();
        }
    }

    private void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }

    private void startRecording() throws IOException {
        mRecorder = new MediaRecorder();
        AudioRecordTest();
        //mFileName = Environment.getExternalStorageDirectory().getAbsolutePath().substring(8) + "/audio/" +  System.currentTimeMillis()+ ".3gp";
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mRecorder.start();
    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    public void AudioRecordTest() {
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/audiorecordtest.3gp";
    }

//    @Override
//    public void onCreate(Bundle icicle) {
//        super.onCreate(icicle);
//
//        //setContentView(R.layout.activity_voice_recorder);
//        //Button myRecordButton = gravar;
//        gravar.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                onRecord();
//            }
//        });
//       // Button myPlayButton = reproduzir;
//        reproduzir.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                onPlay();
//            }
//        });
//
//    }

    @Override
    public void onPause() {
        super.onPause();
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }

        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
}
