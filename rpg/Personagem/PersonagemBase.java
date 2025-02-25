package rpg.Personagem;

public abstract class PersonagemBase {
    protected String nome;
    protected int vida;
    protected int maxVida;
    protected int ataque;
    protected int defesa;

    public PersonagemBase(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.maxVida = vida;
        this.ataque = ataque;
    }

    // ===============================
    // METODOS GETTERS E SETTERS
    // ===============================
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida < 0) {
            this.vida = 0;
            System.out.println(nome + " foi derrotado!");
        } else if (vida > this.maxVida) {
            this.vida = this.maxVida;
        } else {
            this.vida = vida;
        }
    }

    public int getMaxVida() {
        return maxVida;
    }

    public void setMaxVida(int maxVida) {
        this.maxVida = maxVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    // ===============================
    // METODOS PARA COMBATE
    // ===============================
    public void atacar(PersonagemBase alvo) {
        int dano = this.ataque - alvo.getDefesa();
        if (dano < 0) dano = 1;
        alvo.setVida(alvo.getVida() - dano);
        System.out.println(nome + " atacou " + alvo.getNome() + " causando " + dano + " de dano!");
    }

    public void receberDano(int dano) {
        int danoRecebido = dano - this.defesa;
        if (danoRecebido < 0) danoRecebido = 0;
        this.vida -= danoRecebido;
        System.out.println(nome + " recebeu " + danoRecebido + " de dano!");
    }

    public boolean isDerrotado() {
        return vida <= 0;
    }

    // ===============================
    // METODO PARA MOSTRAR STATUS (BÁSICO)
    // ===============================
    public void mostrarStatus() {
        System.out.println("===== STATUS DO PERSONAGEM =====");
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida + "/" + maxVida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defesa: " + defesa);
        System.out.println("===============================");
    }
}
