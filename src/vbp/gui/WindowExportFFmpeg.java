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

/**
 *
 * @author Sebastian Straub <sebastian-straub@gmx.net>
 */
public class WindowExportFFmpeg extends javax.swing.JDialog implements Saveable {

    /** Creates new form WindowExportFFmpeg */
    public WindowExportFFmpeg(java.awt.Frame parent) {
        super(parent, "Export to FFmpeg", true);
        initComponents();
    }
    
    public void updateModelValues() {
        // TODO implement
    }

    public void updateGuiValues() {
        // TODO implement
    }

    public void safeExit() {
        updateModelValues();
        this.dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxChooseOs = new javax.swing.JComboBox();
        jLabelChooseOs = new javax.swing.JLabel();
        jButtonBrowsePath = new javax.swing.JButton();
        jTextFieldFFmpegPath = new javax.swing.JTextField();
        jLabelFFmpegPath = new javax.swing.JLabel();
        jButtonSaveScript = new javax.swing.JButton();
        jButtonExecuteNow = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jLabelFFmpegCommand = new javax.swing.JLabel();
        jScrollPanelFFmpeg = new javax.swing.JScrollPane();
        jTextPaneFFmpeg = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(450, 230));

        jComboBoxChooseOs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Windows (*.bat)", "Linux (*.sh)" }));
        jComboBoxChooseOs.setEnabled(false);

        jLabelChooseOs.setText("Choose your Operating System:");

        jButtonBrowsePath.setText("Browse");
        jButtonBrowsePath.setEnabled(false);

        jTextFieldFFmpegPath.setEnabled(false);

        jLabelFFmpegPath.setText("Path to ffmpeg (optional):");

        jButtonSaveScript.setText("Save Script...");
        jButtonSaveScript.setEnabled(false);

        jButtonExecuteNow.setText("Execute Now");
        jButtonExecuteNow.setEnabled(false);

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jLabelFFmpegCommand.setText("FFmpeg Command Line:");

        jTextPaneFFmpeg.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jScrollPanelFFmpeg.setViewportView(jTextPaneFFmpeg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanelFFmpeg, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelChooseOs)
                            .addComponent(jLabelFFmpegPath))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldFFmpegPath, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBrowsePath))
                            .addComponent(jComboBoxChooseOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelFFmpegCommand)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSaveScript)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExecuteNow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                        .addComponent(jButtonClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChooseOs)
                    .addComponent(jComboBoxChooseOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFFmpegPath)
                    .addComponent(jTextFieldFFmpegPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBrowsePath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFFmpegCommand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPanelFFmpeg, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveScript)
                    .addComponent(jButtonExecuteNow)
                    .addComponent(jButtonClose))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        safeExit();
    }//GEN-LAST:event_jButtonCloseActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBrowsePath;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonExecuteNow;
    private javax.swing.JButton jButtonSaveScript;
    private javax.swing.JComboBox jComboBoxChooseOs;
    private javax.swing.JLabel jLabelChooseOs;
    private javax.swing.JLabel jLabelFFmpegCommand;
    private javax.swing.JLabel jLabelFFmpegPath;
    private javax.swing.JScrollPane jScrollPanelFFmpeg;
    private javax.swing.JTextField jTextFieldFFmpegPath;
    private javax.swing.JTextPane jTextPaneFFmpeg;
    // End of variables declaration//GEN-END:variables
}
