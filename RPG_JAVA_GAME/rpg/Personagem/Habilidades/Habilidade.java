package rpg.Personagem.Habilidades;

import rpg.Personagem.Inimigos.Inimigo;

public abstract class Habilidade {
    private final String nome;
    private final String descricao;

    public Habilidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void usarHabilidade(Inimigo inimigo);
}
