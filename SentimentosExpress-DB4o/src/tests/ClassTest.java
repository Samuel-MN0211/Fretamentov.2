package tests;


import model.*;

public class ClassTest {

	  public static void main(String[] args) {
	        // Criando um motorista
	        Motorista motorista = new Motorista("123456", "João");

	        // Criando um veículo
	        Veiculo veiculo = new Veiculo("ABC1234", 4);

	        // Criando uma viagem
	        Viagem viagem = new Viagem(1, "22/10/2015", veiculo, motorista, "Cidade A", 3);

	        // Associando a viagem ao motorista e ao veículo
	        motorista.addViagem(viagem);
	        veiculo.addViagem(viagem);

	        // Imprimindo informações
	        System.out.println("Motorista: " + motorista);
	        System.out.println("Veículo: " + veiculo);
	        System.out.println("Viagem: " + viagem);

	        // Localizando viagem
	        Viagem viagemMotorista = motorista.localizarViagem("Cidade A");
	        Viagem viagemVeiculo = veiculo.localizarViagem("Cidade A");

	        if (viagemMotorista != null) {
	            System.out.println("Viagem encontrada no motorista: " + viagemMotorista);
	        } else {
	            System.out.println("Viagem não encontrada no motorista.");
	        }

	        if (viagemVeiculo != null) {
	            System.out.println("Viagem encontrada no veículo: " + viagemVeiculo);
	        } else {
	            System.out.println("Viagem não encontrada no veículo.");
	        }

	        // Removendo viagem
	        motorista.removeViagem(viagem);
	        veiculo.removeViagem(viagem);

	        // Localizando viagem novamente
	        viagemMotorista = motorista.localizarViagem("Cidade A");
	        viagemVeiculo = veiculo.localizarViagem("Cidade A");

	        if (viagemMotorista != null) {
	            System.out.println("Viagem encontrada no motorista: " + viagemMotorista);
	        } else {
	            System.out.println("Viagem não encontrada no motorista.");
	        }

	        if (viagemVeiculo != null) {
	            System.out.println("Viagem encontrada no veículo: " + viagemVeiculo);
	        } else {
	            System.out.println("Viagem não encontrada no veículo.");
	        }
	    }
}
