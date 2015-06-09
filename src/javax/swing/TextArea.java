package javax.swing;

// @author Mohammed El-Shabory
public class TextArea extends JTextArea{
    public TextArea(){
        this("");
    }
    
    public TextArea(String Text){
        super(Text);
    }
    
    public Double getDouble(){ return Double.parseDouble(super.getText()); }
    
    public Integer getInteger(){ return Integer.parseInt(super.getText()); }
}
