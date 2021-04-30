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

    Point[] inputsPinInicial;
    Point[] inputsPinFinal;

    protected boolean[] inputs;
    protected boolean output = false;

    protected Conector Outputconectors;

    public boolean mouseCaptured = false;

    public Gate(int nInputs) {
        this.inputsPinInicial = new Point[nInputs];
        this.inputsPinFinal = new Point[nInputs];
        this.inputs = new boolean[nInputs];
        this.inputs = new boolean[nInputs];
        this.inputs = new boolean[nInputs];

    }

    public void setInputs(boolean[] values) {
        this.inputs = values;
    }

    public boolean getOutput() {
        return this.output;
    }

    public boolean IsIn(int x, int y) {
        return (this.x <= x && this.y <= y
                && this.x + this.width >= x && this.y + height >= y);
    }

    public void UpdateLocation(int x, int y) {
        this.x = x;
        this.y = y;
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

    protected boolean eval() {
        return true;
    }

    protected void Draw(Graphics g) {
    }

    public void inputPin() {
        if (inputs.length > 1) {
            int offset = height / (inputs.length + 1);
            for (int i = 1; i <= inputs.length; i++) {
                this.inputsPinInicial[i - 1] = new Point(x, y + i * offset);
                this.inputsPinFinal[i - 1] = (new Point(x - pinLen, y + i * offset));

            }
        }else if(inputs.length ==1){
            this.inputsPinInicial[0] = new Point(x, y + height/2);
            this.inputsPinFinal[0] = (new Point( x - pinLen, y + height/2));
        }
        

    }

    public boolean isInInput(int evtX, int evtY) {
        for (int i = 0; i < inputs.length; i++) {
            if ((evtX <= this.inputsPinInicial[i].getX() && evtX >= this.inputsPinFinal[i].getX()) && (evtY >= this.inputsPinInicial[i].getY() - 5 && evtY <= this.inputsPinInicial[i].getY() + 5)) {
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

    public void setOutputconectors(Conector Outputconectors) {
        this.Outputconectors = Outputconectors;
    }
    public void updateOutputConector(){
        this.Outputconectors.setPuntoFinal(new Point(this.outputPinX2,this.outputPinY2));
        
    }
    public Conector getOutputConectors(){
        return this.Outputconectors;
    }
        
}
