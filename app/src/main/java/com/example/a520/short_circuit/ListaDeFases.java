package com.example.a520.short_circuit;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ViewAnimator;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class ListaDeFases extends Activity {
    public ManageFile file = new ManageFile(this);
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_fases);
        pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setVisibility(View.INVISIBLE);
        CriaListaFase();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent = new Intent(ListaDeFases.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_de_fases, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void CriaListaFase() {
        String fase = "1";
        try {
            fase = LeArquivoTxt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fase = fase.replace("\n","");
        final int fase_ =  Integer.parseInt(fase.toString());
        ArrayList<String> fases = InsereFasesNoListView(fase_);

        ListView listaFases = (ListView) findViewById(R.id.listaFases);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fases);
        listaFases.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //teste1 gif
        //ImageView imgAndroid;
        //AnimationDrawable mAnimation;
        //imgAndroid = (ImageView)findViewById(R.id.imgAndroid);
        //imgAndroid.setBackgroundResource(R.id.animacao_);
        //mAnimation = (AnimationDrawable)imgAndroid.getBackground();
        //mAnimation.start();

        //teste2 gif
        //AnimationDrawable mAnimation = (AnimationDrawable) findViewById(R.id.animation);
        //mAnimation.start();

        //teste view animator
        //ViewAnimator va = (ViewAnimator) findViewById(R.id.viewAnimator_);
        //va.addView((ImageView)findViewById(R.id.imgAndroid),1);
        //va.addView((ImageView)findViewById(R.id.imgAndroid),2);
        //va.showNext();

        //teste 1 cor
        // codigo pra alterar cor de elemento. pode ser usado parar carregar activity.
        // TextView linha = (TextView) findViewById(R.id.linha);
        //for(int i = 0; i < 256; i++){
        //    linha.setTextColor(Color.rgb(i, i, i));
        //}

        //gif
        //AnimationDrawable ad = new AnimationDrawable(R.Drawable.48_);

        //bkp cor antiga
        //android:background="@mipmap/cinza_escuro_"

        //teste fundo
        //View fundo = (View) findViewById(R.id.layout1);
        //fundo.setBackgroundColor(Color.rgb(255, 0, 255));
        //for(int i = 0; i < 1000; i++) {
        //    for(int j = 0; j < 1000; j++){
        //    }
        //}
        //fundo.setBackgroundColor(Color.rgb(0, 0, 255));

        //teste flipper
        //ViewFlipper vf = (ViewFlipper) findViewById(R.id.viewFlipper);
        //vf.setBackgroundColor(Color.rgb(0, 0, 0));
        //Thread.sleep(1000);
        //vf.setBackgroundColor(Color.rgb(0, 0, 255));
        //vf.setAutoStart(true);
        //vf.isFlipping();
        //vf.buildDrawingCache();

        //teste videoview
        //VideoView vv = (VideoView)findViewById(R.id.videoView);
        //vv.setVideoPath(String.valueOf(R.raw.toba));
        //vv.start();

        listaFases.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer mediaPlayer_abertura = MediaPlayer.create(ListaDeFases.this, R.raw.clique_opcao);
                mediaPlayer_abertura.start();
                if(position + 1 <= fase_){
                    pb.setVisibility(View.VISIBLE);
                    Intent intent = new Intent();
                    intent = new Intent(ListaDeFases.this, FaseGrid.class);
                    Bundle params = new Bundle();
                    int resposta = position;
                    params.putInt("fase", resposta + 1);
                    intent.putExtras(params);
                    startActivity(intent);
                    finish();
                }
                else{
                    ExibeMensagem("", "Complete the previous circuits to release it!");
                }
            }
        });
    }

    public String Criptografa(String chave){
        Random gerador = new Random();
        int random =  gerador.nextInt(100);
        String retorno = "";
        retorno += String.valueOf(random);
        random =  gerador.nextInt(100);
        retorno += "-";
        retorno += String.valueOf(random);
        random =  gerador.nextInt(100);
        retorno += "-";
        retorno += String.valueOf(random);
        random =  gerador.nextInt(100);
        retorno += "-";
        retorno += String.valueOf(random);
        random =  gerador.nextInt(100);
        retorno += "-";
        retorno += String.valueOf(random);
        random =  gerador.nextInt(100);
        retorno += "-";
        retorno += String.valueOf(random);
        random =  gerador.nextInt(100);
        retorno += "-";
        retorno += chave;
        random =  gerador.nextInt(100);
        retorno += "-";
        retorno += String.valueOf(random);
        random =  gerador.nextInt(100);
        return retorno;
    }

    public String Decriptografa(String chave){
        String[] retorno = chave.split("-");
        return retorno[7];
    }

    private ArrayList<String> InsereFasesNoListView(int fase_) {
        ArrayList<String> rotuloFases = new ArrayList<String>();

        String textoFase = "";
        rotuloFases.add("1 - Level 1 - Stage 1" + VerificaSituacaoFase(1, fase_));
        rotuloFases.add("2 - Level 1 - Stage 2" + VerificaSituacaoFase(2, fase_));
        rotuloFases.add("3 - Level 1 - Stage 3" + VerificaSituacaoFase(3, fase_));
        rotuloFases.add("4 - Level 1 - Stage 4" + VerificaSituacaoFase(4, fase_));
        rotuloFases.add("5 - Level 1 - Stage 5" + VerificaSituacaoFase(5, fase_));
        rotuloFases.add("6 - Level 1 - Stage 6" + VerificaSituacaoFase(6, fase_));
        rotuloFases.add("7 - Level 1 - Stage 7" + VerificaSituacaoFase(7, fase_));
        rotuloFases.add("8 - Level 1 - Stage 8" + VerificaSituacaoFase(8, fase_));
        rotuloFases.add("9 - Level 1 - Stage 9" + VerificaSituacaoFase(9, fase_));
        rotuloFases.add("10 - Level 1 - Stage 10" + VerificaSituacaoFase(10, fase_));
        rotuloFases.add("11 - Level 2 - Stage 1" + VerificaSituacaoFase(11, fase_));
        rotuloFases.add("12 - Level 2 - Stage 2" + VerificaSituacaoFase(12, fase_));
        rotuloFases.add("13 - Level 2 - Stage 3" + VerificaSituacaoFase(13, fase_));
        rotuloFases.add("14 - Level 2 - Stage 4" + VerificaSituacaoFase(14, fase_));
        rotuloFases.add("15 - Level 2 - Stage 5" + VerificaSituacaoFase(15, fase_));
        rotuloFases.add("16 - Level 2 - Stage 6" + VerificaSituacaoFase(16, fase_));
        rotuloFases.add("17 - Level 2 - Stage 7" + VerificaSituacaoFase(17, fase_));
        rotuloFases.add("18 - Level 2 - Stage 8" + VerificaSituacaoFase(18, fase_));
        rotuloFases.add("19 - Level 2 - Stage 9" + VerificaSituacaoFase(19, fase_));
        rotuloFases.add("20 - Level 2 - Stage 10" + VerificaSituacaoFase(20, fase_));
        rotuloFases.add("21 - Level 3 - Stage 1" + VerificaSituacaoFase(21, fase_));
        rotuloFases.add("22 - Level 3 - Stage 2" + VerificaSituacaoFase(22, fase_));
        rotuloFases.add("23 - Level 3 - Stage 3" + VerificaSituacaoFase(23, fase_));
        rotuloFases.add("24 - Level 3 - Stage 4" + VerificaSituacaoFase(24, fase_));
        rotuloFases.add("25 - Level 3 - Stage 5" + VerificaSituacaoFase(25, fase_));
        rotuloFases.add("26 - Level 3 - Stage 6" + VerificaSituacaoFase(26, fase_));
        rotuloFases.add("27 - Level 3 - Stage 7" + VerificaSituacaoFase(27, fase_));
        rotuloFases.add("28 - Level 3 - Stage 8" + VerificaSituacaoFase(28, fase_));
        rotuloFases.add("29 - Level 3 - Stage 9" + VerificaSituacaoFase(29, fase_));
        rotuloFases.add("30 - Level 3 - Stage 10" + VerificaSituacaoFase(30, fase_));
        return rotuloFases;
    }

    private String VerificaSituacaoFase(int fase, int maximoHabilitado){
        if(fase <= maximoHabilitado){
            return "";
        }
        else{
            return " - X";
        }
    }

    public String LeArquivoTxt()throws IOException {
        String retorno ="";
        try {
            retorno = file.ReadFile();
            return retorno;
        }
        catch(Exception e){
            file.WriteFile("1");
            return "1";
        }
    }

    public void EscreveArquivoTxt() throws IOException {
        String retorno = "iniescreve";
        file.WriteFile("2");
        retorno += file.ReadFile();
        ExibeMensagem(retorno,retorno);
    }

    public void ExibeMensagem(String tituloMensagem, String mensagem) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(ListaDeFases.this);
        dialogo.setTitle(tituloMensagem);
        dialogo.setMessage(mensagem);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }
}
