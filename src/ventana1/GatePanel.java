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
    //public Gate [] gates = new Gate[2];
        ArrayList<Gate> gates = new ArrayList<Gate>();
        
    public GatePanel()
    {
        //gates.add(0, new And(100, 100, 60, 50, 2));
     //   gates[0] = new And(100, 100, 60, 50, 2);
       // gates[1]= new XOr(100, 190, 60, 50, 2);
        
        addMouseListener(
            new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt)
            {
                for(Gate gate : gates)
                {
                    if (gate.IsIn(evt.getX(), evt.getY()))
                    {
                        gate.mouseCaptured = true;
                        gate.prevCapX = evt.getX();
                        gate.prevCapY = evt.getY();
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent evt)
            {
                for(Gate gate : gates)
                {
                    gate.mouseCaptured = false;
                }
            }
        });

        addMouseMotionListener(
            new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
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
        });
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (Gate gate : gates) {
            gate.Draw(g);
        }
    }
}