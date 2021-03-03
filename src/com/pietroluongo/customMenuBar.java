package com.pietroluongo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customMenuBar extends JMenuBar {
    public customMenuBar() {
        JMenu fileMenu = new JMenu("Arquivo");
        JMenu editMenu = new JMenu("Editar");
        JMenu helpMenu = new JMenu("Ajuda");

        JMenuItem exitAction = new JMenuItem("Sair");

        JMenuItem classesAction = new JMenuItem("Informações das Turmas");
        JMenuItem prefAction = new JMenuItem("Preferências");

        JMenuItem tutorialAction = new JMenuItem("Como usar");
        JMenuItem aboutAction = new JMenuItem("Sobre");

        this.add(fileMenu);
        this.add(editMenu);
        this.add(helpMenu);

        fileMenu.add(exitAction);

        editMenu.add(classesAction);
        editMenu.add(prefAction);

        helpMenu.add(tutorialAction);
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

        tutorialAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                howToUseGuide tutorial = new howToUseGuide();
                tutorial.setVisible(true);

            }
        });
    }
}
