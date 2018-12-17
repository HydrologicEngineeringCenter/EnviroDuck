/*
 * DateDialog.java
 *
 * Created on April 4, 2005, 8:43 AM
 */

package enviroduck;

/**
 *
 * @author  b4edhdwj
 */
public class DateDialog extends javax.swing.JDialog {
    
    /** Creates new form DateDialog */
    public DateDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jStartPanel = new javax.swing.JPanel();
        jInitalDate = new customcontrols.DateInput();
        jStopPanel = new javax.swing.JPanel();
        jFinalDate = new customcontrols.DateInput();
        jMessage = new javax.swing.JTextArea();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Start Date");
        setBackground(new java.awt.Color(236, 233, 216));
        jStartPanel.setLayout(null);

        jStartPanel.setBorder(new javax.swing.border.TitledBorder(null, "Inital Date", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jStartPanel.setName("Start Date");
        jStartPanel.add(jInitalDate);
        jInitalDate.setBounds(10, 30, 100, 24);

        getContentPane().add(jStartPanel);
        jStartPanel.setBounds(10, 10, 120, 60);

        jStopPanel.setLayout(null);

        jStopPanel.setBorder(new javax.swing.border.TitledBorder(null, "Final Date", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jStopPanel.setName("Start Date");
        jStopPanel.add(jFinalDate);
        jFinalDate.setBounds(10, 30, 100, 24);

        getContentPane().add(jStopPanel);
        jStopPanel.setBounds(10, 80, 120, 60);

        jMessage.setBackground(new java.awt.Color(236, 233, 216));
        jMessage.setEditable(false);
        jMessage.setLineWrap(true);
        jMessage.setText("Select the first and last day of the season.");
        jMessage.setWrapStyleWord(true);
        getContentPane().add(jMessage);
        jMessage.setBounds(140, 10, 70, 130);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-240)/2, (screenSize.height-180)/2, 240, 180);
    }//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DateDialog(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
    
    /** public int getInitalMonth()
     *
     * returns: The inital month as an integer in the range 1-12 inclusive */
    
    public int getInitalMonth()
    {
        return jInitalDate.getMonthInt();
    }

    /** public int getInitalDay()
     *
     * returns: The inital day as an integer in the range 1-31 inclusive */    
    
    public int getInitalDay()
    {
        return jInitalDate.getDayInt();
    }

    /** public int getFinalMonth()
     *
     * returns: The final month as an integer in the range 1-12 inclusive */    
    
    public int getFinalMonth()
    {
        return jFinalDate.getMonthInt();
    }

    /** public int getFinalDay()
     *
     * returns: The final day as an integer in the range 1-31 inclusive */        
    
    public int getFinalDay()
    {
        return jFinalDate.getDayInt();
    }
    
    /** public void setInitalMonth(int m)
     *
     * Set the inital mounth with an integer in the range of 1 - 12.
     * invalid values are ignored */
    
    public void setInitalMonth(int m)
    {
        jInitalDate.setMonth(m);
    }

    /** public void setFinalDay(int m)
     *
     * Set the final mounth with an integer in the range of 1 - 31.
     * The values 30 and 31 may not be valid depending on the current mounth.
     * Set the month then the day.
     * invalid values are ignored */        
    
    public void setInitalDay(int d)
    {
        jInitalDate.setDay(d);
    }

    /** public void setFinalMonth(int m)
     *
     * Set the final mounth with an integer in the range of 1 - 12.
     * invalid values are ignored */    
    
    public void setFinalMonth(int m)
    {
        jFinalDate.setMonth(m);
    }

    /** public void setFinalDay(int m)
     *
     * Set the final mounth with an integer in the range of 1 - 31.
     * The values 30 and 31 may not be valid depending on the current mounth.
     * Set the month then the day.
     * invalid values are ignored */     
    
    public void setFinalDay(int d)
    {
        jFinalDate.setDay(d);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customcontrols.DateInput jFinalDate;
    private customcontrols.DateInput jInitalDate;
    private javax.swing.JTextArea jMessage;
    private javax.swing.JPanel jStartPanel;
    private javax.swing.JPanel jStopPanel;
    // End of variables declaration//GEN-END:variables
    
}
