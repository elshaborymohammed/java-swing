package javax.swing;
// @author Mohammed El-Shabory

import java.awt.Dimension;
import java.awt.FlowLayout;

public class TextAreaComponent extends JComponent{
    private TextArea text;
    private Label label;
    public TextAreaComponent(){
        this("","TextAreaComponent");
    }
    public TextAreaComponent(String text_Text,String label_Text){
        text=new TextArea(text_Text);
        label=new Label(label_Text);
        text.setVisible(true);
        label.setVisible(true);
        this.text.setMinimumSize(new Dimension(500, 500));
        this.text.setColumns(20);
        super.add(label);
        super.add(text);
        super.setLayout(new FlowLayout());
    }
    
    public void setText(String text_Text){
        text.setText(text_Text);
    }
    
    public String getText(){
     return text.getText();
    }
    
    public Double getDouble(){
        return text.getDouble();
    }
    
    public Integer getInteger(){
        return text.getInteger();
    }
    
    @Override
    public void setEnabled(boolean enabled){
        this.text.setEnabled(enabled);
        this.label.setEnabled(enabled);
    }
}
