/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana1;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

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
    int outputPinX1;
    int outputPinY1;
    int outputPinX2;
    int outputPinY2;

    int nInputs;
    Point[] inputsPinInicial;
    Point[] inputsPinFinal;
    ArrayList<Boolean> inputsValues;

    protected int inputPinSelected;

    protected ArrayList<EndPoint> endpoints = new ArrayList<>();

    public boolean mouseCaptured = false;

    public Gate(int nInputs,ArrayList inputsValues) {
        this.inputsPinInicial = new Point[nInputs];
        this.inputsPinFinal = new Point[nInputs];
        this.inputsValues = inputsValues;
        this.nInputs = nInputs;

    }

    public int GetWidth() {
        return width;
    }

    public int GetHeight() {
        return height;
    }

    public int GetPinLen() {
        return pinLen;
    }

    public int getInputPinSelected() {
        return inputPinSelected;
    }

    public boolean IsIn(int x, int y) {
        return (this.x <= x && this.y <= y
                && this.x + this.width >= x && this.y + height >= y);
    }

    public int GetXLocation() {
        return x;
    }

    public int GetYLocation() {
        return y;
    }

    public Point GetLocation() {
        return new Point(x, y);
    }

    public void UpdateLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void inputPin() {
        if (nInputs > 1) {
            int offset = height / (nInputs + 1);
            for (int i = 1; i <= nInputs; i++) {
                this.inputsPinInicial[i - 1] = new Point(x, y + i * offset);
                this.inputsPinFinal[i - 1] = (new Point(x - pinLen, y + i * offset));

            }
        } else if (nInputs == 1) {
            this.inputsPinInicial[0] = new Point(x, y + height / 2);
            this.inputsPinFinal[0] = (new Point(x - pinLen, y + height / 2));
        }

    }

    public boolean isInInput(int evtX, int evtY) {
        for (int i = 0; i < nInputs; i++) {
            if ((evtX <= this.inputsPinInicial[i].getX() && evtX >= this.inputsPinFinal[i].getX()) && (evtY >= this.inputsPinInicial[i].getY() - 5 && evtY <= this.inputsPinInicial[i].getY() + 5)) {
                this.inputPinSelected = i + 1;
                return true;
            }
        }
        return false;
    }

    public void outputPin() {

    }

    boolean isInOutput(int x, int y) {
        return this.outputPinX1 - 5 <= x && this.outputPinY1 - 5 <= y && this.outputPinX2 + 5 >= x && this.outputPinY2 + 5 >= y;

    }

    public void addEndPoint(EndPoint endPoint) {
        endpoints.add(endPoint);
    }

    protected boolean eval() {
        return true;
    }

    protected void Draw(Graphics g) {
        if (endpoints != null) {
            endpoints.forEach((endp) -> {
                endp.Draw(g);
            });
        }
    }

}
