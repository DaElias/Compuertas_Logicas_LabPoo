/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana1;

import java.awt.Graphics;

/**
 *
 * @author NLEAL
 */
public class Or extends Gate {

    public Or(int x, int y, int w, int h, int nInputs) {
        super(nInputs);
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    @Override
    public void Draw(Graphics g) {
        super.Draw(g); //To change body of generated methods, choose Tools | Templates.
        g.drawArc(x - width / 2, y, width / 2, height, 90, -180);

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
        g.drawLine(x + width, y + height / 2, x + width + 25, y + height / 2);
        outputPin();
    }

    @Override
    public void outputPin() {
        this.outputPinX1 = x + width;
        this.outputPinY1 = y + height / 2;
        this.outputPinX2 = x + width + 25;
        this.outputPinY2 = y + height / 2;
    }

    @Override
    public boolean eval() {
        return false;
    }
}
