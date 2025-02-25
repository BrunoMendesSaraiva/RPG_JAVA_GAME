package rpg.Personagem.Inimigos;

import rpg.Personagem.Heroi;
import java.util.Random;

public class Inimigo {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int moedas;
    private int chanceEsquiva;

    // Construtor para inimigos comuns (com chance de esquiva)
    public Inimigo(String nome, int vida, int ataque, int moedas, int chanceEsquiva) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.moedas = moedas;
        this.chanceEsquiva = chanceEsquiva;
    }

    // Construtor para chefes finais (chance de esquiva personalizada)
    public Inimigo(String nome, int vida, int ataque, boolean chefeFinal, int moedas, int chanceEsquiva) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.moedas = moedas;
        this.chanceEsquiva = chanceEsquiva;
    }

    // ===============================
    // Getters e Setters
    // ===============================
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

    public int getChanceEsquiva() {
        return chanceEsquiva;
    }

    public void setChanceEsquiva(int chanceEsquiva) {
        this.chanceEsquiva = chanceEsquiva;
    }

    // ===============================
    // Método de ataque do inimigo
    // ===============================
    public void atacar(Heroi heroi) {
        Random random = new Random();
        int chance = random.nextInt(100);

        // Verifica a chance de esquiva do herói
        if (chance < heroi.getChanceEsquiva()) {
            System.out.println(heroi.getNome() + " esquivou do ataque com Agilidade Sobrenatural!");
            heroi.setChanceEsquiva(0); // Reseta a esquiva após o uso
            return;
        }

        // Aplica o dano diretamente
        heroi.receberDano(this.getAtaque());
        System.out.println(this.getNome() + " atacou " + heroi.getNome() + " causando " + this.getAtaque() + " de dano.");
    }

    // ===============================
    // Método para receber dano
    // ===============================
    public void receberDano(int dano) {
        Random random = new Random();
        int chance = random.nextInt(100);

        // Verifica a chance de esquiva do inimigo
        if (chance < this.chanceEsquiva) {
            System.out.println(this.getNome() + " esquivou do ataque!");
        } else {
            this.vida -= dano;
            System.out.println(this.getNome() + " recebeu " + dano + " de dano.");
        }

        if (vida < 0) vida = 0;
    }

    // ===============================
    // Método para mostrar o status do inimigo
    // ===============================
    public void mostrarStatus() {
        System.out.println("===== STATUS DO INIMIGO =====");
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Chance de Esquiva: " + chanceEsquiva + "%");
        System.out.println("=============================");
    }

    // ===============================
    // Metodo para verificar se o inimigo foi derrotado    NÂO MEXE SCHUTZ
    // ===============================
    public boolean isDerrotado() {
        return vida <= 0;
    }

    // ===============================
    // Método para ataque especial (sobrescreva em subclasses)
    // ===============================
    public void ataqueEspecial(Heroi heroi) {
        System.out.println(nome + " está preparando um ataque especial...");
    }
}
