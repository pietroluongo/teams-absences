package com.pietroluongo;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JFrame {
    private JButton btn_processData;
    private JLabel label_pathToCSVs;
    private JTextField text_pathToCSVs;
    private JPanel mainPanel;
    private JLabel label_profName;
    private JTextField text_profName;
    private JTextField text_StudentsPath;
    private JLabel label_StudentsPath;
    private JButton btn_StudentsPathLoad;
    private JCheckBox check_SaveData;
    private JMenuBar menuBar;

    public mainForm() {
        super("Processamento de Faltas");
        //this.setSize(800, 600);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setJMenuBar(new customMenuBar());
        this.setVisible(true);

        JFrame self = this;
        //btn_pathToCSVsLoad = new fileFolderPickerButton(this, text_pathToCSVs);
        btn_processData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int ret = fc.showOpenDialog(self);
                if(ret == JFileChooser.APPROVE_OPTION) {
                    text_pathToCSVs.setText(fc.getSelectedFile().getAbsolutePath());
                }
            }
        });

        btn_StudentsPathLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(new FileNameExtensionFilter("Arquivos CSV", "csv"));
                int ret = fc.showOpenDialog(self);
                if(ret == JFileChooser.APPROVE_OPTION) {
                    text_StudentsPath.setText(fc.getSelectedFile().getAbsolutePath());
                }
            }
        });
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new mainForm();
            }
        });
    }

}
