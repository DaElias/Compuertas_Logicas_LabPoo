/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana1;

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
    
    protected boolean eval()
    {
        return true;
    }
}
