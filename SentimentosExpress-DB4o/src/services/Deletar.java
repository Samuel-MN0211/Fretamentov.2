package services;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;
import model.Motorista;
import model.Veiculo;
import model.Viagem;
import util.Util;

import java.util.List;

public class Deletar {

    protected ObjectContainer manager;

    public Deletar() {
        try {
            manager = Util.conectarBanco();
            System.out.println("Deletando registros...");

            // Deletando viagens para Augusta
            Query q = manager.query();
            q.constrain(Viagem.class);

            q.descend("destino").constrain("Augusta");
            List<Viagem> resultado = q.execute();

            if (resultado.size() > 0) {
                for (Viagem viagem : resultado) {
                    for (Viagem mo : viagem.getMotorista().getLista()) {
                        if (mo.localizarViagem(viagem.getDestino()) != null) {
                            mo.removeViagem(viagem);
                        }
                    }

                    for (Viagem veiculo : viagem.getVeiculo().getLista()) {
                        if (veiculo.localizarViagem(viagem.getDestino()) != null) {
                            veiculo.removeViagem(viagem);
                        }
                    }
                    manager.delete(viagem);
                }
                manager.commit();
                System.out.println("Viagens para Augusta apagadas com sucesso!");
            }

            Util.desconectar();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Deletar();
    }
}
