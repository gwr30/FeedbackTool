package TestCollection;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;        

public class AdvicePopUp {
	
	//String advice = "No Advice Found!";
	
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI(String advice) {
        //Create and set up the window.
        JFrame frame = new JFrame("Advice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setBorder(BorderFactory.createLineBorder(Color.black));
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));

        //Add label.
        JLabel label = new JLabel(advice, SwingConstants.CENTER);
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    public static void showAdvice(final String advice){
    	
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(convertToMultiline(advice));
            }
        });
    }
    
    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

	

  
}


