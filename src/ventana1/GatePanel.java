package ventana1;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 */
public class GatePanel extends JPanel {

    ArrayList<Gate> gates = null;
    ArrayList<Conector> conectors = new ArrayList<Conector>();
    final int none = 0;
    final int and = 1;
    final int or = 2;
    final int not = 3;
    final int xOr = 4;
    final int nand = 5;
    final int nor = 6;
    final int xnor = 7;
    final int X = -1;
    final int C = -2;
    final int gateWidth = 40;
    final int gateHeight = 30;

    public int capturedGate;
    public int nInputs;

    private Point pointInitialCap;
    private Point pointFinalCap;

    static private int count = 0;
    private Gate gateselect;

    public GatePanel() {

        addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (capturedGate != none) {

                    if (capturedGate == X) {
                        count = 0;
                        if (gates != null) {
                            for (Gate gate : gates) {
                                if (gate.IsIn(evt.getX(), evt.getY())) {
                                    gates.remove(gate);
                                    break;
                                }
                            }
                        }

                    }
                    if (capturedGate == C) {
                        if (count == 0) {

                            if (gates != null) {
                                for (Gate gate : gates) {
                                    if (gate.isInOutput(evt.getX(), evt.getY())) {
                                        count++;
                                        pointInitialCap = new Point(gate.outputPinX2, gate.outputPinY2);
                                        System.out.println(pointInitialCap.toString());
                                        gateselect = gate;
                                    }
                                }
                            }
                        } else if (count != 0) {
                            count = 0;
                            pointFinalCap = new Point(evt.getX(), evt.getY());

                            gateselect.setOutputconectors(new Conector(pointInitialCap, pointFinalCap));

                            System.out.println(pointFinalCap.toString());
                            repaint();
                        }

                    } else {
                        count = 0;
                        drawGate(capturedGate, evt.getX(), evt.getY(), gateWidth, gateHeight, nInputs);
                    }
                }
                repaint();
            }

            @Override  //clik 
            public void mousePressed(MouseEvent evt) {

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
                            if(gate.getOutputConectors() != null){
                                gate.updateOutputConector();
                            }
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
                if (gate.getOutputConectors() != null) {
                    gate.getOutputConectors().draw(g);

                }
            }
        }
    }

    public void drawGate(int type, int x, int y, int width, int height, int inputs) {
        if (gates == null) {
            gates = new ArrayList<Gate>();
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
                gates.add(new Xor(x, y, 50, 60, inputs));
                break;
            case nand:
                gates.add(new Nand(x, y, 50, 60, inputs));
                break;
            case nor:
                gates.add(new Nor(x, y, 50, 60, inputs));
                break;
            case xnor:
                gates.add(new Xnor(x, y, 50, 60, inputs));
                break;
        }
    }
}
