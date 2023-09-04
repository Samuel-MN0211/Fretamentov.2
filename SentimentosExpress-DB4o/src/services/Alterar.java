package services;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import model.Veiculo;
import model.Viagem;
import util.Util;

public class Alterar {
	protected ObjectContainer manager;
	
	public Alterar() {
		try {
			manager = Util.conectarBanco();
			Query query, query2, query3;
			
			System.out.println("Iniciando alterações");
			
			query = manager.query();
			query.constrain(Veiculo.class);
			query.descend("capacidade").constrain(7);
			List<Veiculo> resultado = query.execute();
			
			if(resultado.size()>0) {
				for(Veiculo v : resultado) {
					//alterando capacidade de veiculo
					v.setCapacidade(4);
					manager.store(v);
					manager.commit();
					System.out.println("Veiculo : " + v + " - Tiveram a capacidade alterada para 4 " );
				}
				
			}
			
			System.out.println("Iniciando correções nas viagens...");
			
			// alterando capacidade de viagem
			query2 = manager.query();
			query2.constrain(Viagem.class);
			  
			 ObjectSet<Viagem> resultado2 = query2.execute();
			
			for( Viagem vi: resultado2) {
				if(vi.getQuantidade() > vi.getVeiculo().getCapacidade()) {
					vi.setQuantidade(vi.getVeiculo().getCapacidade());
					System.out.println("A viagem para " + vi.getDestino() + " teve sua capacidade corrigida, agora sua quantidade de passageiros é  " + vi.getQuantidade() );
				}
			}
			

			 
			query3 = manager.query();
			query3.constrain(Veiculo.class);
			query3.descend("placa").constrain("KBU-0214");
			List<Veiculo> resultado3 = query3.execute();
			
			//alteração de correção de capacidade da viagem e do veiculo
			
			if(resultado3.size()>0) {
				Veiculo ve = resultado3.get(0);
				Viagem vi = ve.localizarViagem("Recife");
				vi.setQuantidade(5);
				ve.setCapacidade(5);
				manager.store(ve);
				manager.commit();
				System.out.println("O veiculo " + ve.getPlaca() + " e a viagem de destino á " + vi.getDestino() + " tiveram sua capacidade e quantidade de passageiros alterada para " + vi.getQuantidade()  );
			}
			
			
			System.out.println("Alterações feitas com sucesso!");
			
			Util.desconectar();
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		new Alterar();
	}
}
