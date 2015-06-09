package javax.swing;

import java.awt.ComponentOrientation;

// @author Mohammed El-Shabory
 public class Frame extends JFrame{
    public Frame(){
        //super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //super.setLayout(new FlowLayout());
        //super.pack();
        super.setSize(1000, 500);
        super.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //super.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        //super.setLocationByPlatform(true);
        //super.setLocation(com.smart.utility.PositionUtility.CenterPosition(this.getSize().width, this.getSize().height));
    }
    
    public void Close(){
        super.setVisible(false);
        super.dispose();
    }

    @Override
    protected void finalize() throws Throwable {
        this.Close();
        this.dispose();
        super.finalize();
    }
    
    
}
