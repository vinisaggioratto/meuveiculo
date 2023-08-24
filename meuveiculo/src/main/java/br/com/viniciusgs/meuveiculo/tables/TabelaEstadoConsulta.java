/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.viniciusgs.meuveiculo.tables;

import br.com.viniciusgs.meuveiculo.entity.Estado;
import br.com.viniciusgs.meuveiculo.view.TelaEstadoConsulta;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FROTA01-PC
 */
public class TabelaEstadoConsulta {
    TelaEstadoConsulta telaEstadoConsulta = null;
    public void carregarTabelaEstado(List<Estado> estado) {

        String colunas[] = {"Id", "Estado", "País"};
        String dados[][] = new String[estado.size()][colunas.length];
        int i = 0;
        
        for(Estado e: estado){
        dados[i] = new String[]{ 
            String.valueOf(e.getId()), 
            e.getNome(),
            e.getPais().getNome()
        };
        i++;
    }

    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    telaEstadoConsulta.tblEstado.setModel(model);
    }     
}
