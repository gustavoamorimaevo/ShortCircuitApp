package com.example.a520.short_circuit;

import java.util.ArrayList;

/**
 * Created by A520 on 14/06/2017.
 */
public class Quadrante {
    private int posicao;
    private int imagemRepresentativa;
    private int direcaoInicioRecursao;

    public int getPosicao(){
        return this.posicao;
    }
    public int getImagemRepresentativa(){
        return this.imagemRepresentativa;
    }
    public void setPosicao(int posicao){
        this.posicao = posicao;
    }
    public void setImagemRepresentativa(int imagemRepresentativa){
        this.imagemRepresentativa = imagemRepresentativa;
    }
    public int getDirecaoInicioRecursao() {
        return direcaoInicioRecursao;
    }
    public void setDirecaoInicioRecursao(int direcaoInicioRecursao) {
        this.direcaoInicioRecursao = direcaoInicioRecursao;
    }
}
