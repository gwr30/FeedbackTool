package TestLibrary;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
 
public class Pane extends JPanel {
    public Pane(ArrayList<String> tabs) {
        super(new GridLayout(1, 1));
         
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("");
        
        java.util.Iterator<String> t = tabs.iterator();
        int counter =1;
        while(t.hasNext()){
        	 JComponent panel = makeTextPanel(t.next());
        	 panel.setPreferredSize(new Dimension(300, 500));
        	 //panel.setLineWrap(true);
             tabbedPane.addTab("Test "+counter, icon, panel,
                     "Test Results");
             counter++;
        }
         
        
      
         
        //Add the tabbed pane to this panel.
        add(tabbedPane);
         
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
     
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel("<html><body style='width: 200px'>"+text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
     
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Pane.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
 
            return null;
        }
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI(ArrayList<String> tabs) {
        //Create and set up the window.
        JFrame frame = new JFrame("Advice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Change colour of the frame
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        
         
        //Add content to the window.
        frame.add(new Pane(tabs), BorderLayout.CENTER);
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    public static  void go(ArrayList<String> tabs) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI(tabs);
            }
        });
    }
     

}
