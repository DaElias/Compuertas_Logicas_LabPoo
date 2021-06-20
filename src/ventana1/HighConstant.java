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
 * @author Juanpq
 */
public class HighConstant extends Gate{
    public HighConstant(int x, int y, int w, int h) {
        super(1);
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.nInputs = 1;
        this.inputsPinInicial[0] = new Point(0,0);
        this.inputsPinFinal[0] = new Point(0,0);    
        this.outputValue = true;
    }
    @Override
    public void Draw(Graphics g){
        super.Draw(g);
        //Body
        g.drawRect(x, y, width, height);
        g.drawString("True", x+ width/2, y + height/2);
        
        //Output
        g.drawLine(x + width, y + height / 2, x + width + pinLen, y + height / 2);
        outputPin();
        
    }
    
    @Override
    public void outputPin() {
        this.outputPinX1 = x + width;
        this.outputPinY1 = y + height / 2;
        this.outputPinX2 = x + width + pinLen;
        this.outputPinY2 = y + height / 2;
    }
    @Override
    protected String eval() {
        return "El valor de salida es True";
    }
    
}
