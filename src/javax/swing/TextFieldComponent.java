package javax.swing;

//@author Mohammed El-Shabory

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyListener;


public final class TextFieldComponent extends JComponent{
    private TextField text;
    private Label label;
    
    public TextFieldComponent(){
        this("","TextField");
    }
    public TextFieldComponent(String text_Text,String label_Text){
        super.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.text=new TextField(text_Text);
        this.label=new Label(label_Text);
        this.text.setVisible(true);
        this.label.setVisible(true);
        this.text.setMinimumSize(new Dimension(500, 500));
        this.text.setColumns(10);
        super.add(text);
        super.add(label);
        super.setLayout(new FlowLayout());
        
    }
    
    public TextFieldComponent(String text_Text,String label_Text,String attribut){
        super.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.text=new TextField(text_Text);
        this.label=new Label(label_Text);
        this.text.setVisible(true);
        this.label.setVisible(true);
        this.text.setMinimumSize(new Dimension(500, 500));
        this.text.setColumns(10);
        super.add(text);
        super.add(label);
        super.setLayout(new FlowLayout());
        this.text.setName(attribut);
    }
    
    @Override
    public void setName(String text_Text){
        label.setText(text_Text);
        super.setName(text_Text);
    }
    
    public void setText(String text){
        this.text.setText(text);
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
    
    @Override
    public void addKeyListener (KeyListener keyListener){
        this.text.addKeyListener(keyListener);
    }
    
    @Override
    public String getName (){
        return this.text.getName();
    }
    
    public Component getComponent (){
        return this.text.getComponent(WIDTH);
    }
    
    @Override
    public void setSize(int width,int height){
        this.text.setSize(width, height);
    }
    
    public void setWidth(int width){
        this.text.setWidth(width);
    }
}
