package ventana1;

import java.awt.Graphics;

/**
 *
 * @author yepes
 */
public class Not extends Gate {
    private int ballWidth = 10;
    private int ballHeigth = 10;
    
    public Not(int x,int y, int w, int h) {
        super(1);
        this.x = x;
        this.y = y;
        width = w;
        height = h;
    }
    
    //Getters
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    //Set Gate new location
    public void setNewLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    //Método para saber si el mouse está dentro de la compuerta
    public boolean isIn(int mX, int mY){
        return mX >= this.x && mY >= this.y && mX <= this.x+width && mY <= this.y+height;
    }
    
     //Método para dibujar la compuerta
    public void draw(Graphics g){
        
        //Input
        g.drawLine(x-pinLen, y+height/2, x, y+height/2);
        
        //Triangle
        g.drawLine(x, y, x, y+height);
        g.drawLine(x, y, x+width, y+height/2);
        g.drawLine(x, y+height, x+width, y+height/2);
        g.drawOval(x+width, (y+height/2)-ballHeigth/2, ballWidth, ballHeigth);
        
        //Output
        g.drawLine(x+width+ballWidth, y+height/2, x+width+ballWidth+pinLen, y+height/2);
    }
}
