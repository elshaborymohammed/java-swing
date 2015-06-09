package javax.swing;

//@author Mohammed El-Shabory

import java.awt.Component;

public class Panel extends JPanel{
    public Panel(){
        super();
    }
    
    @Override
    public void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        for (Component c: this.getComponents()) { c.setEnabled(enabled); }
    }
}
