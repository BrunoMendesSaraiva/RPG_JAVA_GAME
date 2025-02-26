package rpg.Personagem.Habilidades.Classe;

import rpg.Personagem.Habilidades.Habilidade;
import rpg.Personagem.Inimigos.Inimigo;

public class MagiaArdente extends Habilidade {
    public MagiaArdente() {
        super("Magia Ardente", "Causa dano contínuo no inimigo.");
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        if (inimigo != null) {
            int dano = 10;
            System.out.println("Você lançou Magia Ardente! O " + inimigo.getNome() + " está queimando e perdeu " + dano + " pontos de vida.");
            inimigo.receberDano(dano);
        } else {
            System.out.println("Não há inimigo para atacar com Magia Ardente!");
        }
    }
}
