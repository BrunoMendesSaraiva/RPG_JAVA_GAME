package rpg.Personagem.Habilidades.Raca;

import rpg.Personagem.Heroi;
import rpg.Personagem.Habilidades.Habilidade;
import rpg.Personagem.Inimigos.Inimigo;

public class FuriaMelkor extends Habilidade {
    public FuriaMelkor() {
        super("Fúria de Melkor", "Aumenta o ataque, mas reduz a defesa.");
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        Heroi heroi = Heroi.getInstancia();
        int aumentoAtaque = 15;
        System.out.println("Você usou Fúria de Melkor! Ataque aumentado em " + aumentoAtaque + " pontos");
        heroi.setAtaque(heroi.getAtaque() + aumentoAtaque);

    }
}
