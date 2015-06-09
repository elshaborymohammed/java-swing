package javax.swing;

// @author Mohammed El-Shabory

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import javax.swing.table.DefaultTableModel;

public class ComboBoxComponent extends JComponent{
    private ComboBox comboBox;
    private Label label;
    public ComboBoxComponent(){ this("combobox"); }
    public ComboBoxComponent(String text){
        this.comboBox=new ComboBox();
        this.label=new Label(text);
        this.comboBox.setVisible(true);
        this.label.setVisible(true);
        super.add(label);
        super.add(comboBox);
        super.setLayout(new FlowLayout());
    }
    public ComboBoxComponent(DefaultTableModel dataSource,int valueMember,int displayMember,String label_Text){
        this.comboBox=new ComboBox(dataSource,valueMember,displayMember);
        this.label=new Label(label_Text);
        this.comboBox.setVisible(true);
        this.label.setVisible(true);
        this.comboBox.setSelectedIndex(0);
        super.add(label);
        super.add(comboBox);
        super.setLayout(new FlowLayout());
    }
    
    @Override
    public void setName(String text){
        this.label.setText(text);
        super.setName(text);
    }
    public void setModel(DefaultTableModel dataSource,int valueMember,int displayMember){
        this.comboBox.setModel(dataSource, valueMember, displayMember);
        this.comboBox.setSelectedIndex(0);
    }
    public int getSelectedIndex(){
        return this.comboBox.getSelectedIndex();
    }
    public void setSelectedIndex(int index){
        this.comboBox.setSelectedIndex(index);
    }
    public Object getSelectedValue(){
        return this.comboBox.getSelectedValue();
    }
    public void setSelectedValue(Object value){
        this.comboBox.setSelectedValue(value);
    }
    
    public int getSelectedInteger(){
        return this.comboBox.getSelectedInteger();
    }
    
    @Override
    public void setEnabled(boolean enabled){
        this.comboBox.setEnabled(enabled);
        this.label.setEnabled(enabled);
    }
    
    public void addItemListener(ItemListener itemListener){
        this.comboBox.addItemListener(itemListener);
    }
}
