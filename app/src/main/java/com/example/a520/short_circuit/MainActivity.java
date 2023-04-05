package com.example.a520.short_circuit;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a520.short_circuit.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;


public class MainActivity extends Activity {
    //Metodo chamado quando a aplicacao e criada
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer mediaPlayer_abertura = MediaPlayer.create(MainActivity.this, R.raw.abertura);
        mediaPlayer_abertura.start();
        try {
            ListaDeFases();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Metodo chamado quando a aplicacao e criada
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void ListaDeFases() throws IOException {
        final Button botao_play = (Button) findViewById(R.id.botao_play);
        botao_play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                MediaPlayer mediaPlayer_abertura = MediaPlayer.create(MainActivity.this, R.raw.abertura);
                mediaPlayer_abertura.start();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ListaDeFases.class);
                startActivity(intent);
                //finish();
            }
        });
    }
}