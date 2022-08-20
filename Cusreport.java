private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        setVisible(false); //you can't see me!
        dispose();
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
                setVisible(false); //you can't see me!
        dispose();
    }                                        

    
    private void table_update() {
        int CC;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/sanbank_database","root","");
            
            insert = con1.prepareStatement("select c.id,c.firstname,c.lastname,c.street,c.city,b.branch,c.phone from customer c,branch b where b.id = c.branch");
             ResultSet Rs = insert.executeQuery();
            
   
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
            DFT.setRowCount(0);

            while (Rs.next()) {
                Vector v2 = new Vector();
           
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(Rs.getString("id"));
                    v2.add(Rs.getString("firstname"));
                    v2.add(Rs.getString("lastname"));
                     v2.add(Rs.getString("street"));
                    v2.add(Rs.getString("city"));
                    v2.add(Rs.getString("branch"));
                    v2.add(Rs.getString("phone"));
                    
                    
                    
                    
                    
                    
                }

                DFT.addRow(v2);
            }
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
