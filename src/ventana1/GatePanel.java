package ventana1;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import javax.swing.JPanel;


public class GatePanel extends JPanel
  {
    public And and01 = new And(100, 100, 60, 50, 3);
    
    public GatePanel()
    {
        addMouseListener(
            new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if (and01.IsIn(evt.getX(), evt.getY()))
                {
                    and01.mouseCaptured = true;
                    and01.prevCapX = evt.getX();
                    and01.prevCapY = evt.getY();
                }
            }

            @Override
            public void mouseReleased(MouseEvent evt)
            {
                and01.mouseCaptured = false;
            }
        });

        addMouseMotionListener(
            new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                if (and01.mouseCaptured)
                {
                    int incx = evt.getX() - and01.prevCapX;
                    int incy = evt.getY() - and01.prevCapY;

                    and01.UpdateLocation(and01.GetXLocation() + incx, and01.GetYLocation() + incy);

                    and01.prevCapX = evt.getX();
                    and01.prevCapY = evt.getY();

                    repaint();
                }
            }
        });
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        and01.Draw(g);
    }
}