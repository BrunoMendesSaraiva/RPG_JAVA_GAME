package rpg.Personagem;

import rpg.Item.ItemBase;
import rpg.Arma.ArmaBase;
import rpg.Personagem.Habilidades.Habilidade;
import rpg.Personagem.Inimigos.Inimigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heroi extends PersonagemBase {
    private final List<ItemBase> cinto = new ArrayList<>();
    private final List<ItemBase> mochila = new ArrayList<>();
    private final List<Habilidade> habilidades = new ArrayList<>();
    private final int capacidadeCinto = 5;
    private final int capacidadeMochila = 10;
    private int moedasTotais;
    private String raca;
    private String classe;
    private int vitalidade;
    private int forca;
    private int agilidade;
    private int inteligencia;
    private static Heroi instancia;
    private int chanceEsquiva = 0;



    Heroi(String nome, String raca, String classe, int vida, int ataque, int moedasTotais) {
        super(nome, vida, ataque);
        this.raca = raca;
        this.classe = classe;
        this.vitalidade = vida;
        this.moedasTotais = moedasTotais;
        cinto.add(new ArmaBase("Espada de Madeira", 6)); // Arma inicial, não precisa de classe adicional
    }

    // Método para obter a instância do Singleton
    public static Heroi getInstancia() {
        if (instancia == null) {
            throw new IllegalStateException("A instância do herói não foi inicializada.");
        }
        return instancia;
    }

    // Método para inicializar o Singleton
    public static void inicializarHeroi(String nome, String raca, String classe, int vida, int ataque, int moedasTotais) {
        if (instancia == null) {
            instancia = new Heroi(nome, raca, classe, vida, ataque, moedasTotais);
        } else {
            System.out.println("O herói já foi criado.");
        }
    }


    // ===============================
    // MÉTODOS PARA C I N T O
    // ===============================
    public void mostrarCinto() {
        System.out.println("===== C I N T O =====");
        for (int i = 0; i < cinto.size(); i++) {
            System.out.println(i + ". " + cinto.get(i).getNome());
        }
        System.out.println("=====================");
    }

    public void usarItemCinto(int indice, Inimigo inimigo) {
        if (indice < 0 || indice >= cinto.size()) {
            System.out.println("Escolha inválida!");
            return;
        }
        ItemBase item = cinto.get(indice);

        if (item instanceof ArmaBase) {
            ArmaBase arma = (ArmaBase) item;
            int dano = arma.getPoderAtaque();
            inimigo.receberDano(dano);
            System.out.println("Você atacou " + inimigo.getNome() + " com " + arma.getNome() + " causando " + dano + " de dano!");
        } else {
            System.out.println("Este item não é uma arma.");
        }
    }

    public void adicionarAoCinto(ItemBase item) {
        if (cinto.size() < capacidadeCinto) {
            cinto.add(item);
            System.out.println(item.getNome() + " foi adicionado ao cinto.");
        } else {
            System.out.println("O cinto está cheio! Tente colocar na mochila.");
        }
    }

    // ===============================
    // MÉTODOS PARA M O C H I L A
    // ===============================
    public void mostrarMochila() {
        System.out.println("===== M O C H I L A =====");
        if (mochila.isEmpty()) {
            System.out.println("A mochila está vazia.");
        } else {
            for (int i = 0; i < mochila.size(); i++) {
                System.out.println(i + ". " + mochila.get(i).getNome());
            }
        }
        System.out.println("=========================");
    }

    public void usarItemMochila(int indice, Inimigo inimigo) {
        if (indice >= 0 && indice < mochila.size()) {
            ItemBase item = mochila.get(indice);
            item.usar(this, inimigo);
            mochila.remove(indice);
            System.out.println(item.getNome() + " foi usado!");
        } else {
            System.out.println("Escolha inválida! Você perdeu a vez.");
        }
    }

    public void adicionarNaMochila(ItemBase item) {
        if (mochila.size() < capacidadeMochila) {
            mochila.add(item);
            System.out.println(item.getNome() + " foi adicionado à mochila.");
        } else {
            System.out.println("A mochila está cheia!");
        }
    }

    // ===============================
    // MÉTODOS PARA H A B I L I D A D E S
    // ===============================
    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades.addAll(habilidades);
    }

    public void mostrarHabilidades() {
        System.out.println("===== H A B I L I D A D E S =====");
        if (habilidades.isEmpty()) {
            System.out.println("Você não possui habilidades.");
        } else {
            for (int i = 0; i < habilidades.size(); i++) {
                Habilidade habilidade = habilidades.get(i);
                System.out.println(i + ". " + habilidade.getNome() + " - " + habilidade.getDescricao());
            }
        }
        System.out.println("=================================");
    }


    public void usarHabilidade(int indice, Inimigo inimigo) {
        if (indice < 0 || indice >= habilidades.size()) {
            System.out.println("Escolha inválida!");
            return;
        }
        Habilidade habilidade = habilidades.get(indice);
        System.out.println("Usando habilidade: " + habilidade.getNome());
        habilidade.usarHabilidade(inimigo);
    }

    // Retorna a lista de habilidades do herói
    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    // ===============================
    // GETTERS e SETTERS
    // ===============================
    public String getRaca() {
        return raca;
    }

    public String getClasse() {
        return classe;
    }

    public int getVitalidade() {
        return vitalidade;
    }

    public int getForca() {
        return forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public int getMoedasTotais() {
        return moedasTotais;
    }

    public void setMoedasTotais(int moedasTotais) {
        this.moedasTotais = moedasTotais;
    }

    public void setAtaque(int novoAtaque) {
        this.ataque = novoAtaque;
    }

    public void recuperarVida(int quantidade) {
        this.vida += quantidade;
        if (this.vida > maxVida) {
            this.vida = maxVida;
        }
        System.out.println("Você recuperou " + quantidade + " pontos de vida!");
    }

    public int getChanceEsquiva() {
        return chanceEsquiva;
    }

    public void setChanceEsquiva(int chanceEsquiva) {
        this.chanceEsquiva = chanceEsquiva;
    }


    // Calcular a chance de bloqueio
    public boolean tentarBloqueio() {
        Random random = new Random();
        int chance = random.nextInt(100);
        int chanceBloqueio = this.defesa * 2; // Fator de bloqueio: 2%
        return chance < chanceBloqueio;
    }

    // ===============================
    // METODO PARA MOSTRAR STATUS
    // ===============================
    public void mostrarStatus() {
        System.out.println("===== STATUS DO HERÓI =====");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Raça: " + this.getRaca());
        System.out.println("Classe: " + this.getClasse());
        System.out.println("Vida: " + this.getVida() + "/" + maxVida);
        System.out.println("Ataque: " + this.getAtaque());
        System.out.println("Vitalidade: " + this.getVitalidade());
        System.out.println("Força: " + this.getForca());
        System.out.println("Agilidade: " + this.getAgilidade());
        System.out.println("Inteligência: " + this.getInteligencia());
        System.out.println("Moedas: " + this.getMoedasTotais());
        System.out.println("===========================");
        mostrarHabilidades();
    }
}
