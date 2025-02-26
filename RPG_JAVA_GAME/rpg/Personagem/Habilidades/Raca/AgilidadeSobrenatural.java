package rpg.Personagem.Habilidades.Raca;

import rpg.Personagem.Heroi;
import rpg.Personagem.Habilidades.Habilidade;
import rpg.Personagem.Inimigos.Inimigo;

import java.util.Random;

public class AgilidadeSobrenatural extends Habilidade {
    public AgilidadeSobrenatural() {
        super("Agilidade Sobrenatural", "Esquiva de ataques com alta chance.");
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        Heroi heroi = Heroi.getInstancia();
        int chanceEsquiva = 50; // 50% de chance de esquiva
        Random random = new Random();

        System.out.println("Você usou Agilidade Sobrenatural! Alta chance de esquiva no próximo ataque.");

        // Atribui a chance de esquiva para o próximo turno
        heroi.setChanceEsquiva(chanceEsquiva);
    }
}
