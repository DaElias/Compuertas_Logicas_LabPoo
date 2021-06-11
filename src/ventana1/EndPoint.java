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
 * @author juanpq
 */
public class EndPoint {
    
    Gate owner;
    Gate gate;
    int pin;
    Conector conector;
    
    public EndPoint( Gate owner, Gate gate, int pin )
    {
        this.owner = owner;
        this.gate = gate;
        this.pin  = pin;
    }
    
    public void setGate(Gate gate)
    {
        this.gate = gate;
    }
    
    public void setPin(int pin)
    {
        this.pin = pin;
    }
    
    public void Draw( Graphics g)
    {
        int x1;
        int y1;
        int x2;
        int y2;           

        int x  = gate.GetXLocation();
        int y  = gate.GetYLocation();
        int h  = gate.GetHeight();
        int pl = gate.GetPinLen();
        
        x1 = owner.GetXLocation() + owner.GetWidth() + owner.GetPinLen();
        y1 = owner.GetYLocation() + owner.GetHeight()/2;

        if (gate.nInputs == 1)
        {
            x2 = x - pl;
            y2 = y + h/2;           
        }
        else
        {
            int offset = h / (gate.nInputs + 1);
            x2 = gate.GetXLocation() - pl;
            y2 = y + pin * offset;           
        }
        
        conector = new Conector(new Point(x1, y1),new Point(x2, y2));
        conector.draw(g);
    }  
}
