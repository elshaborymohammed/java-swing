package javax.swing;

// @author GabrielOmr

import java.awt.FlowLayout;

public class CheckBoxComponent extends JComponent{
    private CheckBox checkBox;
    private Label label;
    
    public CheckBoxComponent(String label_Text){
        this.checkBox=new CheckBox();
        this.label=new Label(label_Text);
        this.checkBox.setVisible(true);
        this.label.setVisible(true);
        super.add(label);
        super.add(checkBox);
        super.setLayout(new FlowLayout());
    }
    
    public void setSelected(boolean selecte){
        checkBox.setSelected(selecte);
    }
    
    public boolean isSelected(){ return checkBox.isSelected(); }
    
    @Override
    public void setEnabled(boolean enabled){
        this.checkBox.setEnabled(enabled);
        this.label.setEnabled(enabled);
    }
}
