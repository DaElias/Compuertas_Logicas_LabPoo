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
 * @author yepes
 */
public class Conector {
    Point origen;
    Point destino;
    
    Conector(Point origen, Point destino){
        this.origen = origen;
        this.destino = destino;
    }
    
    void drawConector(Graphics g){
        g.drawLine(origen.x, origen.y, destino.x, destino.y);
    }
}
