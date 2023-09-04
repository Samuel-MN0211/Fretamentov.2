package services;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import model.Veiculo;
import model.Viagem;
import model.Motorista;
import util.Util;

public class Listar {
    protected ObjectContainer manager;
    
    public Listar() {
        try {
            manager = Util.conectarBanco();
            
            System.out.println(" -> Lista de Viagens  <- ");
            Query q = manager.query();
            q.constrain(Viagem.class);
            List<Viagem> viagensResultado = q.execute();
            
            for (Viagem vi : viagensResultado) {
                try {
                    if (vi != null && vi.getDestino() != null) {
                        System.out.println(vi);
                    } else {
                        System.out.println("Viagem com destino nulo ou inválido.");
                    }
                } catch (NullPointerException e) {
                    // Continua para a próxima viagem em caso de exceção
                }
            }
            
            System.out.println(" -> Lista de Veículos  <- ");
            Query q2 = manager.query();
			q2.constrain(Veiculo.class);
			List<Veiculo> veiculoResultado = q2.execute();
			for (Veiculo ve: veiculoResultado) {
				try {
                    System.out.println(ve);
                } catch (NullPointerException e) {
                }}
            
            System.out.println(" -> Lista de Motoristas  <- ");
            Query q3 = manager.query();
			q3.constrain(Motorista.class);
			List<Motorista> motoristaResultado = q3.execute();
			for (Motorista mo: motoristaResultado) {
				try {
                    System.out.println(mo);
                } catch (NullPointerException e) {
                }
			}
            
            System.out.println("Listagem encerrada!");
            
            Util.desconectar();
            
        } catch (Exception e) {
            System.out.println("Erro geral: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Listar();
    }
}