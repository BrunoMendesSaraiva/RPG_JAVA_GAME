package rpg.Personagem.Habilidades.Classe;

import rpg.Personagem.Habilidades.Habilidade;
import rpg.Personagem.Inimigos.Inimigo;
import rpg.Personagem.Heroi;

public class ForcaBruta extends Habilidade {
    public ForcaBruta() {
        super("Força Bruta", "Aumenta significativamente o ataque no próximo turno.");
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        if (inimigo != null) {
            System.out.println("Força Bruta não pode ser usada diretamente no inimigo!");
        } else {
            System.out.println("Você usou Força Bruta! Seu ataque aumentou consideravelmente para o próximo turno.");
            Heroi heroi = Heroi.getInstancia();
            heroi.setAtaque(heroi.getAtaque() + 10);
        }
    }

}
