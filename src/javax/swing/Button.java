package javax.swing;

//@author Mohammed El-Shabory

import java.awt.Dimension;

public class Button extends JButton{
    public Button(){
        this("Button");
    }
    
    public Button(String text){
        super(text);
    }
    
    public Button(String text,int width,int height){
        this(text);
        super.setPreferredSize(new Dimension(width, height));
    }
}
