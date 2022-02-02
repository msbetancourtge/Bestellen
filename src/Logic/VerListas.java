
package Logic;

import javax.swing.ListModel;

public class VerListas extends javax.swing.JFrame {

    private Bestellen2 app;
    int opcion = 0;
    
    public VerListas() {
        initComponents();
    }
    public VerListas(Bestellen2 apli, int opcion) {
        app = apli;
        this.opcion = opcion;
        initComponents();
        
        choice1.removeAll();
        
        if(opcion == 1){
            
        }else if(opcion == 3){
            listaBebidas();
        }else if(opcion == 2){
            listaPlatos();
        }
    }
    public void listaClientes(){
        choice1.removeAll();
        for (int i = 0; i < app.restauranteSeleccionado.bebidas.size(); i++) {
            choice1.addItem(app.restauranteSeleccionado.bebidas.get(i).getNombre());
            //jList1.setModel((ListModel<String>) app.Restaurantes);
            }
    }
    public void listaRestaurantes(){
        choice1.removeAll();
        for (int i = 0; i < app.Restaurantes.getSize(); i++) {
                choice1.addItem(app.find(app.Restaurantes.getRoot(), (i-1)).getData().getNombre());
            }
    }
    public void listaBebidas(){
        choice1.removeAll();
        for (int i = 0; i < app.restauranteSeleccionado.bebidas.size(); i++) {
            choice1.addItem(app.restauranteSeleccionado.bebidas.get(i).getNombre());
            //jList1.setModel((ListModel<String>) app.Restaurantes);
            }
    }
    public void listaPlatos(){
        choice1.removeAll();
        for (int i = 0; i < app.restauranteSeleccionado.platos.size(); i++) {
            choice1.addItem(app.restauranteSeleccionado.platos.get(i).getNombre());
            //jList1.setModel((ListModel<String>) app.Restaurantes);
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choice1 = new java.awt.Choice();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Escoger");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuPrincipal dd = new MenuPrincipal(app);
        dd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (opcion == 1){
            app.restauranteSeleccionado = app.find(app.Restaurantes.getRoot(), choice1.getSelectedIndex()).getData();
            MenuDelRestaurante menu = new MenuDelRestaurante(app);
            menu.setVisible(true);
            this.setVisible(false);
        }else if (opcion == 2){
            app.usuarioSeleccionado = app.findUser(app.Usuarios.getRoot(), choice1.getSelectedIndex()).getData();
            MenuDelRestaurante menu = new MenuDelRestaurante(app);
            menu.setVisible(true);
            this.setVisible(false);
        }else if (opcion == 3){
            
        }else if (opcion == 4){
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerListas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
