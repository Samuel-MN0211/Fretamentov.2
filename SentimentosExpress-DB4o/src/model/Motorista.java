package model;

import java.util.ArrayList;
import java.util.List;

public class Motorista {
	private String cnh;
	private String nome;
	private List<Viagem> lista;
	
	public Motorista(String cnh, String nome) {
		this.cnh = cnh;
		this.nome = nome;
		lista = new ArrayList<Viagem>();
	}
	
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Viagem> getLista() {
		return lista;
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
		String texto = "Motorista [cnh=" + cnh + ", nome=" + nome + "] viagens= ";
			if (lista.isEmpty())
				texto += "Sem viagens";
			else 	
				for(Viagem v: lista) 
					texto += v.getDestino() + " - " ; 
		    return texto;
	}

}
