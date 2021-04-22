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
public class XOr extends Gate {
    public XOr(int x, int y, int w, int h, int nInputs)
    {
        super( nInputs );
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }
    
    @Override
    public void Draw(Graphics g)
    {
        //Body
        g.drawArc(x, y, width/4, height, 90, -180);

        g.drawArc(x + width/4, y, width/4, height, 90, -180);
        g.drawLine(x + width/4, y, x + 3 * width/4 - 5, y);
        g.drawLine(x + width/4, y + height, x + 3 * width/4 - 5, y + height);
        g.drawArc(x + width/4, y, 3 * width/4, height, 90, -180);
        
        //Inputs
        int offset = height / (inputs.length + 1);
        for (int i = 1; i <= inputs.length; i++)
        {
            g.drawLine(x + width/4, y + i * offset, x - pinLen, y + i * offset);
        }
        
        //Output
        g.drawLine(x + width, y + height/2, x + width + pinLen, y + height/2);
        outputPoint();
    }
    
    @Override
    public void outputPoint(){
        this.outputPointX = x + width + pinLen;
        this.outputPointY = y + height/2;
    }
    
    @Override
    public boolean eval()
    {
        for( int i = 0; i < inputs.length; i++ )
        {
            output = output ^ inputs[i];
        }
        
        return output;
    }
}
