package model;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
	private String placa;
	private int capacidade;
	private List<Viagem> lista;
	
	public Veiculo(String placa, int capacidade) {
		this.placa = placa;
		this.capacidade = capacidade;
		lista = new ArrayList<Viagem>();
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public List<Viagem> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Viagem> lista) {
		this.lista = lista;
	}
	
	public void addViagem(Viagem viagem) {
        if (!lista.contains(viagem)) {
            lista.add(viagem);
        }
    }
	
	 public List<Integer> getViagemIds() {
	        List<Integer> viagemIds = new ArrayList<>();
	        for (Viagem viagem : lista) {
	            viagemIds.add(viagem.getId());
	        }
	        return viagemIds;
	    }
	
	public void removeViagem(Viagem viagem) {
		lista.remove(viagem);
	}
	
	public Viagem localizarViagem(String dest) {
		for(Viagem via : lista) {
			if(dest.equals(via.getDestino())) {
				return via;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String texto = "Veiculo [placa=" + placa + ", capacidade=" + capacidade + "] Viagens= " ;
		if (lista.isEmpty())
			texto += "Sem viagens";
		else 	
			for(Viagem v: lista) 
				texto += v.getDestino() + " - " ; 
		
	    return texto;
	}

	
}

