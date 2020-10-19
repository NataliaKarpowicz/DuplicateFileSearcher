
package projektjava;

import java.io.File;
import javax.swing.*;

public class ProjektJava extends JFrame
{
    ProjektJava()
    {
        initComponents();
    }
    
    void initComponents()
    {
        this.setTitle("Projekt JAVA");
        this.setBounds(300, 100, 620, 402);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(new PanelZWyszukaniemWszystkichKopii());
    }
    
    public static void main(String[] args) 
    {
        new ProjektJava().setVisible(true);
        //ProjektJava.wypiszSciezki(new File("C:/Users/natal/Documents/NetBeansProjects/ProjektJava/Foldery"));
    }
    
}
