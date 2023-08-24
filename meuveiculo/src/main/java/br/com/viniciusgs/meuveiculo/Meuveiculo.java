package br.com.viniciusgs.meuveiculo;

import br.com.viniciusgs.meuveiculo.dto.EstadoDTO;
import br.com.viniciusgs.meuveiculo.dto.PaisDTO;
import br.com.viniciusgs.meuveiculo.entity.Estado;
import br.com.viniciusgs.meuveiculo.entity.Pais;
import br.com.viniciusgs.meuveiculo.view.TelaPrincipal;

/**
 *
 * @author FROTA01-PC
 */
public class Meuveiculo {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("--------------------------------");
        System.out.println("-----------HIBERNATE-----------");
        System.out.println("--------------------------------");
        
//        Pais pais = new Pais();
//        PaisDTO paisDTO = new PaisDTO();
//        
//        Estado estado = new Estado();
//        EstadoDTO estadoDTO = new EstadoDTO();
//        
//        System.out.println("Países cadastrados:\n");
//        paisDTO.getAll().stream().forEach(e -> System.out.printf(String.valueOf(e)));
//        
//        System.out.println("\n-------------------------------------\n");
//        
//        System.out.println("Estados cadastrados:\n");        
//        estadoDTO.getAll().stream().forEach(e -> System.out.printf(String.valueOf(e)));

            java.awt.EventQueue.invokeLater(new Runnable() {
              public void run() {
                  new TelaPrincipal().setVisible(true);
              }
          });
    }
}
