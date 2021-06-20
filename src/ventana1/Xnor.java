/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana1;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author JuanPQ
 */
public class Xnor extends Gate {

    public Xnor(int x, int y, int w, int h, int bInputs) {
        super(bInputs);
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.inputsValues = new ArrayList<Boolean>();
    }

    @Override
    public void Draw(Graphics g) {
        super.Draw(g); //To change body of generated methods, choose Tools | Templates.
        g.drawArc(x - width / 2, y, width / 2, height, 90, -180);
        g.drawArc(x - width / 2 - 7, y, width / 2, height, 90, -180);

        g.drawLine(x - width / 4, y, x + 32, y);
        g.drawLine(x - width / 4, y + height, x + 32, y + height);

        g.drawArc(x, y, width, height, 90, -180);

        //Inputs
        int offset = height / (nInputs + 1);
        for (int i = 1; i <= nInputs; i++) {
            g.drawLine(x, y + i * offset, x - 25, y + i * offset);
        }
        inputPin();

        //Output
        g.drawOval(x + width, y + height / 2 - 2, 4, 4);
        g.drawLine(x + width + 4, y + height / 2, x + width + 25, y + height / 2);
        outputPin();
    }

    @Override
    public void outputPin() {
        this.outputPinX1 = x + width + 4;
        this.outputPinY1 = y + height / 2;
        this.outputPinX2 = x + width + pinLen + 25;
        this.outputPinY2 = y + height / 2;
    }

    @Override
    protected String eval() {
        String msg;
        try {
            if(this.inputsValues.get(0) == this.inputsValues.get(1)){
                this.outputValue = true;
            }
            else{
                this.outputValue = false;
            }
        this.inputsValues = new ArrayList<Boolean>();
            msg = "el valor de salida es " + outputValue;
        } catch (IndexOutOfBoundsException e) {
            msg = "no tiene valores en las entrada";
        }
        
        return msg;    
    }

}
