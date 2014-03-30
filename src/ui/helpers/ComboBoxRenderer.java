package ui.helpers;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author Supun Nakandala
 */
public class ComboBoxRenderer extends BasicComboBoxRenderer{
    
    private String[] tooltip;
    
    public ComboBoxRenderer(String[] arr){
        this.tooltip = arr;
    }
    
    @Override  
       public Component getListCellRendererComponent(JList list, Object value,  
               int index, boolean isSelected, boolean cellHasFocus) {  
           if (isSelected) {  
               setBackground(list.getSelectionBackground());  
               setForeground(list.getSelectionForeground());  
               if (-1 < index) {  
                   list.setToolTipText(tooltip[index]);  
               }  
           } else {  
               setBackground(list.getBackground());  
               setForeground(list.getForeground());  
           }  
           setFont(list.getFont());  
           setText((value == null) ? "" : value.toString());  
           return this;  
       } 
}
