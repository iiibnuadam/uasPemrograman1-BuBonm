/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathquiz;

import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;



public class MathQuiz extends javax.swing.JFrame {
    static final int JUMLAH_SOAL = 10;
    Matematik mat = new Matematik();
    public int[][] arr = new int[10][4];
    public String[] soal = new String[10];
    int temp, currentSoal;
    static int grade = 0;
    
    
    
    Timer timer;
    public MathQuiz() {
        grade = 0;
        initComponents();
        timer();
        createSoal();
        parseSoal(currentSoal);
        if(currentSoal>9){
            timer.cancel();
            timer.purge();
        }
    }
    int waktu = 10;
    void timer(){
         int delay=1000;
        int period=1000;
        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                jLabelWaktu.setText(""+waktu);
                waktu--;
                if(waktu==-1)
                {       
                        checkJawaban();
                        waktu = 11;
                        waktu--;
                }
            }
        }, delay, period);
    }
    
    
    static public int getGrade() {
        return grade;
    }
    
    void parseSoal(int nomor) {
        lblNSoal.setText("Soal ke-"+(nomor+1));
        lblSoal.setText(soal[nomor]);
        lblPoint.setText("Total Point : " + grade);
        //lblKunci.setText("Kunci : " + arr[nomor][2]);
    }
    
    void checkJawaban() {
        if(txtJawaban.getText().length()==0){
            txtJawaban.setText("0");
        }
        if (arr[currentSoal][2] == Integer.parseInt(txtJawaban.getText())) {
            grade++;
        }
        goToNextSoal();
        waktu=11;
        waktu--;
    }
    
    void goToNextSoal() {
        if (currentSoal < JUMLAH_SOAL - 1) {
            txtJawaban.requestFocus();
            txtJawaban.setText(null);
            currentSoal++;
            parseSoal(currentSoal);
        } else {
            currentSoal=0;
            Done done = new Done();
            done.show();
            this.dispose();
            
        }
    }
    
    void createSoal() {
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 5 + (int)(Math.random() * 15);
            arr[i][1] = 5 + (int)(Math.random() * 15);
            switch (i) {
                case 0:
                    arr[i][2] = mat.tambah(arr[i][0], arr[i][1]);
                    soal[i] = arr[i][0] + " + " + arr[i][1] + " ? ";
                    break;
                case 1:
                    if (arr[i][0] < arr[i][1]) {
                        temp = arr[i][0];
                        arr[i][0] = arr[i][1];
                        arr[i][1] = temp;
                    }
                    arr[i][2] = mat.kurang(arr[i][0], arr[i][1]);
                    soal[i] = arr[i][0] + " - " + arr[i][1] + " ? ";
                    break;
                case 2:
                case 8:
                    arr[i][2] = mat.kali(arr[i][0], arr[i][1]);
                    soal[i] = arr[i][0] + " x " + arr[i][1] + " ? ";
                    break;
                case 3:
                case 7:
                    arr[i][2] = mat.kali(arr[i][0], arr[i][1]);
                    temp = arr[i][0];
                    arr[i][0] = arr[i][2];
                    arr[i][2] = temp; // Pembagian
                    soal[i] = arr[i][0] + " : " + arr[i][1] + " ? ";
                    break;
                case 4:
                    arr[i][2] = mat.kelilingPersegPanjang(arr[i][0], arr[i][1]);
                    soal[i] = "Keliling persegi panjang dengan P = " + arr[i][0] + " dan L = " + arr[i][1] + "? ";
                    break;
                case 5:
                    arr[i][2] = mat.kali(arr[i][0], arr[i][1]);
                    soal[i] = "Luas persegi panjang dengan P = " + arr[i][0] + " dan L = " + arr[i][1] + "? ";
                    break;
                case 6:
                case 9:
                    arr[i][0] = 4 + (int)(Math.random() * 10) * 2;
                    arr[i][1] = 4 + (int)(Math.random() * 10) * 2;
                    arr[i][2] = mat.luasSegitiga(arr[i][0], arr[i][1]); // Luas Segitiga
                    soal[i] = "Luas Segitiga dengan Alas = " + arr[i][0] + " dan Tinggi = " + arr[i][1] + "? ";
                    break;
                default:
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSoal = new javax.swing.JLabel();
        txtJawaban = new javax.swing.JTextField();
        btnJawab = new javax.swing.JButton();
        lblPoint = new javax.swing.JLabel();
        jLabelWaktu = new javax.swing.JLabel();
        lblNSoal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSoal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSoal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoal.setText("jLabel1");

        txtJawaban.setName("txtJawaban"); // NOI18N
        txtJawaban.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJawabanKeyPressed(evt);
            }
        });

        btnJawab.setText("Submit");
        btnJawab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJawabSubmit(evt);
            }
        });

        lblPoint.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPoint.setText("jLabel1");

        jLabelWaktu.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelWaktu.setForeground(new java.awt.Color(206, 36, 36));

        lblNSoal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNSoal.setText("Soal Ke -");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSoal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPoint))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(lblNSoal)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(txtJawaban, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 115, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(btnJawab)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPoint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNSoal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lblSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJawaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnJawab)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 1, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJawabSubmit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJawabSubmit
        checkJawaban();
    }//GEN-LAST:event_btnJawabSubmit

    private void txtJawabanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJawabanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            checkJawaban();
        }
    }//GEN-LAST:event_txtJawabanKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MathQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MathQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MathQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MathQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MathQuiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJawab;
    private javax.swing.JLabel jLabelWaktu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNSoal;
    private javax.swing.JLabel lblPoint;
    private javax.swing.JLabel lblSoal;
    private javax.swing.JTextField txtJawaban;
    // End of variables declaration//GEN-END:variables
}
