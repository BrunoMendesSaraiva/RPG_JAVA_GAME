package rpg.Personagem.Habilidades.Raca;

import rpg.Personagem.Heroi;
import rpg.Personagem.Habilidades.Habilidade;
import rpg.Personagem.Inimigos.Inimigo;

public class Fortaleza extends Habilidade {
    public Fortaleza() {
        super("Fortaleza", "Aumenta vitalidade e resistência a danos.");
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        Heroi heroi = Heroi.getInstancia();
        int aumentoVitalidade = 20;
        System.out.println("Você usou Fortaleza! Sua vitalidade aumentou em " + aumentoVitalidade + " pontos temporariamente.");
        heroi.recuperarVida(aumentoVitalidade);
    }
}
