// Pacote: rpg.Arma
package rpg.Arma;

import rpg.Personagem.Heroi;
import rpg.Personagem.Inimigos.Inimigo;
import rpg.Item.ItemDano;

public class ArmaBase extends ItemDano {

    public ArmaBase(String nome, int poderAtaque) {
        super(nome, poderAtaque);
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {
        // Cálculo de dano direto sem defesa
        int dano = getPoderAtaque();
        inimigo.setVida(inimigo.getVida() - dano);

        // Exibe o dano causado
        System.out.println("Você atacou " + inimigo.getNome() + " com " + getNome() + " causando " + dano + " de dano!");
    }
}
