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
 * @author NLEAL
 */
public class And extends Gate {

    public And(int x, int y, int w, int h, int nInputs) {
        super(nInputs);
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.inputsValues = new ArrayList<Boolean>();
    }

    @Override
    public void Draw(Graphics g) {
        super.Draw(g);
        //Body
        g.drawLine(x, y, x, y + height);
        g.drawLine(x, y, x + width / 2, y);
        g.drawLine(x, y + height, x + width / 2, y + height);
        g.drawArc(x, y, width, height, 90, -180);

        //Inputs
        int offset = height / (nInputs + 1);
        for (int i = 1; i <= nInputs; i++) {
            g.drawLine(x, y + i * offset, x - pinLen, y + i * offset);
        }
        inputPin();

        //Output
        g.drawLine(x + width, y + height / 2, x + width + pinLen, y + height / 2);
        outputPin();

    }

    @Override
    public void outputPin() {
        this.outputPinX1 = x + width;
        this.outputPinY1 = y + height / 2;
        this.outputPinX2 = x + width + pinLen;
        this.outputPinY2 = y + height / 2;
    }

    @Override
    public String eval() {
        String msg;
        try {
            this.outputValue = this.inputsValues.get(0) & this.inputsValues.get(1);
            msg = "el valor de salida es " + outputValue;
        } catch (IndexOutOfBoundsException e) {
            msg = "no tiene valores en las entrada";
        }
        
        return msg;
    }
}
