/*
 * NewJDialog.java
 *
 * Created on April 6, 2005, 8:22 AM
 */

package enviroduck;

import javax.swing.*;

/**
 *
 * @author  b4edhdwj
 */
public class PrefDialog extends javax.swing.JDialog {
    
    /** Creates new form NewJDialog */
    public PrefDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);       // make the window float
        initComponents();
        
        userCancel = true;
        getRootPane().setDefaultButton(okButton);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jScrollPane1 = new javax.swing.JScrollPane();
        dataList = new JList(new javax.swing.DefaultListModel());
        jScrollPane2 = new javax.swing.JScrollPane();
        areaList = new JList(new javax.swing.DefaultListModel());
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        dataAddButton = new javax.swing.JButton();
        dataRemoveButton = new javax.swing.JButton();
        areaAddButton = new javax.swing.JButton();
        areaRemoveButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jScrollPane1.setBorder(new javax.swing.border.TitledBorder(null, "Data C Parts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));
        dataList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(dataList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 360, 100);

        jScrollPane2.setBorder(new javax.swing.border.TitledBorder(null, "Area C Parts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));
        areaList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(areaList);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 140, 360, 110);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        getContentPane().add(okButton);
        okButton.setBounds(300, 320, 60, 23);

        cancelButton.setText("Cancel");
        cancelButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        getContentPane().add(cancelButton);
        cancelButton.setBounds(235, 320, 60, 23);

        dataAddButton.setFont(new java.awt.Font("Tahoma", 0, 9));
        dataAddButton.setText("+");
        dataAddButton.setFocusable(false);
        dataAddButton.setIconTextGap(0);
        dataAddButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        dataAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataAddButtonActionPerformed(evt);
            }
        });

        getContentPane().add(dataAddButton);
        dataAddButton.setBounds(340, 110, 20, 20);

        dataRemoveButton.setFont(new java.awt.Font("Tahoma", 0, 9));
        dataRemoveButton.setText("-");
        dataRemoveButton.setEnabled(false);
        dataRemoveButton.setIconTextGap(0);
        dataRemoveButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        dataRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataRemoveButtonActionPerformed(evt);
            }
        });

        getContentPane().add(dataRemoveButton);
        dataRemoveButton.setBounds(320, 110, 20, 20);

        areaAddButton.setFont(new java.awt.Font("Tahoma", 0, 9));
        areaAddButton.setText("+");
        areaAddButton.setIconTextGap(0);
        areaAddButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        areaAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaAddButtonActionPerformed(evt);
            }
        });

        getContentPane().add(areaAddButton);
        areaAddButton.setBounds(340, 250, 20, 20);

        areaRemoveButton.setFont(new java.awt.Font("Tahoma", 0, 9));
        areaRemoveButton.setText("-");
        areaRemoveButton.setEnabled(false);
        areaRemoveButton.setIconTextGap(0);
        areaRemoveButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        areaRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaRemoveButtonActionPerformed(evt);
            }
        });

        getContentPane().add(areaRemoveButton);
        areaRemoveButton.setBounds(320, 250, 20, 20);

        jButton1.setText("Reset");
        jButton1.setToolTipText("Reset Preferences to the default values");
        jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton1);
        jButton1.setBounds(20, 280, 70, 23);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-388)/2, (screenSize.height-387)/2, 388, 387);
    }//GEN-END:initComponents

    /** void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
     *
     *  This methode resets the prefrences of the MainWindow that involked the Prefrences dialog
     *  by calling its resetPrefs() method */
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        javax.swing.DefaultListModel m;
        
        // reset the data list
        m = (javax.swing.DefaultListModel) dataList.getModel();
        m.clear();
        m.addElement("ELEV");
        
        // reset the area list
        m = (javax.swing.DefaultListModel) areaList.getModel();
        m.clear();
        m.addElement("ELEV-AREA");
        
        // reset model values
        MainWindow w = (MainWindow) this.getParent();
        
        w.resetPrefs(); 
        

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void areaRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaRemoveButtonActionPerformed
        javax.swing.DefaultListModel m = (javax.swing.DefaultListModel) areaList.getModel();
        
        // get the current selection 
        int pos = areaList.getMinSelectionIndex();
        
        if ( pos < 0 ) 
        {
            // this should never happen but if there was a negative selection
            // disable the remove button and return
            areaRemoveButton.setEnabled(false);
            return;
        }
        
        m.remove(pos);
        
        //move the position if nessessary
        if ( pos == m.size() )
        {
            pos -= 1;
            dataList.setSelectedIndex(pos);
        }        
        
        // dissable the remove button if there is only one entry remaining
        if ( m.getSize() <= 1 )
        {
            areaRemoveButton.setEnabled(false);
        }
        else
        {
            areaRemoveButton.setEnabled(true);
        }
    }//GEN-LAST:event_areaRemoveButtonActionPerformed

    /** void dataRemoveButtonActionPerformed(java.awt.event.ActionEvent evt)
     *
     *  This methode is called in response to remove button for the data list being
     *  pushed. It removes the selected member in the data list. */
    
    private void dataRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataRemoveButtonActionPerformed
        javax.swing.DefaultListModel m = (javax.swing.DefaultListModel) dataList.getModel();
        
        // get the current selection
        int pos = dataList.getMinSelectionIndex();
        if ( pos < 0 ) 
        {
            // this should never happen but if there was a negative selection
            // disable the remove button and return
            dataRemoveButton.setEnabled(false);
            return;
        }
        
        // remove the selected entry
        m.remove(pos);
        
        //move the position if nessessary
        if ( pos == m.size() )
        {
            pos -= 1;
            dataList.setSelectedIndex(pos);
        }
        
        // dissable the remove button if there is only one entry remaining
        if ( m.getSize() <= 1 )
        {
            dataRemoveButton.setEnabled(false);
        }
        else
        {
            dataRemoveButton.setEnabled(true);
        }
    }//GEN-LAST:event_dataRemoveButtonActionPerformed

    /** private void areaAddButtonActionPerformed(java.awt.event.ActionEvent evt)
     *
     *  This methode is called in response to the add button for the area list being pressed.
     *  It promtes the user for a new C Part that is added to the area list
     */    
    
    private void areaAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaAddButtonActionPerformed
        javax.swing.DefaultListModel m = (javax.swing.DefaultListModel) areaList.getModel();
        
        // iget the current selection
        int pos = areaList.getMinSelectionIndex();
        if ( pos < 0 ) pos = 0;
        
        String s = javax.swing.JOptionPane.showInputDialog(this,
                "Enter a new C Part",
                "Add Data",
                javax.swing.JOptionPane.PLAIN_MESSAGE);
        
        // add the new item after the current selection
        m.add(pos+1,s);
             
        // select the new item
        areaList.setSelectedIndex(pos+1);
        
        areaRemoveButton.setEnabled(true);
    }//GEN-LAST:event_areaAddButtonActionPerformed

    /** private void dataAddButtonActionPerformed(java.awt.event.ActionEvent evt)
     *
     *  This methode is called in response to the add button for the data list being pressed.
     *  It promtes the user for a new C Part that is added to the data list
     */
    
    private void dataAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataAddButtonActionPerformed
        javax.swing.DefaultListModel m = (javax.swing.DefaultListModel) dataList.getModel();
        
        // get the current selection
        int pos = dataList.getMinSelectionIndex();
        if ( pos < 0 ) pos = 0;
        
        String s = javax.swing.JOptionPane.showInputDialog(this,
                "Enter a new C Part",
                "Add Data",
                javax.swing.JOptionPane.PLAIN_MESSAGE);
        
        // add the new item after the current selection
        m.add(pos+1,s);
        
        // select the new item
        dataList.setSelectedIndex(pos+1);
        
        // enable the remove button
        dataRemoveButton.setEnabled(true);
        
        
    }//GEN-LAST:event_dataAddButtonActionPerformed

    /** private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)
     *
     *  Accept the changes in the dialog and hide it */     
    
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        setVisible(false);
        userCancel = false;
    }//GEN-LAST:event_okButtonActionPerformed

    /** private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)
     *
     *  Cancel and hide the dialog */ 
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        userCancel = true;
        
    }//GEN-LAST:event_cancelButtonActionPerformed
    /** void setAreaList(String vals)
     *
     * @param vals 
     *  A colon deliminated list of acceptable C parts for 
     *  gage data */    

    public void setDataList(String vals)
    {
        javax.swing.DefaultListModel m;

        m = (javax.swing.DefaultListModel) dataList.getModel();
        m.clear();
        
        String[] val = vals.split(":");
        
        for(int i = 0; i < val.length; ++i)
        {
            m.addElement(val[i]);
        }
        
        if ( m.getSize() > 0 )
        {
            dataList.setSelectedIndex(0);
        }
        
        if ( m.getSize() > 1)
        {
            dataRemoveButton.setEnabled(true);
        }
    }
    /** getDataList()
     *
     * returns: A colon deliminated list of acceptable C parts for gage data curves */ 
    
    public String getDataList()
    {
        StringBuffer buffer = new StringBuffer();
        
        // get the list model
        javax.swing.ListModel m = (javax.swing.ListModel) dataList.getModel();
        
        // make the return string by concatinating the members of
        // the list model
        for( int i = 0; i < m.getSize()-1; ++i)
        {
            buffer.append(m.getElementAt(i));
            buffer.append(":");
        }
        buffer.append(m.getElementAt(m.getSize()-1));
        
        return buffer.toString();
    }
    
    /** void setAreaList(String vals)
     *
     * @param vals 
     *  A colon deliminated list of acceptable C parts for 
     *  stage area curves */
    
     public void setAreaList(String vals)
    {
        javax.swing.DefaultListModel m;

        m = (javax.swing.DefaultListModel) areaList.getModel();
        m.clear();
        
        // break the list into its parts
        String[] val = vals.split(":");
        
        for(int i = 0; i < val.length; ++i)
        {
            // add the parts to the list components
            m.addElement(val[i]);
        }
        
        // if there is at least one part select the first part
        if ( m.getSize() > 0 )
        {
            areaList.setSelectedIndex(0);
        }
        
        // if there are more than one parts enable the remove button
        if ( m.getSize() > 1)
        {
            areaRemoveButton.setEnabled(true);
        }
    }
    
    /** getAreaList()
     *
     * returns: A colon deliminated list of acceptable C parts for stage area curves */ 
     
    public String getAreaList()
    {
        StringBuffer buffer = new StringBuffer();
        
        javax.swing.ListModel m = (javax.swing.ListModel) areaList.getModel();
        
        // make the list by concatnating the members of the listModel
        for( int i = 0; i < m.getSize()-1; ++i)
        {
            buffer.append(m.getElementAt(i));
            buffer.append(":");
        }
        buffer.append(m.getElementAt(m.getSize()-1));
        
        return buffer.toString();
    }   

    /** boolean cancel()
     *
     * returns: True if the cancel button was pressed to dismiss the dialog otherwise false. */
    
    boolean cancel() { return userCancel; }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton areaAddButton;
    private javax.swing.JList areaList;
    private javax.swing.JButton areaRemoveButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton dataAddButton;
    private javax.swing.JList dataList;
    private javax.swing.JButton dataRemoveButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    
    //User Variables
    
    private boolean userCancel;             // did the user cancel
}
