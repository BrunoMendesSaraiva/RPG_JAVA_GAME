package rpg.Personagem.Habilidades.Classe;

import rpg.Personagem.Habilidades.Habilidade;
import rpg.Personagem.Inimigos.Inimigo;
import rpg.Personagem.Heroi;
import java.util.Random;

public class PrecisaoMortal extends Habilidade {
    public PrecisaoMortal() {
        super("Precisão Mortal", "Aumenta a chance de acerto crítico no próximo ataque.");
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        if (inimigo != null) {
            Random random = new Random();
            int critChance = 30; // 30% de chance de crítico
            int chance = random.nextInt(100);

            if (chance < critChance) {
                int danoCritico = 20;
                System.out.println("CRÍTICO! Você usou Precisão Mortal e causou " + danoCritico + " de dano em " + inimigo.getNome() + "!");
                inimigo.receberDano(danoCritico);
            } else {
                System.out.println("Você usou Precisão Mortal, mas não foi um acerto crítico.");
            }
        } else {
            System.out.println("Não há inimigo para atacar com Precisão Mortal!");
        }
    }
}
