package javax.swing;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Table extends JTable{
    private TableModel t=new TableModel();
    private TableRowSorter<javax.swing.table.TableModel> sorter;
    public Table(){
        this("Table");
    }
    
    public Table(String name){
        super.setVisible(true);
        super.setName(name);
//        super.setModel(t);
    }
    
    public void addColumn(String textHeader,String map,Class type,boolean cellEdit,boolean visable){
        t.details.addRow(new Object[]{textHeader,map,type,cellEdit,visable});
    }
    
    public void addComboBoxColumn(String textHeader,String map,Class type,boolean cellEdit,boolean vissble,DefaultTableModel dataSource,int valueMember,int displayMember){
        t.details.addRow(new Object[]{textHeader,map,type,cellEdit,vissble});
        t.mapComboBoxs.put(t.details.getRowCount()-1, new ComboBoxs().setComboBox(dataSource, valueMember, displayMember));
    }
    
    public void DrawTable(){
       super.setModel(t);
       sorter = new TableRowSorter<javax.swing.table.TableModel>(this.t.data);
       this.setRowSorter(sorter);
       if(!t.mapComboBoxs.isEmpty()){
           for(int columnIndex : t.mapComboBoxs.keySet()){
               ComboBoxs cmb = t.mapComboBoxs.get(columnIndex);
               super.getColumnModel().getColumn(columnIndex).setCellEditor(new DefaultCellEditor(new ComboBox(cmb.dataSource, cmb.valueMember, cmb.displayMember)));
           }
       }
       if(t.details.getRowCount()!=0) 
           for(int i=0;i<t.details.getRowCount();i++){ if(!(Boolean) t.details.getValueAt(i, 4)) this.HiddenColumn(i); }
    }
    
    public void setModel(DefaultTableModel dataSource){
        t.data=dataSource;
        DrawTable();
    }
    public DefaultTableModel getDataSource(){
        return t.data;
    }
    
    public void HiddenColumn(int index){
        this.getColumnModel().getColumn(index).setMinWidth(0);
        this.getColumnModel().getColumn(index).setMaxWidth(0);
        this.getColumnModel().getColumn(index).setWidth(0);
    }
    
    public Object getSelectedCell(int rowIndex,int columnIndex){
        int index=t.data.findColumn(t.details.getValueAt(columnIndex, 1).toString());
        return t.data.getValueAt(rowIndex, index);
    }
    
    public Boolean getSelectedCellBoolean(int rowIndex,int columnIndex){
        return (Boolean)this.getValueAt(rowIndex, columnIndex);
    }
    
    public Integer getSelectedCellInteger(int rowIndex,int columnIndex){
        return Integer.parseInt(this.getSelectedCellString(rowIndex, columnIndex));
    }
    
    public Double getSelectedCellDouble(int rowIndex,int columnIndex){
        return Double.parseDouble(this.getSelectedCellString(rowIndex, columnIndex));
    }
    
    public String getSelectedCellString(int rowIndex,int columnIndex){
        return this.getSelectedCell(rowIndex, columnIndex).toString();
    }
    
    public void fireTableRowDeleted(int rowIndex){
        t.data.removeRow(rowIndex);
        t.fireTableRowsDeleted(rowIndex,rowIndex);
    }

    public void fireTableRowsDeleted(int firstRow,int lastRow){
        for(int i=firstRow;i<=lastRow;i++)
            t.data.removeRow(i);
        t.fireTableRowsDeleted(firstRow,lastRow);
    }
    
    public void fireTableRowInserted(){
        t.fireTableRowsInserted(t.data.getRowCount()-1,t.data.getRowCount()-1);
    }
    
    public void fireTableRowUpdate(int RowIndex){
        t.fireTableRowsUpdated(RowIndex,RowIndex);
    }
    
    public void fireTableDataChanged(){
        t.fireTableDataChanged();
    }
    
    public void setSelectedRow(int row){
        if(this.getRowCount() != 0){
         this.scrollRectToVisible(this.getCellRect(row, this.getColumnCount()-1,true));
         this.setRowSelectionInterval(row,row);
        }
    }
    
    public void setSelectedLastRow(){
        setSelectedRow(this.getRowCount()-1);
    }
    
    @SuppressWarnings("UseOfObsoleteCollectionType")
    public Vector getSelectedRow(int row)throws Exception{
        Vector<Vector> data = this.t.data.getDataVector();
        return data.get(row);
    }
    
    public void setData(int column,Object data){
        this.t.data.setValueAt(data, this.getSelectedRow(), column);
    }
    
    public void setFilter(TextFieldComponent component,int[] columnIndexs) throws PatternSyntaxException{
        if(component.getText().length()==0) {sorter.setRowFilter(null);}
        else{
            List<RowFilter<javax.swing.table.TableModel,Object>> filters = new ArrayList<>();
            for(int currentIndex : columnIndexs){
                RowFilter<javax.swing.table.TableModel,Object> rowFilter = RowFilter.regexFilter(component.getText(), currentIndex);
                filters.add(rowFilter);
            }
            RowFilter<javax.swing.table.TableModel, Object> filter = RowFilter.orFilter(filters);
            sorter.setRowFilter(filter);
        }
        this.setFillsViewportHeight(false);
    }
    
    @Override
    public void setRowSelectionInterval(int index0,int index1){
        if(this.t.data.getRowCount()==0){ return; }
        if(index0==index1){
            if(this.t.data.getRowCount()-1 <= index0){ super.setRowSelectionInterval(this.t.data.getRowCount()-1,this.t.data.getRowCount()-1); }
            else{ super.setRowSelectionInterval(index0,index0); }
        }
    }
}