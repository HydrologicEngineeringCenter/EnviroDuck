/*
 * ReportDisplay.java
 *
 * Created on April 1, 2005, 7:47 AM
 */

package enviroduck;

/**
 *
 * @author  b4edhdwj
 */

import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import static java.awt.event.InputEvent.SHIFT_DOWN_MASK;
import static java.awt.event.InputEvent.META_DOWN_MASK;

import javax.print.*;

public class ReportDisplay extends javax.swing.JFrame {
    
    /** Creates new form ReportDisplay */
    public ReportDisplay() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });

        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-600)/2, (screenSize.height-500)/2, 600, 500);
    }//GEN-END:initComponents

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased

        
       String msg = evt.getKeyText(evt.getKeyCode());
        
       int code = evt.getKeyCode();
       
        switch(code)
        {
            case java.awt.event.KeyEvent.VK_P:
            int onmask = CTRL_DOWN_MASK ;
            int offmask = SHIFT_DOWN_MASK | META_DOWN_MASK;
            int mod = evt.getModifiersEx();
            if ( ( mod & (onmask | offmask) ) == onmask ) 
            {
                /*javax.print.Doc doc = new javax.print.SimpleDoc(jTextArea1.getText(),
                        javax.print.DocFlavor.STRING.TEXT_PLAIN,null);
                
                javax.print.attribute.HashPrintRequestAttributeSet aset = new javax.print.attribute.HashPrintRequestAttributeSet(); 
                //aset.add(javax.print.attribute.standard.OrientationRequested.PORTRAIT);
                
                javax.print.PrintService[] services 
                        = javax.print.PrintServiceLookup.lookupPrintServices(javax.print.DocFlavor.STRING.TEXT_PLAIN, aset);
                
                javax.print.DocPrintJob job = services[0].createPrintJob();
                
                try
                {
                    job.print(doc, aset);
                }
                catch( javax.print.PrintException exp)
                {
                    
                }*/
                
                PrintService[] service = 
                        javax.print.PrintServiceLookup.lookupPrintServices( DocFlavor.INPUT_STREAM.TEXT_PLAIN_HOST,null);
                
                if ( service.length > 0)
                {
                    service[0].getName();
                }
                
               
            }
            default:
                    
        }
    }//GEN-LAST:event_jTextArea1KeyReleased
    
    /** void setText(String txt)
     *
     *  Set the text buffer that this window will display */
    
    public void setText(String txt)
    {
        int count = 0;
        int pos = txt.indexOf("\n");
        while( pos != - 1)
        {
            count++;
            pos = txt.indexOf("\n",pos+1);
        }
        
        jTextArea1.setRows(count);
        jTextArea1.setText(txt);
        
    }
    
    /** String getText()
     * 
     * get a copy of the text this window displays */
    
    public String getText()
    {
        return jTextArea1.getText();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    
}
