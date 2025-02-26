package rpg.Personagem.Inimigos.Especiais;

import rpg.Personagem.Heroi;
import rpg.Personagem.Inimigos.Inimigo;

public class Mimico extends Inimigo {

    // Construtor do Mímico
    public Mimico() {
        super("Mimico", 70, 18, 5,15);
    }

    @Override
    public void atacar(Heroi heroi) {
        System.out.println("Ataque do Mímico = " + this.getAtaque());
        int dano = this.getAtaque();
        if (dano < 1) dano = 1;

        heroi.setVida(heroi.getVida() - dano);
        System.out.println(getNome() + " atacou com mordida! Causou " + dano + " de dano!");
    }

    public void receberDano(int dano){
        this.setVida(this.getVida() - dano);
        System.out.println(getNome() + " está com " + this.getVida() + " de vida!");
    }

    public void mostrarVida() {
        System.out.println(getNome() + " tem " + getVida() + " de vida!");
    }
}
