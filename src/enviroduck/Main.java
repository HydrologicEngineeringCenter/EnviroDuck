/*
 * Main.java
 *
 * Created on April 1, 2005, 8:16 AM
 */

package enviroduck;

/**
 *
 * @author b4edhdwj
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    // create a min window and run it from the main thread
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        }); 
    }
    
}
