/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana1;

import java.awt.Graphics;

/**
 *
 * @author NLEAL
 */
public class Not extends Gate{
    private int ballWidth = 10;
    private int ballHeight = 10;
    public Not(int x, int y, int w, int h, int nInputs)
    {
        super( 1 );
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }
    
    @Override
    public void Draw(Graphics g)
    {
        //Body
        g.drawLine(x, y, x, y + height);
        g.drawLine(x, y, x + width, y + height/2);
        g.drawLine(x, y + height, x + width, y + height/2);

        //Inputs
        g.drawLine(x, y + height/2, x - pinLen, y + height/2);
        
        //Output
        g.drawOval(x + width, (y + height/2) - ballWidth/2, ballWidth, ballHeight);
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
        return !output;
    }
}
