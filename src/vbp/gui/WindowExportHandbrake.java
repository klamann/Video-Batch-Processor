/*
 * Copyright (C) 2011 Sebastian Straub <sebastian-straub@gmx.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * WindowExportFFmpeg.java
 *
 * Created on 22.10.2011, 00:11:11
 */
package vbp.gui;

import sebi.util.observer.Event;
import sebi.util.threads.ThreadedExecutor;
import vbp.model.Model;

/**
 *
 * @author Sebastian Straub <sebastian-straub@gmx.net>
 */
public class WindowExportHandbrake extends javax.swing.JDialog implements Saveable {

    protected Model model;
    
    /**
     * Creates new form WindowExportFFmpeg
     * @param parent parent Frame
     */
    public WindowExportHandbrake(java.awt.Frame parent, Model model) {
        super(parent, "Export to Handbrake", true);
        this.model = model;
        
        initComponents();
        setInitialValues();
    }
    
    // <editor-fold desc="GUI manipulation">
    
    private void setInitialValues() {
        jTextPaneHandbrakeQuery.setText(model.getHandBrakeQuery());
    }
    
    
    @Override
    public void updateModelValues() {
        model.setHandBrakeQuery(jTextPaneHandbrakeQuery.getText());
    }
    
    @Override
    public void updateGuiValues() {
        setInitialValues();
    }
    
    // </editor-fold>
    // <editor-fold desc="GUI Actions">
    
    protected void saveHandbrakeQueue() {
        new ThreadedExecutor() {

            @Override
            public void execute() {
                updateModelValues.fire();
                model.exportToHandbrake(jFileChooserExportHandbrake);
            }
        }.start();
    }
    
    @Override
    public void safeExit() {
        updateModelValues();
        this.dispose();
    }
    
    // </editor-fold>
    // <editor-fold desc="Events">
    
    protected Event updateModelValues = new Event();
    
    public Event eventUpdateModelValues() {
        return updateModelValues;
    }
    
    // </editor-fold>
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserExportHandbrake = new javax.swing.JFileChooser();
        jComboBoxOsChooser = new javax.swing.JComboBox();
        jLabelChooseOs = new javax.swing.JLabel();
        jButtonPathToCliBrowse = new javax.swing.JButton();
        jTextFieldPathToCli = new javax.swing.JTextField();
        jLabelPathToCli = new javax.swing.JLabel();
        jButtonSaveQueue = new javax.swing.JButton();
        jButtonExecuteQueue = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jPanelHandbrakeQuery = new javax.swing.JPanel();
        jLabellHandbrakeQuery = new javax.swing.JLabel();
        jButtonHandbrakeQueryHelp = new javax.swing.JButton();
        jScrollPanelHandbrakeQuery = new javax.swing.JScrollPane();
        jTextPaneHandbrakeQuery = new javax.swing.JTextPane();

        jFileChooserExportHandbrake.setDialogTitle("Save as Handbrake-Queue");
        jFileChooserExportHandbrake.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFileChooserExportHandbrake.setFileFilter(FileFilters.handbrakeQueueFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(500, 285));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jComboBoxOsChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Windows", "Linux", "Mac" }));
        jComboBoxOsChooser.setEnabled(false);

        jLabelChooseOs.setText("Choose your Operating System:");

        jButtonPathToCliBrowse.setText("Browse");
        jButtonPathToCliBrowse.setEnabled(false);

        jTextFieldPathToCli.setEnabled(false);

        jLabelPathToCli.setText("Path to HandBrakeCLI.exe (optional)");

        jButtonSaveQueue.setText("Save Queue...");
        jButtonSaveQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveQueueActionPerformed(evt);
            }
        });

        jButtonExecuteQueue.setText("Execute Now");
        jButtonExecuteQueue.setEnabled(false);

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jPanelHandbrakeQuery.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter Handbrake-Query"));

        jLabellHandbrakeQuery.setText("<html>Enter your preferred transcoding-settings in Handbrake, generate a query for these and paste them in the textarea below. All files will be encoded with these settings</html>");

        jButtonHandbrakeQueryHelp.setForeground(new java.awt.Color(153, 153, 153));
        jButtonHandbrakeQueryHelp.setText("?");
        jButtonHandbrakeQueryHelp.setEnabled(false);

        jTextPaneHandbrakeQuery.setFont(new java.awt.Font("Tahoma", 0, 10));
        jTextPaneHandbrakeQuery.setText(" -o \"\"  -f mkv --strict-anamorphic  -e x264 -q 25 -a 1 -E lame -6 dpl2 -R Auto -B 128 -D 0.0 -x ref=2:bframes=2:subq=6:mixed-refs=0:weightb=0:8x8dct=0:trellis=0 --verbose=1");
        jScrollPanelHandbrakeQuery.setViewportView(jTextPaneHandbrakeQuery);

        javax.swing.GroupLayout jPanelHandbrakeQueryLayout = new javax.swing.GroupLayout(jPanelHandbrakeQuery);
        jPanelHandbrakeQuery.setLayout(jPanelHandbrakeQueryLayout);
        jPanelHandbrakeQueryLayout.setHorizontalGroup(
            jPanelHandbrakeQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHandbrakeQueryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHandbrakeQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabellHandbrakeQuery, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHandbrakeQueryLayout.createSequentialGroup()
                        .addComponent(jScrollPanelHandbrakeQuery, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonHandbrakeQueryHelp)))
                .addContainerGap())
        );
        jPanelHandbrakeQueryLayout.setVerticalGroup(
            jPanelHandbrakeQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHandbrakeQueryLayout.createSequentialGroup()
                .addComponent(jLabellHandbrakeQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHandbrakeQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonHandbrakeQueryHelp)
                    .addComponent(jScrollPanelHandbrakeQuery, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelHandbrakeQuery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChooseOs)
                            .addComponent(jLabelPathToCli))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextFieldPathToCli, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPathToCliBrowse))
                            .addComponent(jComboBoxOsChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSaveQueue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExecuteQueue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                        .addComponent(jButtonClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChooseOs)
                    .addComponent(jComboBoxOsChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPathToCli)
                    .addComponent(jTextFieldPathToCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPathToCliBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelHandbrakeQuery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveQueue)
                    .addComponent(jButtonExecuteQueue)
                    .addComponent(jButtonClose))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        safeExit();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonSaveQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveQueueActionPerformed
        saveHandbrakeQueue();
    }//GEN-LAST:event_jButtonSaveQueueActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        safeExit();
    }//GEN-LAST:event_formWindowClosing
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonExecuteQueue;
    private javax.swing.JButton jButtonHandbrakeQueryHelp;
    private javax.swing.JButton jButtonPathToCliBrowse;
    private javax.swing.JButton jButtonSaveQueue;
    private javax.swing.JComboBox jComboBoxOsChooser;
    private javax.swing.JFileChooser jFileChooserExportHandbrake;
    private javax.swing.JLabel jLabelChooseOs;
    private javax.swing.JLabel jLabelPathToCli;
    private javax.swing.JLabel jLabellHandbrakeQuery;
    private javax.swing.JPanel jPanelHandbrakeQuery;
    private javax.swing.JScrollPane jScrollPanelHandbrakeQuery;
    private javax.swing.JTextField jTextFieldPathToCli;
    private javax.swing.JTextPane jTextPaneHandbrakeQuery;
    // End of variables declaration//GEN-END:variables
}
