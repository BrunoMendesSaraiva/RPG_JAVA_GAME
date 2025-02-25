// Pacote: rpg.Item
package rpg.Item;

import rpg.Personagem.Heroi;
import rpg.Personagem.Inimigos.Inimigo;

public abstract class ItemBase {
    protected String nome;
    protected int peso;

    public ItemBase(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // Métodos abstratos para serem implementados nas subclasses
    public abstract void usar(Heroi heroi);

    public abstract void usar(Heroi heroi, Inimigo inimigo);
}
