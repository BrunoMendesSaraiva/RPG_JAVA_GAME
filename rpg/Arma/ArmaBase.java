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
        if (inimigo.tentarBloqueio()) {
            System.out.println(inimigo.getNome() + " bloqueou o ataque!");
        } else {
            int dano = getPoderAtaque() + heroi.getAtaque() - inimigo.getDefesa();
            if (dano < 0) dano = 0;
            inimigo.receberDano(dano);
            System.out.println("Você atacou " + inimigo.getNome() + " com " + getNome() + " causando " + dano + " de dano!");
        }
    }
}