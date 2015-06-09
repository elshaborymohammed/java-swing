package javax.swing;

import java.util.HashMap;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class TableModel extends AbstractTableModel{

    protected DefaultTableModel details;
    protected DefaultTableModel data;
    protected Map<Integer,ComboBoxs> mapComboBoxs=null;
    protected TableModel(){
        details=new DefaultTableModel();
        data=new DefaultTableModel();
        mapComboBoxs= new HashMap<>();
        details.addColumn("TextHeader");
        details.addColumn("Map");
        details.addColumn("Type");
        details.addColumn("CellEdit");
        details.addColumn("Visible");
        //details.addRow(new Object[] {"#","Header",String.class,false,true});
    }
    
    //AbstractTableModel
    @Override
    public int getRowCount() {return data.getRowCount();}

    @Override
    public int getColumnCount() {return details.getRowCount();}
            
    @Override
    public String getColumnName(int columnIndex){ return details.getValueAt(columnIndex, 0).toString(); }
            
    @Override
    public Class getColumnClass(int columnIndex){ return (Class)details.getValueAt(columnIndex,2); }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) { return (Boolean)details.getValueAt(columnIndex, 3); }
            
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        try{
            int index=data.findColumn(details.getValueAt(columnIndex, 1).toString());
            if(getColumnClass(columnIndex)==ComboBox.class){
                ComboBoxs cmbS = mapComboBoxs.get(columnIndex);
                ComboBox cmb = new ComboBox(cmbS.dataSource, cmbS.valueMember, cmbS.displayMember);
                cmb.setSelectedValue(data.getValueAt(rowIndex, index));
                return cmb.getSelectedItem();
            }
//                else if(getColumnClass(columnIndex)==Boolean.class){
//                Object bool = data.getValueAt(rowIndex, index);
//                if(bool.getClass()==Integer.class)
//                    return ((Integer)bool != 0) ;
//                return bool;
//            }
            else{
                return data.getValueAt(rowIndex, index);
            }
        }catch(Exception ex){System.err.println("getValueAt() :"+ex.getMessage()); return null;}
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex){
        try{
            int index=data.findColumn(details.getValueAt(columnIndex, 1).toString());
            if(getColumnClass(columnIndex)==ComboBox.class){
                ComboBoxs cmbS = mapComboBoxs.get(columnIndex);
                ComboBox cmb = new ComboBox(cmbS.dataSource, cmbS.valueMember, cmbS.displayMember);
                cmb.setSelectedItem(value);
                data.setValueAt(cmb.getSelectedValue(), rowIndex, index);
            }
//            else if(getColumnClass(columnIndex)==Boolean.class){
//                //Object bool = data.getValueAt(rowIndex, index);
//                //if(data.getValueAt(rowIndex, index).getClass()==Integer.class)
//                data.setValueAt(((Boolean)value)? 1 : 0, rowIndex, index);
//                //data.setValueAt(value, rowIndex, index);
//            }
            else{
                data.setValueAt(value, rowIndex, index);
            }
            fireTableCellUpdated(rowIndex, columnIndex);
        }catch(Exception ex){System.err.println("setValueAt() : "+ex.getMessage());}
    }
}  
class ComboBoxs{
    protected DefaultTableModel dataSource = null;
    protected int valueMember = -1;
    protected int displayMember = -1;
    
    protected ComboBoxs setComboBox(DefaultTableModel dataSource,int valueMember,int displayMember){
        this.dataSource=dataSource;
        this.valueMember=valueMember;
        this.displayMember=displayMember;
        return this;
    }
}