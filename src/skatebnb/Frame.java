package skatebnb;



import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;
import skatebnb.Controller.Company;


public class Frame extends JFrame {
    
        private Company base;
        
        
    Frame(){
        
        super ("Skate BNB");
        base = new Company();
        add(base);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (810, 600);    
        setVisible(true);
    }
   
}
