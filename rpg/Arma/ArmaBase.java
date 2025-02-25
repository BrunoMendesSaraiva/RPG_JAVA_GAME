// Classe para armas
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
        // Dano é o resultado do ataque do personagem somado ao poder da arma
        int dano = heroi.getAtaque() + getPoderAtaque() - inimigo.getDefesa();
        if (dano < 0) dano = 0; // Evita dano negativo

        inimigo.receberDano(dano);
        System.out.println("Você atacou " + inimigo.getNome() +
                " com " + getNome() +
                " causando " + dano + " de dano!");
    }
}
