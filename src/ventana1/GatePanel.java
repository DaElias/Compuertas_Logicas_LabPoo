package ventana1;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 */
public class GatePanel extends JPanel {

    ArrayList<Gate> gates = null;
    ArrayList<Conector> connect = null;
    final int none = 0;
    final int and = 1;
    final int or = 2;
    final int not = 3;
    final int xOr = 4;
    final int nand = 5;
    final int X = -1;
    final int C = -2;
    final int gateWidth = 40;
    final int gateHeight = 30;

    public int capturedGate;
    public int nInputs;

    public Puntos Pinicial;
    private Puntos Pfinal;
    private int clickCount = 1;
    public GatePanel() {
        this.Pinicial = new Puntos();
        this.Pfinal = new Puntos();

        addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (capturedGate != none) {
                    if (capturedGate == X){
                        if (gates != null){
                            for (Gate gate:gates){
                                if (gate.IsIn(evt.getX(), evt.getY())) {
                                    gates.remove(gate);
                                    break;
                                }
                            }
                        }
                    }else{
                        drawGate(capturedGate, evt.getX(), evt.getY(), gateWidth, gateHeight, nInputs);    
                    }
                }
                repaint();
            }

            @Override  //clik 
            public void mousePressed(MouseEvent evt) {
//                Pinicial.setX(evt.getX());
//                Pinicial.setY(evt.getY());
//                System.out.println(Pinicial.getX());
//                System.out.println(Pinicial.getY());
                if (gates != null) {
                    for (Gate gate : gates) {
                        gate = (Gate) gate;
                        if (gate.IsIn(evt.getX(), evt.getY())) {
                            gate.mouseCaptured = true;
                            gate.prevCapX = evt.getX();
                            gate.prevCapY = evt.getY();
                        }
                    }
                }
                if(connect != null){
                    for (Conector conector : connect){
                        for(Gate gate : gates){
                            if(clickCount == 2){
                                conector.destinyPoint(evt.getX(), evt.getY());
                                clickCount = 1;
                            }else if(clickCount == 1){
                                    if (gate.isInOutput(evt.getX(), evt.getY())) {
                                        conector.originPoint(evt.getX(), evt.getY());
                                        System.out.println(conector.x+", "+conector.y);
                                        clickCount++;
                                    }
                                }
                            break;
                        }
                    }
                }
                System.out.println(clickCount);
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                if (gates != null) {
                    for (Gate gate : gates) {
                        gate.mouseCaptured = false;
                    }
                }
            }
        });

        addMouseMotionListener(
                new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                if (gates != null) {
                    for (Gate gate : gates) {
                        if (gate.mouseCaptured) {
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

        if (gates != null) {
            for (Gate gate : gates) {
                gate.Draw(g);
            }
        }
        if(clickCount == 2){
            if (connect != null) {
                for (Conector conector : connect) {
                    conector.drawConector(g);
                }
            }
       }
    }

    public void drawGate(int type, int x, int y, int width, int height, int inputs) {
        if (gates == null) {
            gates = new ArrayList<Gate>();
        }
        if (connect == null) {
            connect = new ArrayList<Conector>();
        }
        switch (type) {
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
            case C:
                connect.add(new Conector());
                break;
        }
    }
}
