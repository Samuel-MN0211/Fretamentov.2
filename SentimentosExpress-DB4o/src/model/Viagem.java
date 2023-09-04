package model;

import java.util.Objects;

public class Viagem {
	private int id;
	private String data;
	private Veiculo veiculo ;
	private Motorista motorista;
	private String destino;
	private int quantidade;
	
	public Viagem(int id, String data, Veiculo veiculo, Motorista motorista, String destino, int quantidade) {
        this.id = id;
        this.data = data;
        this.destino = destino;
        this.quantidade = quantidade;
        this.veiculo = veiculo;
        this.motorista = motorista;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Viagem [id=" + id + ", data=" + data + ", veiculo=" + veiculo + ", motorista=" + motorista
				+ ", destino=" + destino + ", quantidade=" + quantidade + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Viagem other = (Viagem) obj;
	    return Objects.equals(data, other.data)
	            && Objects.equals(veiculo, other.veiculo)
	            && Objects.equals(motorista, other.motorista)
	            && Objects.equals(destino, other.destino)
	            && quantidade == other.quantidade;
	}

	public boolean equalsExcludingId(Viagem other) {
	    if (this == other) {
	        return true;
	    }
	    return Objects.equals(data, other.data)
	            && Objects.equals(veiculo, other.veiculo)
	            && Objects.equals(motorista, other.motorista)
	            && Objects.equals(destino, other.destino)
	            && quantidade == other.quantidade;
	}

	public Object localizarViagem(String destino2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeViagem(Viagem viagem) {
		// TODO Auto-generated method stub
		
	}


}