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
    int x, y;
    int x2, y2;
    Conector(){
//        this.x = x1;
//        this.y = y1;
//        this.x2 = x2;
//        this.y2 = y2;
    }
    
    void originPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    void destinyPoint(int x, int y){
        this.x2 = x;
        this.y2 = y;
    }
    
    void drawConector(Graphics g){
        g.drawLine(x, y, x2, y2);
    }
}
