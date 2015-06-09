package javax.swing;

import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class ComboBox extends JComboBox<Object>{
    Map<Object, Object> map = new HashMap<>();;
    public ComboBox(){ super(); }
    
    public ComboBox(DefaultTableModel dtm,int valueMember,int displayMember){
	super.setEditable(false);
	super.setToolTipText("Data");
	DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
	for(int i=0;i<dtm.getRowCount();i++){
            map.put(i,dtm.getValueAt(i,valueMember));
            model.addElement(dtm.getValueAt(i,displayMember));
	}
	super.setModel(model);
    }
    
    public void setModel(DefaultTableModel dtm,int valueMember,int displayMember){
        map = new HashMap<>();
	DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
	for(int i=0;i<dtm.getRowCount();i++){
            map.put(i,dtm.getValueAt(i,valueMember));
            model.addElement(dtm.getValueAt(i,displayMember));
	}
	super.setModel(model);
    }
    public Object getSelectedValue(){ return map.get(super.getSelectedIndex()); }
		
    public void setSelectedValue(Object value){ 
        for(Object index : map.keySet()) if(map.get(index).equals(value)) super.setSelectedIndex((Integer)index);
    }
    
    public int getSelectedInteger(){ return (Integer)this.getSelectedValue(); }
}
