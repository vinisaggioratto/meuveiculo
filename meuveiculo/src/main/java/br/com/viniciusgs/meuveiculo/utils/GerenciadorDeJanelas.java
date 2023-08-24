/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.viniciusgs.meuveiculo.utils;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author FROTA01-PC
 */
public class GerenciadorDeJanelas {
    private static JDesktopPane jDesktopPane;

    public GerenciadorDeJanelas() {

    }

    public void abrirJanelas(JInternalFrame jInternalFrame) {

        if (jInternalFrame.isVisible()) {
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        } else {
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setVisible(true);
            setPosicao(jInternalFrame);
        }

    }

    public void setPosicao(JInternalFrame jInternalFrame) {
        Dimension d = jInternalFrame.getDesktopPane().getSize();
        jInternalFrame.setLocation((d.width - jInternalFrame.getSize().width) / 2,
                (d.height - jInternalFrame.getSize().height) / 2);
    }
}
