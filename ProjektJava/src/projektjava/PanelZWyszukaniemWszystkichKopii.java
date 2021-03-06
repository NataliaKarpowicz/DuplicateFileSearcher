/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektjava;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author natal
 */
public class PanelZWyszukaniemWszystkichKopii extends javax.swing.JPanel {

    /**
     * Creates new form PanelZWyszukaniemWszystkichKopii
     */
    public PanelZWyszukaniemWszystkichKopii() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etykietaSciezka = new javax.swing.JLabel();
        poleTekstoweSciezka = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        obszarTekstowy = new javax.swing.JTextArea();
        buttonSzukaj = new javax.swing.JButton();
        etykietaWykrytaIloscPowtorzen = new javax.swing.JLabel();

        etykietaSciezka.setText("Ścieżka:");

        poleTekstoweSciezka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poleTekstoweSciezkaActionPerformed(evt);
            }
        });

        obszarTekstowy.setColumns(20);
        obszarTekstowy.setRows(5);
        jScrollPane1.setViewportView(obszarTekstowy);

        buttonSzukaj.setText("Szukaj");
        buttonSzukaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSzukajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(etykietaSciezka, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(poleTekstoweSciezka, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(etykietaWykrytaIloscPowtorzen, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(buttonSzukaj, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etykietaSciezka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(poleTekstoweSciezka, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(buttonSzukaj)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(etykietaWykrytaIloscPowtorzen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void poleTekstoweSciezkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poleTekstoweSciezkaActionPerformed
        this.sciezka = poleTekstoweSciezka.getText();
    }//GEN-LAST:event_poleTekstoweSciezkaActionPerformed

    private void buttonSzukajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSzukajActionPerformed
        wyszukajPliki(sciezka, obszarTekstowy);
    }//GEN-LAST:event_buttonSzukajActionPerformed

    void wyszukajPliki(String sciezka, javax.swing.JTextArea obszarTekstowy)
    {
        //czyszczenie planszy
        obszarTekstowy.selectAll();
        obszarTekstowy.replaceSelection("");
        File nazwaSciezki = new File(sciezka);
        
        int ileSciezek = 0;

        listaSciezek = new ArrayList<File>();
        znajdzSciezki(nazwaSciezki, listaSciezek,obszarTekstowy);
        
        for(int i=0; i < listaSciezek.size(); i++)
        {
            for(int j=0; j<listaSciezek.size(); j++)
            {
                if(listaSciezek.get(i).getName().equals(listaSciezek.get(j).getName()) && i!=j)
                {
                    obszarTekstowy.append(listaSciezek.get(i).getPath()+"\n");
                    listaSciezek.set(i, new File("c:/"));
                    ileSciezek++;
                }                
            }
        }
        
        etykietaWykrytaIloscPowtorzen.setText("Wykryta ilość powtórzeń: "+String.valueOf(ileSciezek));
    }
    
    public static void znajdzSciezki(File nazwaSciezki, List<File> listaSciezek1, javax.swing.JTextArea obszarTekstowy)
    {
       String[] nazwyPlikowIKatalogow = nazwaSciezki.list();
       
       for (int i = 0; i < nazwyPlikowIKatalogow.length; i++)
       {
           File p = new File(nazwaSciezki.getPath(), nazwyPlikowIKatalogow[i]);
          
           if (p.isFile())
           {
               listaSciezek1.add(p);
           } 
           
           if (p.isDirectory())
           {
               znajdzSciezki(new File(p.getPath()), listaSciezek1, obszarTekstowy);    
           }
       }
    }
    
    private List<File> listaSciezek;
    private String sciezka;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSzukaj;
    private javax.swing.JLabel etykietaSciezka;
    private javax.swing.JLabel etykietaWykrytaIloscPowtorzen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea obszarTekstowy;
    private javax.swing.JTextField poleTekstoweSciezka;
    // End of variables declaration//GEN-END:variables
}
