/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana1;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;


/**
 *
 * @author JuanPQ
 */
public class Conector {

    Point puntoInicial;
    Point puntoFinal;
    Point W, We;

    public Conector(Point puntoIncial, Point puntoFinal) {
        this.puntoInicial = puntoFinal;
        this.puntoFinal = puntoIncial;
        this.W = new Point((int)this.puntoInicial.getX() + (int)this.puntoFinal.getX() - (int)this.puntoInicial.getX(), (int)this.puntoInicial.getY());
        this.We = new Point(((int)this.puntoInicial.getX()) / 2 + ((int)W.getX()) / 2, (int)W.getY());
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

    public void isIn(int x, int y) {
    }

    public void draw(Graphics g) {
        //Lineas
        g.drawLine((int)puntoInicial.getX(), (int)puntoInicial.getY(), (int)We.getX(), (int)We.getY());
        g.drawLine((int)We.getX(), (int)We.getY(), (int)We.getX(), (int)puntoFinal.getY());
        g.drawLine((int)We.getX(), (int)puntoFinal.getY(), (int)puntoFinal.getX(), (int)puntoFinal.getY());

    }
}
