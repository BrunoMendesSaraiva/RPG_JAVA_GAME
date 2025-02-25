// Pacote: rpg.Item
package rpg.Item;

import rpg.Personagem.Heroi;
import rpg.Personagem.Inimigos.Inimigo;

public class ItemDano extends ItemBase {
    protected int poderAtaque;

    public ItemDano(String nome, int poderAtaque) {
        super(nome);
        this.poderAtaque = poderAtaque;
    }

    public int getPoderAtaque() {
        return poderAtaque;
    }

    @Override
    public void usar(Heroi heroi) {
        // Não faz nada, pois armas devem ser usadas com inimigo
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {
        int dano = poderAtaque - inimigo.getDefesa();
        if (dano < 0) dano = 0;
        inimigo.setVida(inimigo.getVida() - dano);
        System.out.println("Você atacou " + inimigo.getNome() + " com " + nome + " causando " + dano + " de dano!");
    }
}
