package javax.swing;

// @author Mohammed El-Shabory

import java.awt.Component;
import java.awt.ComponentOrientation;

public class SplitPane extends JSplitPane{
    public  SplitPane(){
        super();
    }
    public SplitPane(int orientation,Component leftComponent,Component rightComponent){
        super(orientation, leftComponent, rightComponent);
        //super.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }
}
