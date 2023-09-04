package util;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;

import model.Motorista;
import model.Veiculo;
import model.Viagem;

public class Util {
	private static ObjectContainer manager;

	public static ObjectContainer conectarBanco(){
		if (manager != null)
			return manager;		//verificar conexão

		//configura Criação e Uso do banco local (pasta do projeto)
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);  // mensagens na tela 0(desliga),1,2,3...
		
		// Desabilitar cascata na remoção
		config.common().objectClass(Viagem.class).cascadeOnDelete(false);
		config.common().objectClass(Viagem.class).cascadeOnUpdate(true);
		config.common().objectClass(Viagem.class).cascadeOnActivate(true);
		//
		config.common().objectClass(Veiculo.class).cascadeOnDelete(false);
		config.common().objectClass(Veiculo.class).cascadeOnUpdate(true);
		config.common().objectClass(Veiculo.class).cascadeOnActivate(true);
		//
		config.common().objectClass(Motorista.class).cascadeOnDelete(false);
		config.common().objectClass(Motorista.class).cascadeOnUpdate(true);
		config.common().objectClass(Motorista.class).cascadeOnActivate(true);
		
		//Conex. local
		manager = Db4oEmbedded.openFile(config, "banco.db4o");
		return manager;
	}
	
	public static int gerarIdViagem() {
		if(manager.query(Viagem.class).size()==0) 
			//classe não existenteo banco
			return 1;
		
		Query q = manager.query();
		q.constrain(Viagem.class);
		q.descend("id").orderDescending();
		List<Viagem> resultados = q.execute();

		if(resultados.size()>0) {
			Viagem viagem = resultados.get(0);    
			return viagem.getId() + 1;
		}
		else
			return 1; 
	}
	
	

	public static void desconectar() {
		if(manager!=null) {
			manager.close();
			manager=null;
		}
	}
	
	
}
