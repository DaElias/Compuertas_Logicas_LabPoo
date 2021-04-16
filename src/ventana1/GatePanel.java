package ventana1;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 */
public class GatePanel extends JPanel
  { 
    ArrayList<Gate> gates = null;
    final int none = 0;
    final int and = 1;
    final int or  = 2;
    final int not = 3;
    final int xOr = 4;
    final int nand = 5;
    final int X = -1;
    final int gateWidth  = 40;
    final int gateHeight = 30;
    
    public int capturedGate;
    public int nInputs;
        
    public GatePanel()
    {
        addMouseListener(
            new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                if(capturedGate != none){
                    drawGate(capturedGate, evt.getX(), evt.getY(), gateWidth, gateHeight, nInputs);
                }
                repaint();
            }    
                
            @Override
            public void mousePressed(MouseEvent evt)
            {
                if(gates != null){
                    for(Gate gate : gates)
                    {
                        gate = (Gate)gate;
                        if (gate.IsIn(evt.getX(), evt.getY()))
                        {
                            gate.mouseCaptured = true;
                            gate.prevCapX = evt.getX();
                            gate.prevCapY = evt.getY();
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent evt)
            {
                if(gates != null){
                    for(Gate gate : gates)
                    {
                        gate.mouseCaptured = false;
                    }
                }
            }
        });

        addMouseMotionListener(
            new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                if(gates != null){
                    for(Gate gate : gates)
                    {
                        if (gate.mouseCaptured)
                        {
                            int incx = evt.getX() - gate.prevCapX;
                            int incy = evt.getY() - gate.prevCapY;

                            gate.UpdateLocation(gate.GetXLocation() + incx, gate.GetYLocation() + incy);

                            gate.prevCapX = evt.getX();
                            gate.prevCapY = evt.getY();

                            repaint();
                        }
                    }
                }
            }
        });
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(gates != null){
            for (Gate gate : gates) {
                gate.Draw(g);
            }
        }
    }
    
    public void drawGate(int type, int x, int y, int width, int height, int inputs){
        if(gates == null){
            gates = new ArrayList<Gate>();
        }
        switch(type){
            case and:
                gates.add(new And(x, y, 50, 60, inputs));
                break;
            case or:
                gates.add(new Or(x, y, 50, 60, inputs));
                break;
            case not:
                gates.add(new Not(x, y, 50, 60, 1));
                break;
            case xOr:
                gates.add(new XOr(x, y, 50, 60, inputs));
                break;
            case nand:
                gates.add(new Nand(x, y, 50, 60, inputs));
                break;
        }
    }
}