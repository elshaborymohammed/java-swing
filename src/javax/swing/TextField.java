package javax.swing;

// @author Mohammed El-Shabory

import java.awt.Dimension;


public class TextField extends JTextField{
    public TextField(){
        this("");
    }
    
    public TextField(String Text){
        super(Text);
    }
    
    public Double getDouble(){ return Double.parseDouble(super.getText()); }
    
    public Integer getInteger(){ return Integer.parseInt(super.getText()); }
    
    @Override
    public void setSize(int width,int height){
        super.setSize(width, height);
        super.setPreferredSize(new Dimension(width, height));
    }
    
    public void setWidth(int width){
        Dimension dimension = new Dimension(width, 28);
        super.setSize(dimension);
        super.setPreferredSize(dimension);
        super.setMinimumSize(dimension);
        super.setMaximumSize(dimension);
    }
}
