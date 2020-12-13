import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 

public class Menu extends JFrame implements ActionListener {
  
    static JFrame frame; 
   
    public static void main(String[] args) 
    {
        // créer un frame 
        frame = new JFrame("Bataille Navale - MENU"); 
        // créer un objet
        JDialogMenu obj = new JDialogMenu(); 
        // créer un panneau 
        JPanel panel = new JPanel(); 
        JButton btn = new JButton("Jouer"); 
        // ajouter le listener au bouton
        btn.addActionListener(obj); 
        // ajouter un bouton au panneau
        panel.add(btn); 
        frame.add(panel); 
        frame.setSize(300, 300); 
        frame.show(); 
    } 
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
        if(s.equals("Jouer"))
        {
            // Créer une boîte de dialogue
            JDialog d = new JDialog(frame, "Boite de dialogue"); 
            // Créer une étiquette
            JLabel l = new JLabel("Ceci est une boite de dialogue."); 
            // Ajouter l'étiquette à la boîte de dialogue 
            d.add(l); 
            // Définir la taille de la boîte de dialogue 
            d.setSize(200, 100); 
            // Définir la visibilité de la boîte de dialogue
            d.setVisible(true); 
        } 
    } 
}