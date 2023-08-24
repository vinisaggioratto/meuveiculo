/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.viniciusgs.meuveiculo.tables;

import br.com.viniciusgs.meuveiculo.entity.Pais;
import br.com.viniciusgs.meuveiculo.view.TelaPaisConsulta;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FROTA01-PC
 */
public class TabelaPaisConsulta {
    TelaPaisConsulta telaPaisConsulta = null;
    public void carregarTabelaPais(List<Pais> pais) {

        String colunas[] = {"Id", "País"};
        String dados[][] = new String[pais.size()][colunas.length];
        int i = 0;
        
        for(Pais p: pais){
        dados[i] = new String[]{ 
            String.valueOf(p.getId()), 
            p.getNome()
        };
        i++;
    }

    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    telaPaisConsulta.tblPais.setModel(model);
    }     
}
