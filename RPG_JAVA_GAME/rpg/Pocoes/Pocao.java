// Pacote: rpg.Item
package rpg.Pocoes;

import rpg.Item.ItemCura;
import rpg.Personagem.Heroi;
import rpg.Personagem.Inimigos.Inimigo;

public class Pocao extends ItemCura {
    public Pocao(String nome, int poderCura) {
        super(nome, poderCura);
    }

    @Override
    public void usar(Heroi heroi) {
        super.usar(heroi); // Usa a lógica de cura de ItemCura
    }

    @Override
    public void usar(Heroi heroi, Inimigo inimigo) {
        // Poções não afetam inimigos
        System.out.println("Esta poção não afeta inimigos.");
    }
}
