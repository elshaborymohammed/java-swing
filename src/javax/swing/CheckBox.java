package javax.swing;

// @author GabrielOmr
public class CheckBox extends JCheckBox{
    public CheckBox(){
        this("CheckBox");
    }
    
    public CheckBox(String text){
        super(text, false);
    }
}
