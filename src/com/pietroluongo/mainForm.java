package com.pietroluongo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JFrame {
    private JButton btn_processData;
    private JLabel label_pathToCSVs;
    private JTextField text_pathToCSVs;
    private JPanel mainPanel;
    private JLabel label_profName;
    private JTextField text_profName;
    private JMenuBar menuBar;

    public mainForm() {
        super("Processamento de Faltas");
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setContentPane(mainPanel);
        generateMenuBar();
        btn_processData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hemlo");
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int ret = fc.showOpenDialog(null);
                if(ret == JFileChooser.APPROVE_OPTION) {
                    text_pathToCSVs.setText(fc.getSelectedFile().getAbsolutePath());
                }
            }
        });
    }

    private void generateMenuBar() {
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Arquivo");
        JMenu editMenu = new JMenu("Editar");
        JMenu helpMenu = new JMenu("Ajuda");


        JMenuItem exitAction = new JMenuItem("Sair");
        JMenuItem aboutAction = new JMenuItem("Sobre");


        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        fileMenu.add(exitAction);
        helpMenu.add(aboutAction);

        exitAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        aboutAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Desenvolvido por Gabriel Pietroluongo");
            }
        });

    }

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        JFrame frame = new mainForm();
    }

}
