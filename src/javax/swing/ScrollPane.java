package javax.swing;

import java.awt.Component;

// @author Mohammed El-Shabory

public class ScrollPane extends JScrollPane{
    public ScrollPane(){
        super();
    }
    
    public ScrollPane(Component view){
        super(view);
//        super.setPreferredSize(new Dimension(400, 100));
    }
}
