// Pacote: rpg.Item
package rpg.Item;

import rpg.Personagem.Heroi;
import rpg.Personagem.Inimigos.Inimigo;

public class ItemCura extends ItemBase {
    protected int poderCura;

    public ItemCura(String nome, int poderCura) {
        super(nome);
        this.poderCura = poderCura;
    }

    public int getPoderCura() {
        return poderCura;
    }

    @Override
    public void usar(Heroi heroi) {
        heroi.recuperarVida(poderCura);
        System.out.println("Você usou " + nome + " e recuperou " + poderCura + " pontos de vida.");
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {
        System.out.println("Esta poção não afeta inimigos.");
    }
}
