package rpg.Personagem.Inimigos;

import rpg.Personagem.Heroi;

import java.util.Random;


public class Inimigo {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected boolean chefeFinal;
    protected int moedas;

    // Construtor para inimigos comuns (sem defesa)
    public Inimigo(String nome, int vida, int ataque, int moedas) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.moedas = moedas;
        this.defesa = 0;
        this.chefeFinal = false;
    }

    // Construtor para inimigos com defesa
    public Inimigo(String nome, int vida, int ataque, int defesa, int moedas) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.moedas = moedas;
        this.defesa = defesa;
        this.chefeFinal = false;
    }

    // Construtor para chefes finais
    public Inimigo(String nome, int vida, int ataque, int defesa, boolean chefeFinal, int moedas) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.moedas = moedas;
        this.defesa = defesa;
        this.chefeFinal = chefeFinal;
    }

    // Métodos Getters e Setters
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getMoedas() {
        return moedas;
    }

    public int getDefesa() {
        return defesa;
    }

    public boolean isChefeFinal() {
        return chefeFinal;
    }

    // Metodo de ataque do inimigo
    public void atacar(Heroi heroi) {
        Random random = new Random();
        int chance = random.nextInt(100);

        // Verifica a chance de esquiva
        if (chance < heroi.getChanceEsquiva()) {
            System.out.println(heroi.getNome() + " esquivou do ataque com Agilidade Sobrenatural!");
            heroi.setChanceEsquiva(0); // Reseta a esquiva após o uso
            return;
        }

        int dano = this.getAtaque() - heroi.getDefesa();
        if (dano > 0) {
            heroi.receberDano(dano);
            System.out.println(this.getNome() + " atacou " + heroi.getNome() + " causando " + dano + " de dano.");
        } else {
            System.out.println(heroi.getNome() + " bloqueou o ataque de " + this.getNome() + "!");
        }
    }


    // Metodo para mostrar o status do inimigo
    public void mostrarStatus() {
        System.out.println("===== STATUS DO INIMIGO =====");
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defesa: " + defesa);
        if (chefeFinal) {
            System.out.println("Este é um CHEFE FINAL!");
        }
        System.out.println("=============================");
    }

    // Metodo para verificar se o inimigo foi derrotado
    public boolean isDerrotado() {
        return vida <= 0;
    }

    // Metodo para ataque especial (sobrescreva em subclasses)
    public void ataqueEspecial(Heroi heroi) {
        System.out.println(nome + " está preparando um ataque especial...");
    }

    //Metodo para receber dano (Usado por ArmaBase)
    public void receberDano(int dano) {
        int danoRecebido = dano - this.defesa;
        if (danoRecebido < 0) danoRecebido = 0;
        this.vida -= danoRecebido;
    }
}
