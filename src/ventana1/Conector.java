/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana1;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author JuanPQ
 */
public class Conector {
    Point puntoInicial;
    Point puntoFinal;

    public Conector(Point puntoIncial,Point puntoFinal){
        this.puntoInicial = puntoFinal;
        this.puntoFinal = puntoIncial;
    }

    public void setPuntoFinal(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
    }

    public void setPuntoInicial(Point puntoInicial) {
        this.puntoInicial = puntoInicial;
    }

    public Point getPuntoInicial() {
        return puntoInicial;
    }

    public Point getPuntoFinal() {
        return puntoFinal;
    }
    
    public void isIn(int x, int y){
    }
    
    public void draw(Graphics g){
        g.drawLine((int)puntoInicial.getX(), (int)puntoInicial.getY(), (int)puntoFinal.getX(), (int)puntoFinal.getY());
    }
}
