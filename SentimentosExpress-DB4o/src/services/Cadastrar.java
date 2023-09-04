package services;

import com.db4o.ObjectContainer;

import util.Util;
import model.Motorista;
import model.Veiculo;
import model.Viagem;

public class Cadastrar {
	
	protected ObjectContainer manager;
	
	
	private boolean verificarViagemDuplicada(Viagem viagem) {
        for (Viagem vi : manager.query(Viagem.class)) {
            if (vi.equalsExcludingId(viagem)) {
                return true;
            }
        }
        return false;
    }
	public Cadastrar() {
		try {
			manager = Util.conectarBanco();
			System.out.println("Realizando cadastros...");
			
			//Motoristas
			Motorista motorista1, motorista2, motorista3, motorista4;
			
			motorista1 = new Motorista("68418818452", "Carlinho do Financeiro");
			manager.store(motorista1);
			manager.commit();
			
			motorista2 = new Motorista("24030964862", "Leozinho do Borel");
			manager.store(motorista2);
			manager.commit();
			
			motorista3 = new Motorista("95752634310", "Zezão Pé Grande");
			manager.store(motorista3);
			manager.commit();
			
			motorista4 = new Motorista("51704264906", "Juquinha da Esquina");
			manager.store(motorista4);
			manager.commit();
			
			//Veiculos
			Veiculo veiculo1, veiculo2, veiculo3, veiculo4;
			
			veiculo1 = new Veiculo("KBU-0214",4);
			manager.store(veiculo1);
			manager.commit();
			
			veiculo2 = new Veiculo("NEM-9988",7);
			manager.store(veiculo2);
			manager.commit();
			
			veiculo3 = new Veiculo("JYQ-1219",6);
			manager.store(veiculo3);
			manager.commit();
			
			veiculo4 = new Veiculo("HYU-7848",7);
			manager.store(veiculo4);
			manager.commit();
			
			//Viagens
			Viagem destino1, destino2, destino3, destino4, destino5, destino6, destino7, destino8, destino9;
			
			destino1 = new Viagem(Util.gerarIdViagem(), "22/10/2022", veiculo1, motorista1, "Recife", 4 );
			
			veiculo1.addViagem(destino1);
			motorista1.addViagem(destino1);
			if (!verificarViagemDuplicada(destino1)) {
				manager.store(destino1);
				manager.commit();
				System.out.println("Viagem 'Destino1' para Recife cadastrada com sucesso!");
			} else {
				System.out.println("Viagem 'destino1' para Recife já existe no banco.");
			}
			

			destino2 = new Viagem(Util.gerarIdViagem(), "10/12/2022", veiculo2, motorista2, "Guarapari", 3 );
			veiculo2.addViagem(destino2);
			motorista2.addViagem(destino2);
			manager.store(destino2);
			manager.commit();
			
			destino3 = new Viagem(Util.gerarIdViagem(), "01/09/2022", veiculo3, motorista3, "Bariloche", 7 );
			veiculo3.addViagem(destino3);
			motorista3.addViagem(destino3);
			manager.store(destino3);
			manager.commit();
			
			destino4 = new Viagem(Util.gerarIdViagem(), "01/09/2022", veiculo4, motorista4, "Bariloche", 4);
			veiculo4.addViagem(destino4);
			motorista4.addViagem(destino4);
			manager.store(destino4);
			manager.commit();
			
			
			destino5 = new Viagem(Util.gerarIdViagem(), "11/01/2023", veiculo2, motorista3, "Augusta", 5);
			veiculo2.addViagem(destino5);
			motorista3.addViagem(destino5);
			manager.store(destino5);
			manager.commit();
			
			destino6 = new Viagem(Util.gerarIdViagem(), "18/01/2023", veiculo1, motorista2, "Feira de Santada", 3);
			veiculo1.addViagem(destino6);
			motorista2.addViagem(destino6);
			manager.store(destino6);
			manager.commit();
			
			destino7 = new Viagem(Util.gerarIdViagem(), "25/01/2023", veiculo4, motorista1, "Areia", 5);
			veiculo4.addViagem(destino7);
			motorista1.addViagem(destino7);
			manager.store(destino7);
			manager.commit();
			
			destino8 = new Viagem(Util.gerarIdViagem(), "04/02/2023", veiculo2, motorista1, "Rio Branco", 3);
			veiculo2.addViagem(destino8);
			motorista1.addViagem(destino8);
			manager.store(destino8);
			manager.commit();
			
			destino9 = new Viagem(Util.gerarIdViagem(), "17/02/2023", veiculo3, motorista4, "Santa Catarina", 4);
			veiculo3.addViagem(destino9);
			motorista4.addViagem(destino9);
			manager.store(destino9);
			manager.commit();
			
			Util.desconectar();
			System.out.println("\n Cadastros realizados com sucesso!");
			
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	

		
	}
	
	public static void main(String[] args) {
		new Cadastrar();
	}

}
