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
public class Nand extends Gate {
    
    private int ballWidth = 10;
    private int ballHeight = 10;
    
    public Nand(int x, int y, int w, int h, int nInputs)
    {
        super( nInputs );
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }
    
    public void Draw(Graphics g)
    {
        //Body
        g.drawLine(x, y, x, y + height);
        g.drawLine(x, y, x + width/2, y);
        g.drawLine(x, y + height, x + width/2, y + height);
        g.drawArc(x, y, width, height, 90, -180);
        
        //Inputs
        int offset = height / (inputs.length + 1);
        for (int i = 1; i <= inputs.length; i++)
        {
            g.drawLine(x, y + i * offset, x - pinLen, y + i * offset);
        }
        
        //Output
        g.drawOval(x + width, (y + height/2)- ballHeight/2, ballWidth, ballHeight);
        g.drawLine(x + width + ballWidth, y + height/2, x + width + pinLen + ballWidth, y + height/2);
        outputPin();
    }
    @Override
    public void outputPin() {
        this.outputPinX1 = x + width + ballWidth;
        this.outputPinY1 = y + height / 2;
        this.outputPinX2 = x + width + pinLen + ballWidth;
        this.outputPinY2 = y + height / 2;
    }
 
    @Override
    public boolean eval()
    {
        for( int i = 0; i < inputs.length; i++ )
        {
            output = output && inputs[i];
        }
        
        return output;
    }
}
