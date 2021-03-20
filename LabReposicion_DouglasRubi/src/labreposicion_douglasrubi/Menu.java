/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labreposicion_douglasrubi;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor Jafet Cruz
 */
public class Menu extends javax.swing.JFrame {
    private int Id = -1;
    SuperBinario superb = new SuperBinario("./Super_Hack.txt");
    RegularBinario Regularb = new RegularBinario("./Hack_Regular.txt");
    public ArrayList <Hack_Regular> regular = new ArrayList();
    public ArrayList <Super_Hack> superhack = new ArrayList();
    
    public Menu() {
        initComponents();
        setExtendedState(Menu.MAXIMIZED_BOTH);
        setTitle("LOG IN WINDOWS 10");
        setIconImage(new ImageIcon(getClass().getResource("/Images/FondoW.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Images/Progra.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        
        
        
        JTablaRegular.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo", "Nivel de Riesgo", "Hacks Exitosos"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        JTablaRegular.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // jTable1.getSelectedRow()
                if(JTablaRegular.getSelectedRow()<0) return;
                Id = JTablaRegular.getSelectedRow();
            }

        });
        JTablaRegular.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                   "Codigo", "Nivel de Riesgo", "Hacks Exitosos"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        
        JTableSuper.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo", "Nivel de Riesgo", "Hacks Fallidos"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        JTableSuper.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // jTable1.getSelectedRow()
                if(JTableSuper.getSelectedRow()<0) return;
               Id = JTableSuper.getSelectedRow();
            }

        });
        JTableSuper.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                     "Codigo", "Nivel de Riesgo", "Hacks Fallidos"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        recargarTablaRegular(JTablaRegular);
       recargarTablaSuper(JTableSuper);
    }
    private int Puntuacion = -1;
    private int Puntuacion1 = -1;
     //Vaciar tabla para limpiar la tabla
        public void vaciarTablaRegular(JTable tabla){
        DefaultTableModel Modelo = (DefaultTableModel) JTablaRegular.getModel();
        String titulos[] =  new String[]{
                            "Codigo", "Nivel de Riesgo", "Hacks Exitosos"
                        };
        Modelo = new DefaultTableModel(null,titulos);
        //tabla.setSelectionMode(0);
        tabla.setModel(Modelo);

    }
    //Recargar tabla para capturar los datos de las tablas
    private void recargarTablaRegular(JTable tabla){
        vaciarTablaRegular(tabla);
         // Usuarios us = new Usuarios();
                for (Hack_Regular HackR : regular) {
                    Object row[] = {HackR.getCodigo(), HackR.getNivelRiesgo(), HackR.getHacksExitosos()};
                    DefaultTableModel m =
                            (DefaultTableModel) tabla.getModel();
                    m.addRow(row);
                    tabla.setModel(m);
                }//fin for
        
    }
     //Vaciar tabla para limpiar la tabla
        public void vaciarTablaSuper(JTable tabla){
        DefaultTableModel Modelo = (DefaultTableModel) JTableSuper.getModel();
        String titulos[] =  new String[]{
                            "Codigo", "Nivel de Riesgo", "Hacks Fallidos"
                        };
        Modelo = new DefaultTableModel(null,titulos);
        //tabla.setSelectionMode(0);
        tabla.setModel(Modelo);

    }
    //Recargar tabla para capturar los datos de las tablas
    private void recargarTablaSuper(JTable tabla){
        vaciarTablaRegular(tabla);
         // Usuarios us = new Usuarios();
                for (Super_Hack HackS : superhack) {
                    Object row[] = {HackS.getCodigo(), HackS.getNivelRiesgo(), HackS.getHacksFallidos()};
                    DefaultTableModel m =
                            (DefaultTableModel) tabla.getModel();
                    m.addRow(row);
                    tabla.setModel(m);
                }//fin for
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JD_CrearHackeoRegular = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtExitosos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTablaRegular = new javax.swing.JTable();
        jbGuardarR = new javax.swing.JButton();
        jSpinerRiesgoR = new javax.swing.JSpinner();
        jbModificar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JD_CrearSuperHackeo = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoS = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFallidos = new javax.swing.JTextField();
        jbGuardarS = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTableSuper = new javax.swing.JTable();
        JSpinnerRiesgoS = new javax.swing.JSpinner();
        jButton4 = new javax.swing.JButton();
        jbModificar1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        JD_Simulacion = new javax.swing.JDialog();
        jLabel21 = new javax.swing.JLabel();
        CB_NaveSimulacion = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        JL_Tripulantes = new javax.swing.JList<>();
        JB_Agregar = new javax.swing.JButton();
        JB_Avanzar = new javax.swing.JButton();
        pg_c = new javax.swing.JProgressBar();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        JB_Detener = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        sp_consumo = new javax.swing.JSpinner();
        sp_v = new javax.swing.JSpinner();
        pg_c1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JB_CrearDestino = new javax.swing.JButton();
        JB_CrearNave = new javax.swing.JButton();
        JB_Simulacion = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel1.setText("Codigo:");

        txtCodigo.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N

        txtExitosos.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel6.setText("Nivel de Riesgo:");

        jLabel8.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel8.setText("Hackeos Exitosos:");

        JTablaRegular.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(JTablaRegular);

        jbGuardarR.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jbGuardarR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labreposicion_douglasrubi/entrar.png"))); // NOI18N
        jbGuardarR.setText("Guardar");
        jbGuardarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarRActionPerformed(evt);
            }
        });

        jSpinerRiesgoR.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jSpinerRiesgoR.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jSpinerRiesgoR.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinerRiesgoRStateChanged(evt);
            }
        });

        jbModificar.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jbModificar.setForeground(new java.awt.Color(0, 204, 0));
        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 0));
        jButton2.setText("Eliminar");

        jButton3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labreposicion_douglasrubi/cancelar.png"))); // NOI18N
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JD_CrearHackeoRegularLayout = new javax.swing.GroupLayout(JD_CrearHackeoRegular.getContentPane());
        JD_CrearHackeoRegular.getContentPane().setLayout(JD_CrearHackeoRegularLayout);
        JD_CrearHackeoRegularLayout.setHorizontalGroup(
            JD_CrearHackeoRegularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JD_CrearHackeoRegularLayout.createSequentialGroup()
                .addGroup(JD_CrearHackeoRegularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JD_CrearHackeoRegularLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(JD_CrearHackeoRegularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(29, 29, 29)
                        .addGroup(JD_CrearHackeoRegularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtExitosos)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jSpinerRiesgoR)))
                    .addGroup(JD_CrearHackeoRegularLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jbGuardarR)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addGroup(JD_CrearHackeoRegularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JD_CrearHackeoRegularLayout.createSequentialGroup()
                        .addComponent(jbModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
            .addGroup(JD_CrearHackeoRegularLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JD_CrearHackeoRegularLayout.setVerticalGroup(
            JD_CrearHackeoRegularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_CrearHackeoRegularLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(58, 58, 58)
                .addGroup(JD_CrearHackeoRegularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JD_CrearHackeoRegularLayout.createSequentialGroup()
                        .addGroup(JD_CrearHackeoRegularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(JD_CrearHackeoRegularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinerRiesgoR))
                        .addGap(34, 34, 34)
                        .addGroup(JD_CrearHackeoRegularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtExitosos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(jbGuardarR)))
                .addGap(47, 47, 47)
                .addGroup(JD_CrearHackeoRegularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar)
                    .addComponent(jButton2))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel2.setText("Codigo:");

        txtCodigoS.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel7.setText("Nivel de Riesgo:");

        jLabel9.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel9.setText("Hackeos Fallidos:");

        txtFallidos.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N

        jbGuardarS.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jbGuardarS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labreposicion_douglasrubi/entrar.png"))); // NOI18N
        jbGuardarS.setText("Guardar");
        jbGuardarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarSActionPerformed(evt);
            }
        });

        JTableSuper.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(JTableSuper);

        JSpinnerRiesgoS.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        JSpinnerRiesgoS.setModel(new javax.swing.SpinnerNumberModel(6, 6, 10, 1));
        JSpinnerRiesgoS.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                JSpinnerRiesgoSStateChanged(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labreposicion_douglasrubi/cancelar.png"))); // NOI18N
        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jbModificar1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jbModificar1.setForeground(new java.awt.Color(0, 204, 0));
        jbModificar1.setText("Modificar");
        jbModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificar1ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 204, 0));
        jButton5.setText("Eliminar");

        javax.swing.GroupLayout JD_CrearSuperHackeoLayout = new javax.swing.GroupLayout(JD_CrearSuperHackeo.getContentPane());
        JD_CrearSuperHackeo.getContentPane().setLayout(JD_CrearSuperHackeoLayout);
        JD_CrearSuperHackeoLayout.setHorizontalGroup(
            JD_CrearSuperHackeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_CrearSuperHackeoLayout.createSequentialGroup()
                .addGroup(JD_CrearSuperHackeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JD_CrearSuperHackeoLayout.createSequentialGroup()
                        .addGroup(JD_CrearSuperHackeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JD_CrearSuperHackeoLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(JD_CrearSuperHackeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2))
                                .addGap(29, 29, 29)
                                .addGroup(JD_CrearSuperHackeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFallidos, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(txtCodigoS, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(JSpinnerRiesgoS)))
                            .addGroup(JD_CrearSuperHackeoLayout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jbGuardarS)))
                        .addGap(185, 185, 185)
                        .addGroup(JD_CrearSuperHackeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(JD_CrearSuperHackeoLayout.createSequentialGroup()
                                .addComponent(jbModificar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JD_CrearSuperHackeoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        JD_CrearSuperHackeoLayout.setVerticalGroup(
            JD_CrearSuperHackeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_CrearSuperHackeoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JD_CrearSuperHackeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JD_CrearSuperHackeoLayout.createSequentialGroup()
                        .addGroup(JD_CrearSuperHackeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCodigoS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(JD_CrearSuperHackeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JSpinnerRiesgoS))
                        .addGap(34, 34, 34)
                        .addGroup(JD_CrearSuperHackeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtFallidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(jbGuardarS))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(JD_CrearSuperHackeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar1)
                    .addComponent(jButton5))
                .addContainerGap(266, Short.MAX_VALUE))
        );

        jLabel21.setText("Nave");

        JL_Tripulantes.setModel(new DefaultListModel());
        jScrollPane4.setViewportView(JL_Tripulantes);

        JB_Agregar.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        JB_Agregar.setText("Agregar");
        JB_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AgregarActionPerformed(evt);
            }
        });

        JB_Avanzar.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        JB_Avanzar.setText("Avanzar");
        JB_Avanzar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_AvanzarMouseClicked(evt);
            }
        });
        JB_Avanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AvanzarActionPerformed(evt);
            }
        });

        pg_c.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        pg_c.setForeground(new java.awt.Color(0, 204, 0));
        pg_c.setMaximum(50);
        pg_c.setValue(50);
        pg_c.setStringPainted(true);

        jLabel29.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel29.setText("Hackeo Regular:");

        jLabel31.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel31.setText("Super Hackeo:");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton1.setText("Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JB_Detener.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        JB_Detener.setText("Detener");
        JB_Detener.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JB_DetenerMouseClicked(evt);
            }
        });
        JB_Detener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_DetenerActionPerformed(evt);
            }
        });

        jLabel25.setText("KM/H");

        jLabel26.setText("Velocidad");

        jLabel27.setText("KM/L");

        jLabel28.setText("Consumo");

        pg_c1.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        pg_c1.setForeground(new java.awt.Color(0, 204, 0));
        pg_c1.setMaximum(50);
        pg_c1.setValue(50);
        pg_c1.setStringPainted(true);

        javax.swing.GroupLayout JD_SimulacionLayout = new javax.swing.GroupLayout(JD_Simulacion.getContentPane());
        JD_Simulacion.getContentPane().setLayout(JD_SimulacionLayout);
        JD_SimulacionLayout.setHorizontalGroup(
            JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_SimulacionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JD_SimulacionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(CB_NaveSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220))
                    .addGroup(JD_SimulacionLayout.createSequentialGroup()
                        .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(JD_SimulacionLayout.createSequentialGroup()
                                    .addGap(277, 277, 277)
                                    .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel28))
                                    .addGap(46, 46, 46)
                                    .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(sp_v, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sp_consumo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(48, 48, 48)
                                    .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel27)))
                                .addGroup(JD_SimulacionLayout.createSequentialGroup()
                                    .addComponent(jLabel31)
                                    .addGap(28, 28, 28)
                                    .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(pg_c, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pg_c1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JD_SimulacionLayout.createSequentialGroup()
                                            .addComponent(JB_Avanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JB_Detener, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(JD_SimulacionLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(447, 447, 447)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)))
                .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JD_SimulacionLayout.createSequentialGroup()
                        .addComponent(JB_Agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124))
        );
        JD_SimulacionLayout.setVerticalGroup(
            JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_SimulacionLayout.createSequentialGroup()
                .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JD_SimulacionLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CB_NaveSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(37, 37, 37)
                        .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(sp_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(sp_consumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JD_SimulacionLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JB_Agregar)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(pg_c, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(pg_c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(JD_SimulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Avanzar)
                    .addComponent(JB_Detener))
                .addGap(75, 75, 75))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Mongolian Baiti", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 204));
        jLabel3.setText("BIENVENIDOS AL SISTEMA DE SIMULACION  DE HACKEO A LA BASE DE DATOS ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        JB_CrearDestino.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        JB_CrearDestino.setText("Adminstrar Super Hackeo");
        JB_CrearDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CrearDestinoActionPerformed(evt);
            }
        });

        JB_CrearNave.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        JB_CrearNave.setText("Administrar Hackeo Regular");
        JB_CrearNave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CrearNaveActionPerformed(evt);
            }
        });

        JB_Simulacion.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        JB_Simulacion.setText("Simulacion");
        JB_Simulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_SimulacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addComponent(JB_Simulacion))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(JB_CrearNave))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(JB_CrearDestino)))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(JB_CrearDestino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(JB_CrearNave)
                .addGap(63, 63, 63)
                .addComponent(JB_Simulacion)
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(429, 429, 429)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_CrearNaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CrearNaveActionPerformed

       RegularBinario Regularb = new RegularBinario("./Hack_Regular.txt");
       Regularb.cargarArchivoUsuario();      
       HackeoRegular();
       
       
        
    }//GEN-LAST:event_JB_CrearNaveActionPerformed

    private void JB_SimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_SimulacionActionPerformed
  
        Simulacion();
    }//GEN-LAST:event_JB_SimulacionActionPerformed

    private void JB_DetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_DetenerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JB_DetenerActionPerformed

    private void JB_DetenerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_DetenerMouseClicked
/*
        HT.setAvanzar(false);
        HD.setAvanzar(false);
        HC.setAvanzar(false);
*/
    }//GEN-LAST:event_JB_DetenerMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void JB_AvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AvanzarActionPerformed

    }//GEN-LAST:event_JB_AvanzarActionPerformed

    private void JB_AvanzarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JB_AvanzarMouseClicked

       /* try { //por si ya esta iniciado
            Nave nave = (Nave) CB_NaveSimulacion.getSelectedItem();
            HT = new administrarTiempo(this.pg_t);
            HD = new administrarDistancia(pg_t, pg_d, sp_v);
            HC = new administrarCombustible(pg_c, pg_d, sp_consumo);

            HT.start();
            HD.start();
            HC.start();

        } catch (Exception e) {

        }
        HT.setAvanzar(true);
        HD.setAvanzar(true);
        HC.setAvanzar(true);
*/
    }//GEN-LAST:event_JB_AvanzarMouseClicked

    private void JB_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AgregarActionPerformed
      /*  DefaultComboBoxModel model_combo = (DefaultComboBoxModel) CB_AstronautasSimulacion.getModel();
        DefaultListModel model_lista = (DefaultListModel) JL_Tripulantes.getModel();
        Astronautas astro = (Astronautas) CB_AstronautasSimulacion.getSelectedItem();
        model_lista.addElement(astro);
        JL_Tripulantes.setModel(model_lista);*/
    }//GEN-LAST:event_JB_AgregarActionPerformed

    private void JB_CrearDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CrearDestinoActionPerformed
     SuperHackeo();
        /*  try {
            AdminDestino admi = new AdminDestino("./DestinoInfo.vjcm");
            admi.cargarArchivo();
            DefaultComboBoxModel model = new DefaultComboBoxModel(admi.getListaDestino().toArray());
            CB_Destino.setModel(model);
            SuperHackeo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR");
        }*/
    }//GEN-LAST:event_JB_CrearDestinoActionPerformed

    private void jbGuardarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarSActionPerformed
          this.Puntuacion =  (Integer) JSpinnerRiesgoS.getValue();  
          boolean valido = true;
          if (this.txtCodigoS.getText() == null || "".equals(this.txtCodigoS.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese el Codigo: ");
            valido = false;       
          }
          if (this.Puntuacion == -1 || "".equals(this.Puntuacion)) {
            JOptionPane.showConfirmDialog(this, "Ingrese la puntuacion: ");
            valido = false;       
          }
          if (this.txtFallidos.getText() == null || "".equals(this.txtFallidos.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese las misiones fallidas: ");
            valido = false; 
          }
          if (valido && this.Id<0) {
          Super_Hack hacks = new Super_Hack(Integer.parseInt(txtCodigoS.getText()),this.Puntuacion,Integer.parseInt(txtFallidos.getText()));
          superb.cargarArchivoUsuario();
          superb.getHacks().add(hacks);
          superb.escribirArchivoUsuario();
          vaciarTablaSuper(JTableSuper);
            recargarTablaSuper(JTableSuper);
            JOptionPane.showMessageDialog(this, "Se agrego correctamente");
        }else{
           JOptionPane.showMessageDialog(this, "Hubo un error y no se agrego");
            }
    }//GEN-LAST:event_jbGuardarSActionPerformed

    private void JSpinnerRiesgoSStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_JSpinnerRiesgoSStateChanged
       if (evt.getSource() == JSpinnerRiesgoS) {
            int seleccionado =(Integer)JSpinnerRiesgoS.getValue();
            this.Puntuacion = seleccionado;
        }
    }//GEN-LAST:event_JSpinnerRiesgoSStateChanged

    private void jSpinerRiesgoRStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinerRiesgoRStateChanged
        if (evt.getSource() == jSpinerRiesgoR) {
            int seleccionado =(Integer)jSpinerRiesgoR.getValue();
            this.Puntuacion1 = seleccionado;
        }
    }//GEN-LAST:event_jSpinerRiesgoRStateChanged

    private void jbGuardarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarRActionPerformed
         this.Puntuacion1 =  (Integer) jSpinerRiesgoR.getValue();  
          boolean valido = true;
          if (this.txtCodigo.getText() == null || "".equals(this.txtCodigo.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese el Codigo: ");
            valido = false;       
          }
          if (this.Puntuacion1 == -1 || "".equals(this.Puntuacion1)) {
            JOptionPane.showConfirmDialog(this, "Ingrese la puntuacion: ");
            valido = false;       
          }
          if (this.txtExitosos.getText() == null || "".equals(this.txtExitosos.getText())) {
            JOptionPane.showConfirmDialog(this, "Ingrese las misiones Exitosas: ");
            valido = false; 
          }
          if (valido && this.Id<0) {
          Hack_Regular hackr = new Hack_Regular(Integer.parseInt(txtCodigoS.getText()),this.Puntuacion,Integer.parseInt(txtExitosos.getText()));
          Regularb.cargarArchivoUsuario();
          Regularb.getHacks().add(hackr);
          Regularb.escribirArchivoUsuario();
          vaciarTablaRegular(JTablaRegular);
            recargarTablaRegular(JTablaRegular);
            JOptionPane.showMessageDialog(this, "Se agrego correctamente");
        }else{
           JOptionPane.showMessageDialog(this, "Hubo un error y no se agrego");
            }
    }//GEN-LAST:event_jbGuardarRActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jbModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbModificar1ActionPerformed
   
    
    
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    public void HackeoRegular() {
        JD_CrearHackeoRegular.pack();
        JD_CrearHackeoRegular.setModal(true);
        JD_CrearHackeoRegular.setLocationRelativeTo(this);
        JD_CrearHackeoRegular.setVisible(true);
    }//fin del llamado del JDialog
         
      
      public void SuperHackeo() {
        JD_CrearSuperHackeo.pack();
        JD_CrearSuperHackeo.setModal(true);
        JD_CrearSuperHackeo.setLocationRelativeTo(this);
        JD_CrearSuperHackeo.setVisible(true);
        
    }//fin del llamado del JDialog
      
      public void Simulacion() {
        JD_Simulacion.pack();
        JD_Simulacion.setModal(true);
        JD_Simulacion.setLocationRelativeTo(this);
        JD_Simulacion.setVisible(true);
        
    }//fin del llamado del JDialog
      
      
      
      
    
    
   /* administrarCombustible HC; 
    administrarTiempo HT; 
    administrarDistancia HD; */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_NaveSimulacion;
    private javax.swing.JButton JB_Agregar;
    private javax.swing.JButton JB_Avanzar;
    private javax.swing.JButton JB_CrearDestino;
    private javax.swing.JButton JB_CrearNave;
    private javax.swing.JButton JB_Detener;
    private javax.swing.JButton JB_Simulacion;
    private javax.swing.JDialog JD_CrearHackeoRegular;
    private javax.swing.JDialog JD_CrearSuperHackeo;
    private javax.swing.JDialog JD_Simulacion;
    private javax.swing.JList<String> JL_Tripulantes;
    private javax.swing.JSpinner JSpinnerRiesgoS;
    private javax.swing.JTable JTablaRegular;
    private javax.swing.JTable JTableSuper;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinerRiesgoR;
    private javax.swing.JButton jbGuardarR;
    private javax.swing.JButton jbGuardarS;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbModificar1;
    private javax.swing.JProgressBar pg_c;
    private javax.swing.JProgressBar pg_c1;
    private javax.swing.JSpinner sp_consumo;
    private javax.swing.JSpinner sp_v;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoS;
    private javax.swing.JTextField txtExitosos;
    private javax.swing.JTextField txtFallidos;
    // End of variables declaration//GEN-END:variables
  
}
