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
 * @author NLEAL
 */
public class Gate {
    int x;
    int y;
    int width;
    int height;
    int pinLen = 20;
    int prevCapX;
    int prevCapY;
    int outputPointX;
    int outputPointY;
   
    protected boolean [] inputs;
    protected boolean output = false;
    
    public boolean mouseCaptured = false;

    public Gate( int nInputs )
    {
        this.inputs = new boolean[nInputs];
    }
    
    public void setInputs( boolean [] values )
    {
        this.inputs = values;
    }
    
    public boolean getOutput( )
    {
        return this.output;
    }
    
    public boolean IsIn(int x, int y)
    {
        return (this.x <= x && this.y <= y && 
                this.x + this.width >= x && this.y + height >= y);
    }
    
    public void UpdateLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int GetXLocation()
    {
        return x;
    }

    public int GetYLocation()
    {
        return y;
    }

    public Point GetLocation()
    {
        return new Point(x, y);
    }
      
    protected boolean eval()
    {
        return true;
    }
    
    protected void Draw(Graphics g)
    {
    }
    
    protected void outputPoint(){
        
    }
    boolean isInOutput(int x, int y){
        return this.outputPointX-5 <= x && this.outputPointY-5 <= y && this.outputPointX+5 >= x && this.outputPointY+5 >= y;
    }
}
