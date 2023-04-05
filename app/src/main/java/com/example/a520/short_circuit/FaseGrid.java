package com.example.a520.short_circuit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class FaseGrid extends Activity {


    //rotulacao das imagens imagens
    //img0 - vazio
    //img1 - reto em pe
    //img2 - reto deitado
    //img3 - curva em baixo para direita
    //img4 - curva em baixo para esquerda
    //img5 - curva em cima para a direita
    //img6 - curva em cima para a esquerda
    //img7 - curva cima
    //img8 - curva baixo
    //img9 - curva direita
    //img10 - curva esquerda
    //img11 - m esquerda
    //img12 - m direita
    //img13 - m cima
    //img14 - m baixo

    //Intent intent = new Intent();
    //intent.setClass(MainActivity.this,Atividade2.class);
    //startActivity(intent);
    //finish();

    //Variaveis auxiliares de cada botao. Variaveis globais estaticas
    private static int fase;
    private static int botao_1_1_img = 0;
    private static int botao_1_2_img = 0;
    private static int botao_1_3_img = 0;
    private static int botao_1_4_img = 0;
    private static int botao_1_5_img = 0;
    private static int botao_1_6_img = 0;
    private static int botao_2_1_img = 0;
    private static int botao_2_2_img = 0;
    private static int botao_2_3_img = 0;
    private static int botao_2_4_img = 0;
    private static int botao_2_5_img = 0;
    private static int botao_2_6_img = 0;
    private static int botao_3_1_img = 0;
    private static int botao_3_2_img = 0;
    private static int botao_3_3_img = 0;
    private static int botao_3_4_img = 0;
    private static int botao_3_5_img = 0;
    private static int botao_3_6_img = 0;
    private static int botao_4_1_img = 0;
    private static int botao_4_2_img = 0;
    private static int botao_4_3_img = 0;
    private static int botao_4_4_img = 0;
    private static int botao_4_5_img = 0;
    private static int botao_4_6_img = 0;
    private static int botao_5_1_img = 0;
    private static int botao_5_2_img = 0;
    private static int botao_5_3_img = 0;
    private static int botao_5_4_img = 0;
    private static int botao_5_5_img = 0;
    private static int botao_5_6_img = 0;
    private static int botao_6_1_img = 0;
    private static int botao_6_2_img = 0;
    private static int botao_6_3_img = 0;
    private static int botao_6_4_img = 0;
    private static int botao_6_5_img = 0;
    private static int botao_6_6_img = 0;
    private static boolean flag_circuitoConcluido = false;
    private static int chave;
    private int contPlayerFlag = 1;
    public ManageFile file = new ManageFile(this);
    private static MediaPlayer mediaPlayer_ = null;

    //teste uso random
    //Random gerador = new Random();
    //int random =  gerador.nextInt(15);

    //public void onBackPressed() {
    //    ExibeMensagem("","back");
    //    super.onBackPressed();
    //}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fase_grid, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase_grid);
        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        fase = params.getInt("fase");
        Game(fase);
    }

    @Override
    public void onBackPressed() {
        mediaPlayer_.stop();
        Intent intent = new Intent();
        intent = new Intent(FaseGrid.this, ListaDeFases.class);
        startActivity(intent);
        finish();
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

    //Metodo que exibe a mensagem de alerta
    public void ExibeMensagemComImagem(String tituloMensagem, String mensagem, Drawable imagem) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(FaseGrid.this);
        dialogo.setTitle(tituloMensagem);
        dialogo.setMessage(mensagem);
        dialogo.setIcon(imagem);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }

    //Metodo que exibe a mensagem de alerta
    public void ExibeMensagem(String tituloMensagem, String mensagem) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(FaseGrid.this);
        dialogo.setTitle(tituloMensagem);
        dialogo.setMessage(mensagem);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }

    //Metodo que rotaciona a imagem ao ser clicada
    private Drawable RotacionaImagem(int botao, ArrayList<Drawable> listaImagens, int numeroBotao) {
        //TODO: criar a classe botao com 2 atributos
        Drawable imagemRetorno = null;
        if (botao == 0) {
            imagemRetorno = listaImagens.get(0);
            botao = 0;
        } else {
            if (botao == 1) {
                imagemRetorno = listaImagens.get(2);
                botao = 2;
            } else {
                if (botao == 2) {
                    imagemRetorno = listaImagens.get(1);
                    botao = 1;
                } else {
                    if (botao == 3) {
                        imagemRetorno = listaImagens.get(4);
                        botao = 4;
                    } else {
                        if (botao == 4) {
                            imagemRetorno = listaImagens.get(5);
                            botao = 5;
                        } else {
                            if (botao == 5) {
                                imagemRetorno = listaImagens.get(6);
                                botao = 6;
                            } else {
                                if (botao == 6) {
                                    imagemRetorno = listaImagens.get(3);
                                    botao = 3;
                                } else {
                                    if (botao == 7) {
                                        imagemRetorno = listaImagens.get(9);
                                        botao = 9;
                                    } else {
                                        if (botao == 8) {
                                            imagemRetorno = listaImagens.get(10);
                                            botao = 10;
                                        } else {
                                            if (botao == 9) {
                                                imagemRetorno = listaImagens.get(8);
                                                botao = 8;
                                            } else {
                                                if (botao == 10) {
                                                    imagemRetorno = listaImagens.get(7);
                                                    botao = 7;
                                                } else {
                                                    if (botao == 11) {
                                                        imagemRetorno = listaImagens.get(13);
                                                        botao = 13;
                                                    } else {
                                                        if (botao == 12) {
                                                            imagemRetorno = listaImagens.get(14);
                                                            botao = 14;
                                                        } else {
                                                            if (botao == 13) {
                                                                imagemRetorno = listaImagens.get(12);
                                                                botao = 12;
                                                            } else {
                                                                if (botao == 14) {
                                                                    imagemRetorno = listaImagens.get(11);
                                                                    botao = 11;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        if (numeroBotao == 11) {
            botao_1_1_img = botao;
        }
        if (numeroBotao == 12) {
            botao_1_2_img = botao;
        }
        if (numeroBotao == 13) {
            botao_1_3_img = botao;
        }
        if (numeroBotao == 14) {
            botao_1_4_img = botao;
        }
        if (numeroBotao == 15) {
            botao_1_5_img = botao;
        }
        if (numeroBotao == 16) {
            botao_1_6_img = botao;
        }
        if (numeroBotao == 21) {
            botao_2_1_img = botao;
        }
        if (numeroBotao == 22) {
            botao_2_2_img = botao;
        }
        if (numeroBotao == 23) {
            botao_2_3_img = botao;
        }
        if (numeroBotao == 24) {
            botao_2_4_img = botao;
        }
        if (numeroBotao == 25) {
            botao_2_5_img = botao;
        }
        if (numeroBotao == 26) {
            botao_2_6_img = botao;
        }
        if (numeroBotao == 31) {
            botao_3_1_img = botao;
        }
        if (numeroBotao == 32) {
            botao_3_2_img = botao;
        }
        if (numeroBotao == 33) {
            botao_3_3_img = botao;
        }
        if (numeroBotao == 34) {
            botao_3_4_img = botao;
        }
        if (numeroBotao == 35) {
            botao_3_5_img = botao;
        }
        if (numeroBotao == 36) {
            botao_3_6_img = botao;
        }
        if (numeroBotao == 41) {
            botao_4_1_img = botao;
        }
        if (numeroBotao == 42) {
            botao_4_2_img = botao;
        }
        if (numeroBotao == 43) {
            botao_4_3_img = botao;
        }
        if (numeroBotao == 44) {
            botao_4_4_img = botao;
        }
        if (numeroBotao == 45) {
            botao_4_5_img = botao;
        }
        if (numeroBotao == 46) {
            botao_4_6_img = botao;
        }
        if (numeroBotao == 51) {
            botao_5_1_img = botao;
        }
        if (numeroBotao == 52) {
            botao_5_2_img = botao;
        }
        if (numeroBotao == 53) {
            botao_5_3_img = botao;
        }
        if (numeroBotao == 54) {
            botao_5_4_img = botao;
        }
        if (numeroBotao == 55) {
            botao_5_5_img = botao;
        }
        if (numeroBotao == 56) {
            botao_5_6_img = botao;
        }
        if (numeroBotao == 61) {
            botao_6_1_img = botao;
        }
        if (numeroBotao == 62) {
            botao_6_2_img = botao;
        }
        if (numeroBotao == 63) {
            botao_6_3_img = botao;
        }
        if (numeroBotao == 64) {
            botao_6_4_img = botao;
        }
        if (numeroBotao == 65) {
            botao_6_5_img = botao;
        }
        if (numeroBotao == 66) {
            botao_6_6_img = botao;
        }
        return imagemRetorno;
    }

    //Metodo que rotaciona a imagem ao ser clicada. Usando quadrantes
    private Drawable RotacionaImagem_UsandoQuadrantes(Quadrante quadrante, ArrayList<Drawable> listaImagens) {
        //TODO: criar a classe botao com 2 atributos
        Drawable imagemRetorno = null;

        switch (quadrante.getImagemRepresentativa()) {
            case 0:
                quadrante.setImagemRepresentativa(0);
                imagemRetorno = listaImagens.get(0);
                break;
            case 1:
                quadrante.setImagemRepresentativa(2);
                imagemRetorno = listaImagens.get(2);
                break;
            case 2:
                quadrante.setImagemRepresentativa(1);
                imagemRetorno = listaImagens.get(1);
                break;
            case 3:
                quadrante.setImagemRepresentativa(4);
                imagemRetorno = listaImagens.get(4);
                break;
            case 4:
                quadrante.setImagemRepresentativa(5);
                imagemRetorno = listaImagens.get(5);
                break;
            case 5:
                quadrante.setImagemRepresentativa(6);
                imagemRetorno = listaImagens.get(6);
                break;
            case 6:
                quadrante.setImagemRepresentativa(3);
                imagemRetorno = listaImagens.get(3);
                break;
            case 7:
                quadrante.setImagemRepresentativa(9);
                imagemRetorno = listaImagens.get(9);
                break;
            case 8:
                quadrante.setImagemRepresentativa(10);
                imagemRetorno = listaImagens.get(10);
                break;
            case 9:
                quadrante.setImagemRepresentativa(8);
                imagemRetorno = listaImagens.get(8);
                break;
            case 10:
                quadrante.setImagemRepresentativa(7);
                imagemRetorno = listaImagens.get(7);
                break;
            case 11:
                quadrante.setImagemRepresentativa(13);
                imagemRetorno = listaImagens.get(13);
                break;
            case 12:
                quadrante.setImagemRepresentativa(14);
                imagemRetorno = listaImagens.get(14);
                break;
            case 13:
                quadrante.setImagemRepresentativa(12);
                imagemRetorno = listaImagens.get(12);
                break;
            case 14:
                quadrante.setImagemRepresentativa(11);
                imagemRetorno = listaImagens.get(11);
                break;
        }

        return imagemRetorno;
    }

    //Cria fase 1 usando quadrantes. metodo nao usado
    private void CriaFase1_UsandoQuadrantes() {
        //Cria uma instancia para cada quadrante, insere a imagem referente a cada posicao. Insere os quadrantes em uma lista que sera atualizada de acordo com o clique do botao
        Quadrante quadrante_1_1 = new Quadrante();
        Quadrante quadrante_1_2 = new Quadrante();
        Quadrante quadrante_1_3 = new Quadrante();
        Quadrante quadrante_1_4 = new Quadrante();
        Quadrante quadrante_1_5 = new Quadrante();
        Quadrante quadrante_1_6 = new Quadrante();
        Quadrante quadrante_2_1 = new Quadrante();
        Quadrante quadrante_2_2 = new Quadrante();
        Quadrante quadrante_2_3 = new Quadrante();
        Quadrante quadrante_2_4 = new Quadrante();
        Quadrante quadrante_2_5 = new Quadrante();
        Quadrante quadrante_2_6 = new Quadrante();
        Quadrante quadrante_3_1 = new Quadrante();
        Quadrante quadrante_3_2 = new Quadrante();
        Quadrante quadrante_3_3 = new Quadrante();
        Quadrante quadrante_3_4 = new Quadrante();
        Quadrante quadrante_3_5 = new Quadrante();
        Quadrante quadrante_3_6 = new Quadrante();
        Quadrante quadrante_4_1 = new Quadrante();
        Quadrante quadrante_4_2 = new Quadrante();
        Quadrante quadrante_4_3 = new Quadrante();
        Quadrante quadrante_4_4 = new Quadrante();
        Quadrante quadrante_4_5 = new Quadrante();
        Quadrante quadrante_4_6 = new Quadrante();
        Quadrante quadrante_5_1 = new Quadrante();
        Quadrante quadrante_5_2 = new Quadrante();
        Quadrante quadrante_5_3 = new Quadrante();
        Quadrante quadrante_5_4 = new Quadrante();
        Quadrante quadrante_5_5 = new Quadrante();
        Quadrante quadrante_5_6 = new Quadrante();
        Quadrante quadrante_6_1 = new Quadrante();
        Quadrante quadrante_6_2 = new Quadrante();
        Quadrante quadrante_6_3 = new Quadrante();
        Quadrante quadrante_6_4 = new Quadrante();
        Quadrante quadrante_6_5 = new Quadrante();
        Quadrante quadrante_6_6 = new Quadrante();
        quadrante_1_1.setPosicao(11);
        quadrante_1_1.setDirecaoInicioRecursao(-1);
        quadrante_1_1.setImagemRepresentativa(3);//fase 1
        quadrante_1_2.setPosicao(12);
        quadrante_1_2.setDirecaoInicioRecursao(-1);
        quadrante_1_2.setImagemRepresentativa(2);//fase 1
        quadrante_1_3.setPosicao(13);
        quadrante_1_3.setDirecaoInicioRecursao(-1);
        quadrante_1_3.setImagemRepresentativa(14);//fase 1
        quadrante_1_4.setPosicao(14);
        quadrante_1_4.setDirecaoInicioRecursao(-1);
        quadrante_1_4.setImagemRepresentativa(4);//fase 1
        quadrante_1_5.setPosicao(15);
        quadrante_1_5.setDirecaoInicioRecursao(-1);
        quadrante_1_5.setImagemRepresentativa(0);//fase 1
        quadrante_1_6.setPosicao(16);
        quadrante_1_6.setDirecaoInicioRecursao(-1);
        quadrante_1_6.setImagemRepresentativa(0);//fase 1
        quadrante_2_1.setPosicao(21);
        quadrante_2_1.setDirecaoInicioRecursao(-1);
        quadrante_2_1.setImagemRepresentativa(5);//fase 1
        quadrante_2_2.setPosicao(22);
        quadrante_2_2.setDirecaoInicioRecursao(-1);
        quadrante_2_2.setImagemRepresentativa(3);//fase 1
        quadrante_2_3.setPosicao(23);
        quadrante_2_3.setDirecaoInicioRecursao(-1);
        quadrante_2_3.setImagemRepresentativa(4);//fase 1
        quadrante_2_4.setPosicao(24);
        quadrante_2_4.setDirecaoInicioRecursao(-1);
        quadrante_2_4.setImagemRepresentativa(12);//fase 1
        quadrante_2_5.setPosicao(25);
        quadrante_2_5.setDirecaoInicioRecursao(-1);
        quadrante_2_5.setImagemRepresentativa(2);//fase 1
        quadrante_2_6.setPosicao(26);
        quadrante_2_6.setDirecaoInicioRecursao(-1);
        quadrante_2_6.setImagemRepresentativa(14);//fase 1
        quadrante_3_1.setPosicao(31);
        quadrante_3_1.setDirecaoInicioRecursao(-1);
        quadrante_3_1.setImagemRepresentativa(4);//fase 1
        quadrante_3_2.setPosicao(32);
        quadrante_3_2.setDirecaoInicioRecursao(-1);
        quadrante_3_2.setImagemRepresentativa(1);//fase 1
        quadrante_3_3.setPosicao(33);
        quadrante_3_3.setDirecaoInicioRecursao(-1);
        quadrante_3_3.setImagemRepresentativa(6);//fase 1
        quadrante_3_4.setPosicao(34);
        quadrante_3_4.setDirecaoInicioRecursao(-1);
        quadrante_3_4.setImagemRepresentativa(5);//fase 1
        quadrante_3_5.setPosicao(35);
        quadrante_3_5.setDirecaoInicioRecursao(-1);
        quadrante_3_5.setImagemRepresentativa(0);//fase 1
        quadrante_3_6.setPosicao(36);
        quadrante_3_6.setDirecaoInicioRecursao(-1);
        quadrante_3_6.setImagemRepresentativa(1);//fase 1
        quadrante_4_1.setPosicao(41);
        quadrante_4_1.setDirecaoInicioRecursao(-1);
        quadrante_4_1.setImagemRepresentativa(6);//fase 1
        quadrante_4_2.setPosicao(42);
        quadrante_4_2.setDirecaoInicioRecursao(-1);
        quadrante_4_2.setImagemRepresentativa(13);//fase 1
        quadrante_4_3.setPosicao(43);
        quadrante_4_3.setDirecaoInicioRecursao(-1);
        quadrante_4_3.setImagemRepresentativa(11);//fase 1
        quadrante_4_4.setPosicao(44);
        quadrante_4_4.setDirecaoInicioRecursao(-1);
        quadrante_4_4.setImagemRepresentativa(5);//fase 1
        quadrante_4_5.setPosicao(45);
        quadrante_4_5.setDirecaoInicioRecursao(-1);
        quadrante_4_5.setImagemRepresentativa(4);//fase 1
        quadrante_4_6.setPosicao(46);
        quadrante_4_6.setDirecaoInicioRecursao(-1);
        quadrante_4_6.setImagemRepresentativa(6);//fase 1
        quadrante_5_1.setPosicao(51);
        quadrante_5_1.setDirecaoInicioRecursao(-1);
        quadrante_5_1.setImagemRepresentativa(2);//fase 1
        quadrante_5_2.setPosicao(52);
        quadrante_5_2.setDirecaoInicioRecursao(-1);
        quadrante_5_2.setImagemRepresentativa(2);//fase 1
        quadrante_5_3.setPosicao(53);
        quadrante_5_3.setDirecaoInicioRecursao(-1);
        quadrante_5_3.setImagemRepresentativa(5);//fase 1
        quadrante_5_4.setPosicao(54);
        quadrante_5_4.setDirecaoInicioRecursao(-1);
        quadrante_5_4.setImagemRepresentativa(6);//fase 1
        quadrante_5_5.setPosicao(55);
        quadrante_5_5.setDirecaoInicioRecursao(-1);
        quadrante_5_5.setImagemRepresentativa(5);//fase 1
        quadrante_5_6.setPosicao(56);
        quadrante_5_6.setDirecaoInicioRecursao(-1);
        quadrante_5_6.setImagemRepresentativa(5);//fase 1
        quadrante_6_1.setPosicao(61);
        quadrante_6_1.setDirecaoInicioRecursao(-1);
        quadrante_6_1.setImagemRepresentativa(0);//fase 1
        quadrante_6_2.setPosicao(62);
        quadrante_6_2.setDirecaoInicioRecursao(-1);
        quadrante_6_2.setImagemRepresentativa(0);//fase 1
        quadrante_6_3.setPosicao(63);
        quadrante_6_3.setDirecaoInicioRecursao(-1);
        quadrante_6_3.setImagemRepresentativa(0);//fase 1
        quadrante_6_4.setPosicao(64);
        quadrante_6_4.setDirecaoInicioRecursao(-1);
        quadrante_6_5.setImagemRepresentativa(0);//fase 1
        quadrante_6_5.setPosicao(65);
        quadrante_6_5.setDirecaoInicioRecursao(-1);
        quadrante_6_5.setImagemRepresentativa(0);//fase 1
        quadrante_6_6.setPosicao(66);
        quadrante_6_6.setDirecaoInicioRecursao(-1);
        quadrante_6_6.setImagemRepresentativa(0);//fase 1
        ArrayList<Quadrante> listaDeQuadrantes = new ArrayList<Quadrante>();
        listaDeQuadrantes.add(quadrante_1_1);
        listaDeQuadrantes.add(quadrante_1_2);
        listaDeQuadrantes.add(quadrante_1_3);
        listaDeQuadrantes.add(quadrante_1_4);
        listaDeQuadrantes.add(quadrante_1_5);
        listaDeQuadrantes.add(quadrante_1_6);
        listaDeQuadrantes.add(quadrante_2_1);
        listaDeQuadrantes.add(quadrante_2_2);
        listaDeQuadrantes.add(quadrante_2_3);
        listaDeQuadrantes.add(quadrante_2_4);
        listaDeQuadrantes.add(quadrante_2_5);
        listaDeQuadrantes.add(quadrante_2_6);
        listaDeQuadrantes.add(quadrante_3_1);
        listaDeQuadrantes.add(quadrante_3_2);
        listaDeQuadrantes.add(quadrante_3_3);
        listaDeQuadrantes.add(quadrante_3_4);
        listaDeQuadrantes.add(quadrante_3_5);
        listaDeQuadrantes.add(quadrante_3_6);
        listaDeQuadrantes.add(quadrante_4_1);
        listaDeQuadrantes.add(quadrante_4_2);
        listaDeQuadrantes.add(quadrante_4_3);
        listaDeQuadrantes.add(quadrante_4_4);
        listaDeQuadrantes.add(quadrante_4_5);
        listaDeQuadrantes.add(quadrante_4_6);
        listaDeQuadrantes.add(quadrante_5_1);
        listaDeQuadrantes.add(quadrante_5_2);
        listaDeQuadrantes.add(quadrante_5_3);
        listaDeQuadrantes.add(quadrante_5_4);
        listaDeQuadrantes.add(quadrante_5_5);
        listaDeQuadrantes.add(quadrante_5_6);
        listaDeQuadrantes.add(quadrante_6_1);
        listaDeQuadrantes.add(quadrante_6_2);
        listaDeQuadrantes.add(quadrante_6_3);
        listaDeQuadrantes.add(quadrante_6_4);
        listaDeQuadrantes.add(quadrante_6_5);
        listaDeQuadrantes.add(quadrante_6_6);
    }

    //metodo que retorna a proxima imagem representativa de um quadrante ao ser clicado
    private static int RetornaProximaImagemRepresantativa(int imagemRepresentativa) {
        if (imagemRepresentativa == 0) {
            return 0;
        }
        if (imagemRepresentativa == 1) {
            return 2;
        }
        if (imagemRepresentativa == 2) {
            return 1;
        }
        if (imagemRepresentativa == 3) {
            return 4;
        }
        if (imagemRepresentativa == 4) {
            return 5;
        }
        if (imagemRepresentativa == 5) {
            return 6;
        }
        if (imagemRepresentativa == 6) {
            return 3;
        }
        if (imagemRepresentativa == 7) {
            return 9;
        }
        if (imagemRepresentativa == 8) {
            return 10;
        }
        if (imagemRepresentativa == 9) {
            return 8;
        }
        if (imagemRepresentativa == 10) {
            return 7;
        }
        if (imagemRepresentativa == 11) {
            return 13;
        }
        if (imagemRepresentativa == 12) {
            return 14;
        }
        if (imagemRepresentativa == 13) {
            return 12;
        }
        if (imagemRepresentativa == 14) {
            return 11;
        }
        return 0;
    }

    //metodo principal de criacao dos eventos
    private void Game(int fase) {
        TextView numero_fase = (TextView)findViewById(R.id.numero_fase);
        numero_fase.setText("#"+fase);
        int fase_ = 0;
        if (fase < 11) {
            fase_ = fase;
        }
        if (fase < 21 && fase > 10) {
            fase_ = fase - 10;
        }
        if (fase > 20 && fase < 31) {
            fase_ = fase - 20;
        }
        Fase(fase_, fase);
    }

    private void OrganizacaoDasPecas() {

    }

    public ArrayList<Integer> RandomImagemRepresentativa(ArrayList<Integer> listaImgensRepresentativas) {
        Random gerador = new Random();
        for (int i = 0; i < listaImgensRepresentativas.size(); i++) {
            if (listaImgensRepresentativas.get(i) == 1 || listaImgensRepresentativas.get(i) == 2) {
                int random = gerador.nextInt(2);
                if (random == 0) {
                    listaImgensRepresentativas.set(i, 1);
                }
                if (random == 1) {
                    listaImgensRepresentativas.set(i, 2);
                }
            } else {
                if (listaImgensRepresentativas.get(i) == 3 || listaImgensRepresentativas.get(i) == 4 || listaImgensRepresentativas.get(i) == 5 || listaImgensRepresentativas.get(i) == 6) {
                    int random = gerador.nextInt(4);
                    if (random == 0) {
                        listaImgensRepresentativas.set(i, 3);
                    }
                    if (random == 1) {
                        listaImgensRepresentativas.set(i, 4);
                    }
                    if (random == 2) {
                        listaImgensRepresentativas.set(i, 5);
                    }
                    if (random == 3) {
                        listaImgensRepresentativas.set(i, 6);
                    }
                } else {
                    if (listaImgensRepresentativas.get(i) == 11 || listaImgensRepresentativas.get(i) == 12 || listaImgensRepresentativas.get(i) == 13 || listaImgensRepresentativas.get(i) == 14) {
                        int random = gerador.nextInt(4);
                        if (random == 0) {
                            listaImgensRepresentativas.set(i, 11);
                        }
                        if (random == 1) {
                            listaImgensRepresentativas.set(i, 12);
                        }
                        if (random == 2) {
                            listaImgensRepresentativas.set(i, 13);
                        }
                        if (random == 3) {
                            listaImgensRepresentativas.set(i, 14);
                        }
                    }
                }
            }
        }
        return listaImgensRepresentativas;
    }

    private ArrayList<Integer> InsereFaseNaListaImgRepresentativas(int a1, int a2, int  a3, int a4, int  a5, int a6,
                                                                   int b1, int b2, int  b3, int b4, int  b5, int b6,
                                                                   int c1, int c2, int  c3, int c4, int  c5, int c6,
                                                                   int d1, int d2, int  d3, int d4, int  d5, int d6,
                                                                   int e1, int e2, int  e3, int e4, int  e5, int e6,
                                                                   int f1, int f2, int  f3, int f4, int  f5, int f6){
        ArrayList<Integer> listaDeImagensRepresentativas = new ArrayList<Integer>();
        listaDeImagensRepresentativas.add(a1);
        listaDeImagensRepresentativas.add(a2);
        listaDeImagensRepresentativas.add(a3);
        listaDeImagensRepresentativas.add(a4);
        listaDeImagensRepresentativas.add(a5);
        listaDeImagensRepresentativas.add(a6);

        listaDeImagensRepresentativas.add(b1);
        listaDeImagensRepresentativas.add(b2);
        listaDeImagensRepresentativas.add(b3);
        listaDeImagensRepresentativas.add(b4);
        listaDeImagensRepresentativas.add(b5);
        listaDeImagensRepresentativas.add(b6);

        listaDeImagensRepresentativas.add(c1);
        listaDeImagensRepresentativas.add(c2);
        listaDeImagensRepresentativas.add(c3);
        listaDeImagensRepresentativas.add(c4);
        listaDeImagensRepresentativas.add(c5);
        listaDeImagensRepresentativas.add(c6);

        listaDeImagensRepresentativas.add(d1);
        listaDeImagensRepresentativas.add(d2);
        listaDeImagensRepresentativas.add(d3);
        listaDeImagensRepresentativas.add(d4);
        listaDeImagensRepresentativas.add(d5);
        listaDeImagensRepresentativas.add(d6);

        listaDeImagensRepresentativas.add(e1);
        listaDeImagensRepresentativas.add(e2);
        listaDeImagensRepresentativas.add(e3);
        listaDeImagensRepresentativas.add(e4);
        listaDeImagensRepresentativas.add(e5);
        listaDeImagensRepresentativas.add(e6);

        listaDeImagensRepresentativas.add(f1);
        listaDeImagensRepresentativas.add(f2);
        listaDeImagensRepresentativas.add(f3);
        listaDeImagensRepresentativas.add(f4);
        listaDeImagensRepresentativas.add(f5);
        listaDeImagensRepresentativas.add(f6);

        return listaDeImagensRepresentativas;
    }

    //cria eventos e quadrantes fase
    private void Fase(final int fase_, final int fase) {
        final MediaPlayer mediaPlayer_beep = MediaPlayer.create(this, R.raw.beep);

        Drawable imagemFundo_ = getResources().getDrawable(R.drawable._1_verde_escuro);
        View imagemFundo  = (View) findViewById(R.id.layout2);

        ArrayList<Integer> listaDeImagensRepresentativas = new ArrayList<Integer>();

        if(fase == 1){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 2){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 3){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 4){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 5){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 6){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 7){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 8){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 9){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 10){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 11){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 12){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 13){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 14){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 15){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 16){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 17){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 18){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 19){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 20){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 21){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 22){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 23){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 24){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 25){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 26){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 27){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 28){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 29){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }
        if(fase == 30){
            listaDeImagensRepresentativas = InsereFaseNaListaImgRepresentativas(3,2,14,4,0,0,
                    5,3,4,12,2,14,
                    4,1,6,5,0,1,
                    6,13,11,5,4,6,
                    2,2,5,6,5, 5,
                    0, 0, 0, 0,0,0);
        }


        if(fase_ == 1){
            imagemFundo_ = getResources().getDrawable(R.drawable._1_verde_escuro);
            imagemFundo.setBackground(imagemFundo_);
            mediaPlayer_ = MediaPlayer.create(this, R.raw._1_para_dormir);
        }
        if(fase_ == 2){
            imagemFundo_ = getResources().getDrawable(R.drawable._2_azul_claro);
            imagemFundo.setBackground(imagemFundo_);
            mediaPlayer_ = MediaPlayer.create(this, R.raw._2_grave);
            //lista ...
        }
        if(fase_ == 3){
            imagemFundo_ = getResources().getDrawable(R.drawable._3_vermelho);
            imagemFundo.setBackground(imagemFundo_);
            mediaPlayer_ = MediaPlayer.create(this, R.raw._3_para_dormir_2);
        }
        if(fase_ == 4){
            imagemFundo_ = getResources().getDrawable(R.drawable._4_laranja);
            imagemFundo.setBackground(imagemFundo_);
            mediaPlayer_ = MediaPlayer.create(this, R.raw._4_piano);
        }
        if(fase_ == 5){
            imagemFundo_ = getResources().getDrawable(R.drawable._5_azul_escuro);
            imagemFundo.setBackground(imagemFundo_);
            mediaPlayer_ = MediaPlayer.create(this, R.raw._5_balada);
        }
        if(fase_ == 6)
        {
            imagemFundo_ = getResources().getDrawable(R.drawable._6_verde_claro);
            imagemFundo.setBackground(imagemFundo_);
            mediaPlayer_ = MediaPlayer.create(this, R.raw._6_grave_2);
        }
        if(fase_==7)
        {
            imagemFundo_ = getResources().getDrawable(R.drawable._7_roxo);
            imagemFundo.setBackground(imagemFundo_);
            mediaPlayer_ = MediaPlayer.create(this, R.raw._7_sino);
        }
        if(fase_ == 8){
            imagemFundo_ = getResources().getDrawable(R.drawable._8_amarelo);
            imagemFundo.setBackground(imagemFundo_);
            mediaPlayer_ = MediaPlayer.create(this, R.raw._8_leve);
        }
        if(fase_ == 9){
            imagemFundo_ = getResources().getDrawable(R.drawable._9_marrom);
            imagemFundo.setBackground(imagemFundo_);
            mediaPlayer_ = MediaPlayer.create(this, R.raw._9_goblin);
        }
        if(fase_ == 10){
            imagemFundo_ = getResources().getDrawable(R.drawable._10_cinza_escuro);
            imagemFundo.setBackground(imagemFundo_);
            mediaPlayer_ = MediaPlayer.create(this, R.raw._10_orquestra);
        }

        //randomiza lista
        //listaDeImagensRepresentativas.clear();
        listaDeImagensRepresentativas = RandomImagemRepresentativa(listaDeImagensRepresentativas);

        final ArrayList<Integer> listaDeQuadrantesAnalisados = new ArrayList<Integer>();
        final ArrayList<Drawable> listaImagens = new ArrayList<Drawable>();
        final ArrayList<Quadrante> listaDeQuadrantes = new ArrayList<Quadrante>();
        mediaPlayer_.setLooping(true);
        mediaPlayer_.start();

        //cria os botoes
        final Button botao_1_1 = (Button) findViewById(R.id._1_1);
        final Button botao_1_2 = (Button) findViewById(R.id._1_2);
        final Button botao_1_3 = (Button) findViewById(R.id._1_3);
        final Button botao_1_4 = (Button) findViewById(R.id._1_4);
        final Button botao_1_5 = (Button) findViewById(R.id._1_5);
        final Button botao_1_6 = (Button) findViewById(R.id._1_6);
        final Button botao_2_1 = (Button) findViewById(R.id._2_1);
        final Button botao_2_2 = (Button) findViewById(R.id._2_2);
        final Button botao_2_3 = (Button) findViewById(R.id._2_3);
        final Button botao_2_4 = (Button) findViewById(R.id._2_4);
        final Button botao_2_5 = (Button) findViewById(R.id._2_5);
        final Button botao_2_6 = (Button) findViewById(R.id._2_6);
        final Button botao_3_1 = (Button) findViewById(R.id._3_1);
        final Button botao_3_2 = (Button) findViewById(R.id._3_2);
        final Button botao_3_3 = (Button) findViewById(R.id._3_3);
        final Button botao_3_4 = (Button) findViewById(R.id._3_4);
        final Button botao_3_5 = (Button) findViewById(R.id._3_5);
        final Button botao_3_6 = (Button) findViewById(R.id._3_6);
        final Button botao_4_1 = (Button) findViewById(R.id._4_1);
        final Button botao_4_2 = (Button) findViewById(R.id._4_2);
        final Button botao_4_3 = (Button) findViewById(R.id._4_3);
        final Button botao_4_4 = (Button) findViewById(R.id._4_4);
        final Button botao_4_5 = (Button) findViewById(R.id._4_5);
        final Button botao_4_6 = (Button) findViewById(R.id._4_6);
        final Button botao_5_1 = (Button) findViewById(R.id._5_1);
        final Button botao_5_2 = (Button) findViewById(R.id._5_2);
        final Button botao_5_3 = (Button) findViewById(R.id._5_3);
        final Button botao_5_4 = (Button) findViewById(R.id._5_4);
        final Button botao_5_5 = (Button) findViewById(R.id._5_5);
        final Button botao_5_6 = (Button) findViewById(R.id._5_6);
        final Button botao_6_1 = (Button) findViewById(R.id._6_1);
        final Button botao_6_2 = (Button) findViewById(R.id._6_2);
        final Button botao_6_3 = (Button) findViewById(R.id._6_3);
        final Button botao_6_4 = (Button) findViewById(R.id._6_4);
        final Button botao_6_5 = (Button) findViewById(R.id._6_5);
        final Button botao_6_6 = (Button) findViewById(R.id._6_6);

        final Button botao_help_ = (Button) findViewById(R.id.botao_help_);
        final Button botao_checar = (Button) findViewById(R.id.botao_checar);
        final Button botao_som = (Button) findViewById(R.id.botao_som);
        final Button botao_voltar = (Button) findViewById(R.id.botao_voltar);

        final Drawable botao_com_som_ = getResources().getDrawable(R.mipmap.botao_com_som);
        final Drawable botao_sem_som_ = getResources().getDrawable(R.mipmap.botao_sem_som);
        final Drawable botao_help_2_ = getResources().getDrawable(R.mipmap.botao_help_2);

        //stdGAMB temp teste. Pega todas as imagens existentes. Imagens contidas inicialmente nos botoes ao abrir app.
        Drawable img0 = botao_1_1.getBackground();
        Drawable img1 = botao_1_2.getBackground();
        Drawable img2 = botao_1_3.getBackground();
        Drawable img3 = botao_1_4.getBackground();
        Drawable img4 = botao_1_5.getBackground();
        Drawable img5 = botao_1_6.getBackground();
        Drawable img6 = botao_2_1.getBackground();
        Drawable img7 = botao_2_2.getBackground();
        Drawable img8 = botao_2_3.getBackground();
        Drawable img9 = botao_2_4.getBackground();
        Drawable img10 = botao_2_5.getBackground();
        Drawable img11 = botao_2_6.getBackground();
        Drawable img12 = botao_3_1.getBackground();
        Drawable img13 = botao_3_2.getBackground();
        Drawable img14 = botao_3_3.getBackground();

        //insere todos os tipos de imagens em uma lista
        listaImagens.add(img0);
        listaImagens.add(img1);
        listaImagens.add(img2);
        listaImagens.add(img3);
        listaImagens.add(img4);
        listaImagens.add(img5);
        listaImagens.add(img6);
        listaImagens.add(img7);
        listaImagens.add(img8);
        listaImagens.add(img9);
        listaImagens.add(img10);
        listaImagens.add(img11);
        listaImagens.add(img12);
        listaImagens.add(img13);
        listaImagens.add(img14);

        //coloca imagem padrao no fundo (imagem vazia)
        botao_1_1.setBackground(img0);
        botao_1_2.setBackground(img0);
        botao_1_3.setBackground(img0);
        botao_1_4.setBackground(img0);
        botao_1_5.setBackground(img0);
        botao_1_6.setBackground(img0);
        botao_2_1.setBackground(img0);
        botao_2_2.setBackground(img0);
        botao_2_3.setBackground(img0);
        botao_2_4.setBackground(img0);
        botao_2_5.setBackground(img0);
        botao_2_6.setBackground(img0);
        botao_3_1.setBackground(img0);
        botao_3_2.setBackground(img0);
        botao_3_3.setBackground(img0);

        //cria fase 1 usando quadrantes
        final Quadrante quadrante_1_1 = new Quadrante();
        final Quadrante quadrante_1_2 = new Quadrante();
        final Quadrante quadrante_1_3 = new Quadrante();
        final Quadrante quadrante_1_4 = new Quadrante();
        final Quadrante quadrante_1_5 = new Quadrante();
        final Quadrante quadrante_1_6 = new Quadrante();
        final Quadrante quadrante_2_1 = new Quadrante();
        final Quadrante quadrante_2_2 = new Quadrante();
        final Quadrante quadrante_2_3 = new Quadrante();
        final Quadrante quadrante_2_4 = new Quadrante();
        final Quadrante quadrante_2_5 = new Quadrante();
        final Quadrante quadrante_2_6 = new Quadrante();
        final Quadrante quadrante_3_1 = new Quadrante();
        final Quadrante quadrante_3_2 = new Quadrante();
        final Quadrante quadrante_3_3 = new Quadrante();
        final Quadrante quadrante_3_4 = new Quadrante();
        final Quadrante quadrante_3_5 = new Quadrante();
        final Quadrante quadrante_3_6 = new Quadrante();
        final Quadrante quadrante_4_1 = new Quadrante();
        final Quadrante quadrante_4_2 = new Quadrante();
        final Quadrante quadrante_4_3 = new Quadrante();
        final Quadrante quadrante_4_4 = new Quadrante();
        final Quadrante quadrante_4_5 = new Quadrante();
        final Quadrante quadrante_4_6 = new Quadrante();
        final Quadrante quadrante_5_1 = new Quadrante();
        final Quadrante quadrante_5_2 = new Quadrante();
        final Quadrante quadrante_5_3 = new Quadrante();
        final Quadrante quadrante_5_4 = new Quadrante();
        final Quadrante quadrante_5_5 = new Quadrante();
        final Quadrante quadrante_5_6 = new Quadrante();
        final Quadrante quadrante_6_1 = new Quadrante();
        final Quadrante quadrante_6_2 = new Quadrante();
        final Quadrante quadrante_6_3 = new Quadrante();
        final Quadrante quadrante_6_4 = new Quadrante();
        final Quadrante quadrante_6_5 = new Quadrante();
        final Quadrante quadrante_6_6 = new Quadrante();

        //insere valores nos quadrantes
        quadrante_1_1.setPosicao(11);
        quadrante_1_1.setDirecaoInicioRecursao(-1);
        quadrante_1_1.setImagemRepresentativa(listaDeImagensRepresentativas.get(0));
        quadrante_1_2.setPosicao(12);
        quadrante_1_2.setDirecaoInicioRecursao(-1);
        quadrante_1_2.setImagemRepresentativa(listaDeImagensRepresentativas.get(1));
        quadrante_1_3.setPosicao(13);
        quadrante_1_3.setDirecaoInicioRecursao(-1);
        quadrante_1_3.setImagemRepresentativa(listaDeImagensRepresentativas.get(2));
        quadrante_1_4.setPosicao(14);
        quadrante_1_4.setDirecaoInicioRecursao(-1);
        quadrante_1_4.setImagemRepresentativa(listaDeImagensRepresentativas.get(3));
        quadrante_1_5.setPosicao(15);
        quadrante_1_5.setDirecaoInicioRecursao(-1);
        quadrante_1_5.setImagemRepresentativa(listaDeImagensRepresentativas.get(4));
        quadrante_1_6.setPosicao(16);
        quadrante_1_6.setDirecaoInicioRecursao(-1);
        quadrante_1_6.setImagemRepresentativa(listaDeImagensRepresentativas.get(5));
        quadrante_2_1.setPosicao(21);
        quadrante_2_1.setDirecaoInicioRecursao(3);
        quadrante_2_1.setImagemRepresentativa(listaDeImagensRepresentativas.get(6));
        quadrante_2_2.setPosicao(22);
        quadrante_2_2.setDirecaoInicioRecursao(-1);
        quadrante_2_2.setImagemRepresentativa(listaDeImagensRepresentativas.get(7));
        quadrante_2_3.setPosicao(23);
        quadrante_2_3.setDirecaoInicioRecursao(-1);
        quadrante_2_3.setImagemRepresentativa(listaDeImagensRepresentativas.get(8));
        quadrante_2_4.setPosicao(24);
        quadrante_2_4.setDirecaoInicioRecursao(-1);
        quadrante_2_4.setImagemRepresentativa(listaDeImagensRepresentativas.get(9));
        quadrante_2_5.setPosicao(25);
        quadrante_2_5.setDirecaoInicioRecursao(-1);
        quadrante_2_5.setImagemRepresentativa(listaDeImagensRepresentativas.get(10));
        quadrante_2_6.setPosicao(26);
        quadrante_2_6.setDirecaoInicioRecursao(-1);
        quadrante_2_6.setImagemRepresentativa(listaDeImagensRepresentativas.get(11));
        quadrante_3_1.setPosicao(31);
        quadrante_3_1.setDirecaoInicioRecursao(-1);
        quadrante_3_1.setImagemRepresentativa(listaDeImagensRepresentativas.get(12));
        quadrante_3_2.setPosicao(32);
        quadrante_3_2.setDirecaoInicioRecursao(-1);
        quadrante_3_2.setImagemRepresentativa(listaDeImagensRepresentativas.get(13));
        quadrante_3_3.setPosicao(33);
        quadrante_3_3.setDirecaoInicioRecursao(-1);
        quadrante_3_3.setImagemRepresentativa(listaDeImagensRepresentativas.get(14));
        quadrante_3_4.setPosicao(34);
        quadrante_3_4.setDirecaoInicioRecursao(-1);
        quadrante_3_4.setImagemRepresentativa(listaDeImagensRepresentativas.get(15));
        quadrante_3_5.setPosicao(35);
        quadrante_3_5.setDirecaoInicioRecursao(-1);
        quadrante_3_5.setImagemRepresentativa(listaDeImagensRepresentativas.get(16));
        quadrante_3_6.setPosicao(36);
        quadrante_3_6.setDirecaoInicioRecursao(-1);
        quadrante_3_6.setImagemRepresentativa(listaDeImagensRepresentativas.get(17));
        quadrante_4_1.setPosicao(41);
        quadrante_4_1.setDirecaoInicioRecursao(-1);
        quadrante_4_1.setImagemRepresentativa(listaDeImagensRepresentativas.get(18));
        quadrante_4_2.setPosicao(42);
        quadrante_4_2.setDirecaoInicioRecursao(-1);
        quadrante_4_2.setImagemRepresentativa(listaDeImagensRepresentativas.get(19));
        quadrante_4_3.setPosicao(43);
        quadrante_4_3.setDirecaoInicioRecursao(-1);
        quadrante_4_3.setImagemRepresentativa(listaDeImagensRepresentativas.get(20));
        quadrante_4_4.setPosicao(44);
        quadrante_4_4.setDirecaoInicioRecursao(-1);
        quadrante_4_4.setImagemRepresentativa(listaDeImagensRepresentativas.get(21));
        quadrante_4_5.setPosicao(45);
        quadrante_4_5.setDirecaoInicioRecursao(-1);
        quadrante_4_5.setImagemRepresentativa(listaDeImagensRepresentativas.get(22));
        quadrante_4_6.setPosicao(46);
        quadrante_4_6.setDirecaoInicioRecursao(-1);
        quadrante_4_6.setImagemRepresentativa(listaDeImagensRepresentativas.get(23));
        quadrante_5_1.setPosicao(51);
        quadrante_5_1.setDirecaoInicioRecursao(-1);
        quadrante_5_1.setImagemRepresentativa(listaDeImagensRepresentativas.get(24));
        quadrante_5_2.setPosicao(52);
        quadrante_5_2.setDirecaoInicioRecursao(-1);
        quadrante_5_2.setImagemRepresentativa(listaDeImagensRepresentativas.get(25));
        quadrante_5_3.setPosicao(53);
        quadrante_5_3.setDirecaoInicioRecursao(-1);
        quadrante_5_3.setImagemRepresentativa(listaDeImagensRepresentativas.get(26));
        quadrante_5_4.setPosicao(54);
        quadrante_5_4.setDirecaoInicioRecursao(-1);
        quadrante_5_4.setImagemRepresentativa(listaDeImagensRepresentativas.get(27));
        quadrante_5_5.setPosicao(55);
        quadrante_5_5.setDirecaoInicioRecursao(-1);
        quadrante_5_5.setImagemRepresentativa(listaDeImagensRepresentativas.get(28));
        quadrante_5_6.setPosicao(56);
        quadrante_5_6.setDirecaoInicioRecursao(-1);
        quadrante_5_6.setImagemRepresentativa(listaDeImagensRepresentativas.get(29));
        quadrante_6_1.setPosicao(61);
        quadrante_6_1.setDirecaoInicioRecursao(-1);
        quadrante_6_1.setImagemRepresentativa(listaDeImagensRepresentativas.get(30));
        quadrante_6_2.setPosicao(62);
        quadrante_6_2.setDirecaoInicioRecursao(-1);
        quadrante_6_2.setImagemRepresentativa(listaDeImagensRepresentativas.get(31));
        quadrante_6_3.setPosicao(63);
        quadrante_6_3.setDirecaoInicioRecursao(-1);
        quadrante_6_3.setImagemRepresentativa(listaDeImagensRepresentativas.get(32));
        quadrante_6_4.setPosicao(64);
        quadrante_6_4.setDirecaoInicioRecursao(-1);
        quadrante_6_5.setImagemRepresentativa(listaDeImagensRepresentativas.get(33));
        quadrante_6_5.setPosicao(65);
        quadrante_6_5.setDirecaoInicioRecursao(-1);
        quadrante_6_5.setImagemRepresentativa(listaDeImagensRepresentativas.get(34));
        quadrante_6_6.setPosicao(66);
        quadrante_6_6.setDirecaoInicioRecursao(-1);
        quadrante_6_6.setImagemRepresentativa(listaDeImagensRepresentativas.get(35));

        //adiciona quadrantes em uma lista
        listaDeQuadrantes.add(quadrante_1_1);
        listaDeQuadrantes.add(quadrante_1_2);
        listaDeQuadrantes.add(quadrante_1_3);
        listaDeQuadrantes.add(quadrante_1_4);
        listaDeQuadrantes.add(quadrante_1_5);
        listaDeQuadrantes.add(quadrante_1_6);
        listaDeQuadrantes.add(quadrante_2_1);
        listaDeQuadrantes.add(quadrante_2_2);
        listaDeQuadrantes.add(quadrante_2_3);
        listaDeQuadrantes.add(quadrante_2_4);
        listaDeQuadrantes.add(quadrante_2_5);
        listaDeQuadrantes.add(quadrante_2_6);
        listaDeQuadrantes.add(quadrante_3_1);
        listaDeQuadrantes.add(quadrante_3_2);
        listaDeQuadrantes.add(quadrante_3_3);
        listaDeQuadrantes.add(quadrante_3_4);
        listaDeQuadrantes.add(quadrante_3_5);
        listaDeQuadrantes.add(quadrante_3_6);
        listaDeQuadrantes.add(quadrante_4_1);
        listaDeQuadrantes.add(quadrante_4_2);
        listaDeQuadrantes.add(quadrante_4_3);
        listaDeQuadrantes.add(quadrante_4_4);
        listaDeQuadrantes.add(quadrante_4_5);
        listaDeQuadrantes.add(quadrante_4_6);
        listaDeQuadrantes.add(quadrante_5_1);
        listaDeQuadrantes.add(quadrante_5_2);
        listaDeQuadrantes.add(quadrante_5_3);
        listaDeQuadrantes.add(quadrante_5_4);
        listaDeQuadrantes.add(quadrante_5_5);
        listaDeQuadrantes.add(quadrante_5_6);
        listaDeQuadrantes.add(quadrante_6_1);
        listaDeQuadrantes.add(quadrante_6_2);
        listaDeQuadrantes.add(quadrante_6_3);
        listaDeQuadrantes.add(quadrante_6_4);
        listaDeQuadrantes.add(quadrante_6_5);
        listaDeQuadrantes.add(quadrante_6_6);

        //gera fase 1 desenhada
        botao_1_1.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(0)));
        botao_1_1_img = listaDeImagensRepresentativas.get(0);
        botao_1_2.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(1)));
        botao_1_2_img = listaDeImagensRepresentativas.get(1);
        botao_1_3.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(2)));
        botao_1_3_img = listaDeImagensRepresentativas.get(2);
        botao_1_4.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(3)));
        botao_1_4_img = listaDeImagensRepresentativas.get(3);
        botao_1_5.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(4)));
        botao_1_5_img = listaDeImagensRepresentativas.get(4);
        botao_1_6.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(5)));
        botao_1_6_img = listaDeImagensRepresentativas.get(5);
        botao_2_1.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(6)));
        botao_2_1_img = listaDeImagensRepresentativas.get(6);
        botao_2_2.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(7)));
        botao_2_2_img = listaDeImagensRepresentativas.get(7);
        botao_2_3.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(8)));
        botao_2_3_img = listaDeImagensRepresentativas.get(8);
        botao_2_4.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(9)));
        botao_2_4_img = listaDeImagensRepresentativas.get(9);
        botao_2_5.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(10)));
        botao_2_5_img = listaDeImagensRepresentativas.get(10);
        botao_2_6.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(11)));
        botao_2_6_img = listaDeImagensRepresentativas.get(11);
        botao_3_1.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(12)));
        botao_3_1_img = listaDeImagensRepresentativas.get(12);
        botao_3_2.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(13)));
        botao_3_2_img = listaDeImagensRepresentativas.get(13);
        botao_3_3.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(14)));
        botao_3_3_img = listaDeImagensRepresentativas.get(14);
        botao_3_4.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(15)));
        botao_3_4_img = listaDeImagensRepresentativas.get(15);
        botao_3_5.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(16)));
        botao_3_5_img = listaDeImagensRepresentativas.get(16);
        botao_3_6.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(17)));
        botao_3_6_img = listaDeImagensRepresentativas.get(17);
        botao_4_1.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(18)));
        botao_4_1_img = listaDeImagensRepresentativas.get(18);
        botao_4_2.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(19)));
        botao_4_2_img = listaDeImagensRepresentativas.get(19);
        botao_4_3.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(20)));
        botao_4_3_img = listaDeImagensRepresentativas.get(20);
        botao_4_4.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(21)));
        botao_4_4_img = listaDeImagensRepresentativas.get(21);
        botao_4_5.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(22)));
        botao_4_5_img = listaDeImagensRepresentativas.get(22);
        botao_4_6.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(23)));
        botao_4_6_img = listaDeImagensRepresentativas.get(23);
        botao_5_1.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(24)));
        botao_5_1_img = listaDeImagensRepresentativas.get(24);
        botao_5_2.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(25)));
        botao_5_2_img = listaDeImagensRepresentativas.get(25);
        botao_5_3.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(26)));
        botao_5_3_img = listaDeImagensRepresentativas.get(26);
        botao_5_4.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(27)));
        botao_5_4_img = listaDeImagensRepresentativas.get(27);
        botao_5_5.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(28)));
        botao_5_5_img = listaDeImagensRepresentativas.get(28);
        botao_5_6.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(29)));
        botao_5_6_img = listaDeImagensRepresentativas.get(29);
        botao_6_1.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(30)));
        botao_6_1_img = listaDeImagensRepresentativas.get(30);
        botao_6_2.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(31)));
        botao_6_2_img = listaDeImagensRepresentativas.get(31);
        botao_6_3.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(32)));
        botao_6_3_img = listaDeImagensRepresentativas.get(32);
        botao_6_4.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(33)));
        botao_6_4_img = listaDeImagensRepresentativas.get(33);
        botao_6_5.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(34)));
        botao_6_5_img = listaDeImagensRepresentativas.get(34);
        botao_6_6.setBackground(listaImagens.get(listaDeImagensRepresentativas.get(35)));
        botao_6_6_img = listaDeImagensRepresentativas.get(35);
        /*botao_1_1.setBackground(listaImagens.get(3));
        botao_1_1_img = 3;
        botao_1_2.setBackground(listaImagens.get(2));
        botao_1_2_img = 2;
        botao_1_3.setBackground(listaImagens.get(14));
        botao_1_3_img = 14;
        botao_1_4.setBackground(listaImagens.get(4));
        botao_1_4_img = 4;
        botao_1_5.setBackground(listaImagens.get(0));
        botao_1_5_img = 0;
        botao_1_6.setBackground(listaImagens.get(0));
        botao_1_6_img = 0;
        botao_2_1.setBackground(listaImagens.get(5));
        botao_2_1_img = 5;
        botao_2_2.setBackground(listaImagens.get(3));
        botao_2_2_img = 3;
        botao_2_3.setBackground(listaImagens.get(4));
        botao_2_3_img = 4;
        botao_2_4.setBackground(listaImagens.get(12));
        botao_2_4_img = 12;
        botao_2_5.setBackground(listaImagens.get(2));
        botao_2_5_img = 2;
        botao_2_6.setBackground(listaImagens.get(14));
        botao_2_6_img = 14;
        botao_3_1.setBackground(listaImagens.get(4));
        botao_3_1_img = 4;
        botao_3_2.setBackground(listaImagens.get(1));
        botao_3_2_img = 1;
        botao_3_3.setBackground(listaImagens.get(6));
        botao_3_3_img = 6;
        botao_3_4.setBackground(listaImagens.get(5));
        botao_3_4_img = 5;
        botao_3_5.setBackground(listaImagens.get(0));
        botao_3_5_img = 0;
        botao_3_6.setBackground(listaImagens.get(1));
        botao_3_6_img = 1;
        botao_4_1.setBackground(listaImagens.get(6));
        botao_4_1_img = 6;
        botao_4_2.setBackground(listaImagens.get(13));
        botao_4_2_img = 13;
        botao_4_3.setBackground(listaImagens.get(11));
        botao_4_3_img = 11;
        botao_4_4.setBackground(listaImagens.get(5));
        botao_4_4_img = 5;
        botao_4_5.setBackground(listaImagens.get(4));
        botao_4_5_img = 4;
        botao_4_6.setBackground(listaImagens.get(6));
        botao_4_6_img = 6;
        botao_5_1.setBackground(listaImagens.get(2));
        botao_5_1_img = 2;
        botao_5_2.setBackground(listaImagens.get(2));
        botao_5_2_img = 2;
        botao_5_3.setBackground(listaImagens.get(5));
        botao_5_3_img = 5;
        botao_5_4.setBackground(listaImagens.get(6));
        botao_5_4_img = 6;
        botao_5_5.setBackground(listaImagens.get(5));
        botao_5_5_img = 4;
        botao_5_6.setBackground(listaImagens.get(5));
        botao_5_6_img = 5;
        botao_6_1.setBackground(listaImagens.get(0));
        botao_6_1_img = 0;
        botao_6_2.setBackground(listaImagens.get(0));
        botao_6_2_img = 0;
        botao_6_3.setBackground(listaImagens.get(0));
        botao_6_3_img = 0;
        botao_6_4.setBackground(listaImagens.get(0));
        botao_6_4_img = 0;
        botao_6_5.setBackground(listaImagens.get(0));
        botao_6_5_img = 0;
        botao_6_6.setBackground(listaImagens.get(0));
        botao_6_6_img = 0;
        */
        //CriaFase1_UsandoQuadrantes();

        //eventos de clique no botao
        botao_1_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_1_1.setBackground(RotacionaImagem(botao_1_1_img, listaImagens, 11));
                //parei aqui...alterar para rotaciona usando quadrantes
                //botao_1_1.setBackground(RotacionaImagem_UsandoQuadrantes(quadrante_1_1, listaImagens));
                quadrante_1_1.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_1_1.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(11)).setImagemRepresentativa(quadrante_1_1.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_1_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_1_2.setBackground(RotacionaImagem(botao_1_2_img, listaImagens, 12));
                quadrante_1_2.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_1_2.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(12)).setImagemRepresentativa(quadrante_1_2.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_1_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_1_3.setBackground(RotacionaImagem(botao_1_3_img, listaImagens, 13));
                quadrante_1_3.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_1_3.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(13)).setImagemRepresentativa(quadrante_1_3.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_1_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_1_4.setBackground(RotacionaImagem(botao_1_4_img, listaImagens, 14));
                quadrante_1_4.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_1_4.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(14)).setImagemRepresentativa(quadrante_1_4.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_1_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_1_5.setBackground(RotacionaImagem(botao_1_5_img, listaImagens, 15));
                quadrante_1_5.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_1_5.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(15)).setImagemRepresentativa(quadrante_1_5.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_1_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_1_6.setBackground(RotacionaImagem(botao_1_6_img, listaImagens, 16));
                quadrante_1_6.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_1_6.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(16)).setImagemRepresentativa(quadrante_1_6.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_2_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_2_1.setBackground(RotacionaImagem(botao_2_1_img, listaImagens, 21));
                quadrante_2_1.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_2_1.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(21)).setImagemRepresentativa(quadrante_2_1.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_2_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_2_2.setBackground(RotacionaImagem(botao_2_2_img, listaImagens, 22));
                quadrante_2_2.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_2_2.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(22)).setImagemRepresentativa(quadrante_2_2.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_2_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_2_3.setBackground(RotacionaImagem(botao_2_3_img, listaImagens, 23));
                quadrante_2_3.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_2_3.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(23)).setImagemRepresentativa(quadrante_2_3.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_2_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_2_4.setBackground(RotacionaImagem(botao_2_4_img, listaImagens, 24));
                quadrante_2_4.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_2_4.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(24)).setImagemRepresentativa(quadrante_2_4.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_2_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_2_5.setBackground(RotacionaImagem(botao_2_5_img, listaImagens, 25));
                quadrante_2_5.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_2_5.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(25)).setImagemRepresentativa(quadrante_2_5.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_2_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_2_6.setBackground(RotacionaImagem(botao_2_6_img, listaImagens, 26));
                quadrante_2_6.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_2_6.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(26)).setImagemRepresentativa(quadrante_2_6.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_3_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_3_1.setBackground(RotacionaImagem(botao_3_1_img, listaImagens, 31));
                quadrante_3_1.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_3_1.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(31)).setImagemRepresentativa(quadrante_3_1.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_3_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_3_2.setBackground(RotacionaImagem(botao_3_2_img, listaImagens, 32));
                quadrante_3_2.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_3_2.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(32)).setImagemRepresentativa(quadrante_3_2.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_3_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_3_3.setBackground(RotacionaImagem(botao_3_3_img, listaImagens, 33));
                quadrante_3_3.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_3_3.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(33)).setImagemRepresentativa(quadrante_3_3.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_3_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_3_4.setBackground(RotacionaImagem(botao_3_4_img, listaImagens, 34));
                quadrante_3_4.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_3_4.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(34)).setImagemRepresentativa(quadrante_3_4.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_3_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_3_5.setBackground(RotacionaImagem(botao_3_5_img, listaImagens, 35));
                quadrante_3_5.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_3_5.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(35)).setImagemRepresentativa(quadrante_3_5.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_3_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_3_6.setBackground(RotacionaImagem(botao_3_6_img, listaImagens, 36));
                quadrante_3_6.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_3_6.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(36)).setImagemRepresentativa(quadrante_3_6.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_4_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_4_1.setBackground(RotacionaImagem(botao_4_1_img, listaImagens, 41));
                quadrante_4_1.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_4_1.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(41)).setImagemRepresentativa(quadrante_4_1.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_4_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_4_2.setBackground(RotacionaImagem(botao_4_2_img, listaImagens, 42));
                quadrante_4_2.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_4_2.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(42)).setImagemRepresentativa(quadrante_4_2.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_4_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_4_3.setBackground(RotacionaImagem(botao_4_3_img, listaImagens, 43));
                quadrante_4_3.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_4_3.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(43)).setImagemRepresentativa(quadrante_4_3.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_4_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_4_4.setBackground(RotacionaImagem(botao_4_4_img, listaImagens, 44));
                quadrante_4_4.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_4_4.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(44)).setImagemRepresentativa(quadrante_4_4.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_4_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_4_5.setBackground(RotacionaImagem(botao_4_5_img, listaImagens, 45));
                quadrante_4_5.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_4_5.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(45)).setImagemRepresentativa(quadrante_4_5.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_4_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_4_6.setBackground(RotacionaImagem(botao_4_6_img, listaImagens, 46));
                quadrante_4_6.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_4_6.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(46)).setImagemRepresentativa(quadrante_4_6.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_5_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_5_1.setBackground(RotacionaImagem(botao_5_1_img, listaImagens, 51));
                quadrante_5_1.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_5_1.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(51)).setImagemRepresentativa(quadrante_5_1.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_5_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_5_2.setBackground(RotacionaImagem(botao_5_2_img, listaImagens, 52));
                quadrante_5_2.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_5_2.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(52)).setImagemRepresentativa(quadrante_5_2.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_5_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_5_3.setBackground(RotacionaImagem(botao_5_3_img, listaImagens, 53));
                quadrante_5_3.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_5_3.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(53)).setImagemRepresentativa(quadrante_5_3.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_5_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_5_4.setBackground(RotacionaImagem(botao_5_4_img, listaImagens, 54));
                quadrante_5_4.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_5_4.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(54)).setImagemRepresentativa(quadrante_5_4.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_5_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_5_5.setBackground(RotacionaImagem(botao_5_5_img, listaImagens, 55));
                quadrante_5_5.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_5_5.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(55)).setImagemRepresentativa(quadrante_5_5.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_5_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_5_6.setBackground(RotacionaImagem(botao_5_6_img, listaImagens, 56));
                quadrante_5_6.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_5_6.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(56)).setImagemRepresentativa(quadrante_5_6.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_6_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_6_1.setBackground(RotacionaImagem(botao_6_1_img, listaImagens, 61));
                quadrante_6_1.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_6_1.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(61)).setImagemRepresentativa(quadrante_6_1.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_6_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_6_2.setBackground(RotacionaImagem(botao_6_2_img, listaImagens, 62));
                quadrante_6_2.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_6_2.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(62)).setImagemRepresentativa(quadrante_6_2.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_6_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_6_3.setBackground(RotacionaImagem(botao_6_3_img, listaImagens, 63));
                quadrante_6_3.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_6_3.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(63)).setImagemRepresentativa(quadrante_6_3.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_6_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_6_4.setBackground(RotacionaImagem(botao_6_4_img, listaImagens, 64));
                quadrante_6_4.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_6_4.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(64)).setImagemRepresentativa(quadrante_6_4.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_6_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_6_5.setBackground(RotacionaImagem(botao_6_5_img, listaImagens, 65));
                quadrante_6_5.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_6_5.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(65)).setImagemRepresentativa(quadrante_6_5.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_6_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                botao_6_6.setBackground(RotacionaImagem(botao_6_6_img, listaImagens, 66));
                quadrante_6_6.setImagemRepresentativa(RetornaProximaImagemRepresantativa(quadrante_6_6.getImagemRepresentativa()));
                listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(66)).setImagemRepresentativa(quadrante_6_6.getImagemRepresentativa());
                if(botao_1_1_img != 0)
                    mediaPlayer_beep.start();
            }
        });
        botao_help_.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                MediaPlayer mediaPlayer_abertura = MediaPlayer.create(FaseGrid.this, R.raw.clique_opcao);
                mediaPlayer_abertura.start();
                Drawable img_help = botao_help_2_;
                //ExibeMensagem("Ajuda", "Complete os circuitos de forma que todos da esquerda de conectem aos da direita. \n #DefSystem. \n Todos os direitos reservados.", img_help);
                ExibeMensagemComImagem("Help", "Complete the circuits so that everyone on the left connects to the ones on the right.", img_help);
            }
        });
        botao_checar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                MediaPlayer mediaPlayer_abertura = MediaPlayer.create(FaseGrid.this, R.raw.clique_opcao);
                mediaPlayer_abertura.start();

                VerificaCircuito(quadrante_2_1, 3, listaDeQuadrantes, listaDeQuadrantesAnalisados,true);
                if(flag_circuitoConcluido){
                    MediaPlayer mediaPlayer_ok = MediaPlayer.create(FaseGrid.this, R.raw.ok);
                    mediaPlayer_abertura.start();
                    Drawable img_ok = getResources().getDrawable(R.mipmap.img_ok);
                    ExibeMensagemComImagem(" ", "Very well!",img_ok);
                    //volta pra lita de fases com .txt atualizado com fases disponíveis
                    try {
                        int resposta = 0;
                        try {
                            resposta = Integer.parseInt(LeArquivoTxtRetornandoFase().replace("\n",""));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if(fase == resposta)
                            EscreveArquivoTxt((resposta+1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    flag_circuitoConcluido = false;
                }
                else{
                    MediaPlayer mediaPlayer_erro = MediaPlayer.create(FaseGrid.this, R.raw.erro);
                    mediaPlayer_abertura.start();
                    Drawable img_x = getResources().getDrawable(R.mipmap.img_x);
                    ExibeMensagemComImagem(" ", "Sorry, circuit failure!", img_x);
                }
                listaDeQuadrantesAnalisados.clear();
            }
        });
        botao_som.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                MediaPlayer mediaPlayer_abertura = MediaPlayer.create(FaseGrid.this, R.raw.clique_opcao);
                mediaPlayer_abertura.start();
                contPlayerFlag++;
                if (contPlayerFlag % 2 == 0) {
                    mediaPlayer_.pause();// stop();// pause();//mediaPlayer.setVolume(0, 0);
                    botao_som.setBackground(botao_sem_som_);
                } else {
                    botao_som.setBackground(botao_com_som_);
                    mediaPlayer_.start();//mediaPlayer.setVolume(1, 1);
                }
            }
        });
        botao_voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                MediaPlayer mediaPlayer_abertura = MediaPlayer.create(FaseGrid.this, R.raw.clique_opcao);
                mediaPlayer_abertura.start();
                mediaPlayer_.stop();
                Intent intent = new Intent();
                intent = new Intent(FaseGrid.this, ListaDeFases.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void LeArquivoTxt()throws IOException {
        try {
            String retorno = file.ReadFile();
           }
        catch(Exception e){
            file.WriteFile("1");
        }
    }

    public String LeArquivoTxtRetornandoFase()throws IOException {
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

    public void EscreveArquivoTxt(int fase) throws IOException {
        file.WriteFile(String.valueOf(fase));
    }

    //TODO: Fazer a logica da recursao. Atualizar lista OK
    //TODO: verificar se lista atualizada esta correta OK
    //TODO: verificar casos onde pode ocorrer loop OK
    //TODO: tratar quadrante final chave diferente de 27
    //TODO: fazer para mais circuitos em uma so fase
    //TODO: testar verificacao

    //funcao chamada recursivamente que verifica se circuito esta fechado
    private static void VerificaCircuito(Quadrante quadrante, int direcao, ArrayList<Quadrante> listaDeQuadrantes, ArrayList<Integer> listaDeQuadrantesAnalisados, boolean primeiroQuadranteAnalisado) {
        if(primeiroQuadranteAnalisado == true && (quadrante.getImagemRepresentativa()!= 2 &&
                    quadrante.getImagemRepresentativa()!= 4 &&
                    quadrante.getImagemRepresentativa()!= 5 &&
                    quadrante.getImagemRepresentativa()!= 11 &&
                    quadrante.getImagemRepresentativa()!= 13 &&
                    quadrante.getImagemRepresentativa()!=  14 )){
            //quadrante inicial já não é circuito
        }
        else{
            if (quadrante != null) {
                if (quadrante.getPosicao() == 27){//chave) {
                    flag_circuitoConcluido = true;
                } else {
                    //verifica se quadrante ja foi analisado. Trata loop
                    boolean loop = VerificaQuadrante(quadrante, listaDeQuadrantesAnalisados);
                    if(!loop){
                        if(!flag_circuitoConcluido) {
                            VerificaCircuito(RetornaQuadranteValido(quadrante, RetornaDirecao1(quadrante), listaDeQuadrantes), RetornaDirecao1(quadrante), listaDeQuadrantes, listaDeQuadrantesAnalisados, false);
                        }
                        if(!flag_circuitoConcluido) {
                            VerificaCircuito(RetornaQuadranteValido(quadrante, RetornaDirecao2(quadrante), listaDeQuadrantes), RetornaDirecao2(quadrante), listaDeQuadrantes, listaDeQuadrantesAnalisados, false);
                        }
                        if(!flag_circuitoConcluido) {
                            VerificaCircuito(RetornaQuadranteValido(quadrante, RetornaDirecao3(quadrante), listaDeQuadrantes), RetornaDirecao3(quadrante), listaDeQuadrantes, listaDeQuadrantesAnalisados, false);
                        }
                    }
                    loop = false;
                }
            }
        }
    }

    //verifica se quadrante ja foi analisado. Trata loop na aplicacao
    private static boolean VerificaQuadrante(Quadrante quadrante, ArrayList<Integer> listaDeQuadrantesAnalisados){
        boolean loop = false;
        for(int i = 0; i < listaDeQuadrantesAnalisados.size(); i++){
            if(listaDeQuadrantesAnalisados.get(i) == quadrante.getPosicao()){
                loop = true;
            }
        }
        if(!loop){
            listaDeQuadrantesAnalisados.add(quadrante.getPosicao());
        }
        return loop;
    }

    //retorna primeira direcao a ser buscada recursivamente
    private static int RetornaDirecao1(Quadrante quadrante){
        if(quadrante.getDirecaoInicioRecursao() == 0){
            return 1;
        }
        else{
            if(quadrante.getDirecaoInicioRecursao() == 1){
                return 2;
            }
            else{
                if(quadrante.getDirecaoInicioRecursao() == 2){
                    return 3;
                }
                else{
                    if(quadrante.getDirecaoInicioRecursao() == 3){
                        return 0;
                    }
                    else{
                        return 0;
                    }
                }
            }
        }
    }

    //retorna segunda direcao a ser buscada recursivamente
    private static int RetornaDirecao2(Quadrante quadrante){
        if(quadrante.getDirecaoInicioRecursao() == 0){
            return 2;
        }
        else{
            if(quadrante.getDirecaoInicioRecursao() == 1){
                return 3;
            }
            else{
                if(quadrante.getDirecaoInicioRecursao() == 2){
                    return 0;
                }
                else{
                    if(quadrante.getDirecaoInicioRecursao() == 3){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        }
    }

    //retorna segunda direcao a ser buscada recursivamente
    private static int RetornaDirecao3(Quadrante quadrante){
        if(quadrante.getDirecaoInicioRecursao() == 0){
            return 3;
        }
        else{
            if(quadrante.getDirecaoInicioRecursao() == 1){
                return 0;
            }
            else{
                if(quadrante.getDirecaoInicioRecursao() == 2){
                    return 1;
                }
                else{
                    if(quadrante.getDirecaoInicioRecursao() == 3){
                        return 2;
                    }
                    else{
                        return 0;
                    }
                }
            }
        }
    }

    //retorna o proximo quadrante na recursao caso ele seja valido
    private static Quadrante RetornaQuadranteValido(Quadrante quadrante, int direcao, ArrayList<Quadrante> listaDeQuadrantes){
        if(direcao == 0){
            if(quadrante.getPosicao() == 11 ||
                    quadrante.getPosicao() == 12 ||
                    quadrante.getPosicao() == 13 ||
                    quadrante.getPosicao() == 14 ||
                    quadrante.getPosicao() == 15 ||
                    quadrante.getPosicao() == 16){
                return null;
            }
            else{
                if(quadrante.getImagemRepresentativa() == 1 ||
                        quadrante.getImagemRepresentativa() == 6 ||
                        quadrante.getImagemRepresentativa() == 5 ||
                        quadrante.getImagemRepresentativa() == 13 ||
                        quadrante.getImagemRepresentativa() == 11 ||
                        quadrante.getImagemRepresentativa() == 12){
                    Quadrante proximoQuadranteRecursao = listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(quadrante.getPosicao() - 10));
                    proximoQuadranteRecursao.setDirecaoInicioRecursao(2);
                    //
                    if(proximoQuadranteRecursao.getImagemRepresentativa() == 1 ||
                            proximoQuadranteRecursao.getImagemRepresentativa() == 3 ||
                            proximoQuadranteRecursao.getImagemRepresentativa() == 4 ||
                            proximoQuadranteRecursao.getImagemRepresentativa() == 11 ||
                            proximoQuadranteRecursao.getImagemRepresentativa() == 14 ||
                            proximoQuadranteRecursao.getImagemRepresentativa() == 12){
                        return proximoQuadranteRecursao;
                    }
                    else{
                        return null;
                    }
                }
                else{
                    return null;
                }
            }
        }
        else{
            if(direcao == 1){
                if(quadrante.getPosicao() != 16 &&
                        quadrante.getPosicao() != 26 &&
                        quadrante.getPosicao() != 36 &&
                        quadrante.getPosicao() != 46 &&
                        quadrante.getPosicao() != 56 &&
                        quadrante.getPosicao() != 66){
                    if(quadrante.getImagemRepresentativa() == 2 ||
                            quadrante.getImagemRepresentativa() == 3 ||
                            quadrante.getImagemRepresentativa() == 6 ||
                            quadrante.getImagemRepresentativa() == 13 ||
                            quadrante.getImagemRepresentativa() == 14 ||
                            quadrante.getImagemRepresentativa() == 12) {
                        Quadrante proximoQuadranteRecursao = listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(quadrante.getPosicao() + 1));
                        proximoQuadranteRecursao.setDirecaoInicioRecursao(3);
                        if(proximoQuadranteRecursao.getImagemRepresentativa() == 2 ||
                                proximoQuadranteRecursao.getImagemRepresentativa() == 4 ||
                                proximoQuadranteRecursao.getImagemRepresentativa() == 5 ||
                                proximoQuadranteRecursao.getImagemRepresentativa() == 11 ||
                                proximoQuadranteRecursao.getImagemRepresentativa() == 13 ||
                                proximoQuadranteRecursao.getImagemRepresentativa() == 14){
                            return proximoQuadranteRecursao;
                        }
                        else{
                            return null;
                        }
                    }
                    else{
                        return null;
                    }
                }
                else{
                    if(quadrante.getImagemRepresentativa() == 2 ||
                            quadrante.getImagemRepresentativa() == 3 ||
                            quadrante.getImagemRepresentativa() == 6 ||
                            quadrante.getImagemRepresentativa() == 13 ||
                            quadrante.getImagemRepresentativa() == 14 ||
                            quadrante.getImagemRepresentativa() == 12) {
                        Quadrante proximoQuadranteRecursao = new Quadrante();
                        proximoQuadranteRecursao.setImagemRepresentativa(-1);
                        proximoQuadranteRecursao.setPosicao(27);
                        proximoQuadranteRecursao.setDirecaoInicioRecursao(-1);
                        return proximoQuadranteRecursao;
                    }
                    else{
                        return null;
                    }
                }
            }
            else{
                if(direcao == 2){
                    if(quadrante.getPosicao() == 61 ||
                            quadrante.getPosicao() == 62 ||
                            quadrante.getPosicao() == 63 ||
                            quadrante.getPosicao() == 64 ||
                            quadrante.getPosicao() == 65 ||
                            quadrante.getPosicao() == 66){
                        return null;
                    }
                    else{
                        if(quadrante.getImagemRepresentativa() == 1 ||
                                quadrante.getImagemRepresentativa() == 3 ||
                                quadrante.getImagemRepresentativa() == 4 ||
                                quadrante.getImagemRepresentativa() == 11 ||
                                quadrante.getImagemRepresentativa() == 12 ||
                                quadrante.getImagemRepresentativa() == 14){
                            Quadrante proximoQuadranteRecursao = listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(quadrante.getPosicao() + 10));
                            proximoQuadranteRecursao.setDirecaoInicioRecursao(0);
                            if(proximoQuadranteRecursao.getImagemRepresentativa() == 1 ||
                                    proximoQuadranteRecursao.getImagemRepresentativa() == 6 ||
                                    proximoQuadranteRecursao.getImagemRepresentativa() == 5 ||
                                    proximoQuadranteRecursao.getImagemRepresentativa() == 11 ||
                                    proximoQuadranteRecursao.getImagemRepresentativa() == 12 ||
                                    proximoQuadranteRecursao.getImagemRepresentativa() == 13) {
                                return proximoQuadranteRecursao;
                            }
                            else{
                                return null;
                            }
                        }
                        else{
                            return null;
                        }
                    }
                }
                else{
                    if(direcao == 3){
                        if(quadrante.getPosicao() == 11 ||
                                quadrante.getPosicao() == 21 ||
                                quadrante.getPosicao() == 31 ||
                                quadrante.getPosicao() == 41 ||
                                quadrante.getPosicao() == 51 ||
                                quadrante.getPosicao() == 61){
                            return null;
                        }
                        else {
                            if (quadrante.getImagemRepresentativa() == 2 ||
                                    quadrante.getImagemRepresentativa() == 4 ||
                                    quadrante.getImagemRepresentativa() == 5 ||
                                    quadrante.getImagemRepresentativa() == 11 ||
                                    quadrante.getImagemRepresentativa() == 13 ||
                                    quadrante.getImagemRepresentativa() == 14) {
                                Quadrante proximoQuadranteRecursao = listaDeQuadrantes.get(BuscaReferenciaQuadranteLista(quadrante.getPosicao() - 1));
                                proximoQuadranteRecursao.setDirecaoInicioRecursao(1);
                                if(proximoQuadranteRecursao.getImagemRepresentativa() == 2 ||
                                        proximoQuadranteRecursao.getImagemRepresentativa() == 3 ||
                                        proximoQuadranteRecursao.getImagemRepresentativa() == 6 ||
                                        proximoQuadranteRecursao.getImagemRepresentativa() == 13 ||
                                        proximoQuadranteRecursao.getImagemRepresentativa() == 12 ||
                                        proximoQuadranteRecursao.getImagemRepresentativa() == 14) {
                                    return proximoQuadranteRecursao;
                                }
                                else{
                                    return null;
                                }
                            }
                            else{
                                return null;
                            }
                        }
                    }
                    else{
                        return null;
                    }
                }
            }
        }
    }

    //busca referencia de posicao em uma lista. Exemplo posicao 23 (linha 2 coluna 1) estara na posicao 6 da lista (elemento 7 da lista) -> 6 da primeira linha mais o primeiro da segunda linha
    private static int BuscaReferenciaQuadranteLista(int posicaoQuadrante){
        int posicaoQuadranteLista = 0;
        if(posicaoQuadrante >= 11 && posicaoQuadrante <= 16){
            posicaoQuadranteLista = posicaoQuadrante - 11;
        }
        if(posicaoQuadrante >= 21 && posicaoQuadrante <= 26){
            posicaoQuadranteLista = posicaoQuadrante -11 - 4;
        }
        if(posicaoQuadrante >= 31 && posicaoQuadrante <= 36){
            posicaoQuadranteLista = posicaoQuadrante - 11 - 8;
        }
        if(posicaoQuadrante >= 41 && posicaoQuadrante <= 46){
            posicaoQuadranteLista = posicaoQuadrante - 11 - 12;
        }
        if(posicaoQuadrante >= 51 && posicaoQuadrante <= 56){
            posicaoQuadranteLista = posicaoQuadrante - 11 - 16;
        }
        if(posicaoQuadrante >= 61 && posicaoQuadrante <= 66){
            posicaoQuadranteLista = posicaoQuadrante - 11 - 20;
        }
        return posicaoQuadranteLista;
    }
}
