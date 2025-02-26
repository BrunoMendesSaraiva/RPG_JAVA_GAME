package rpg.Personagem.Habilidades.Raca;

import rpg.Personagem.Heroi;
import rpg.Personagem.Habilidades.Habilidade;
import rpg.Personagem.Inimigos.Inimigo;

public class Adaptabilidade extends Habilidade {
    public Adaptabilidade() {
        super("Adaptabilidade", "Aumenta a defesa temporariamente.");
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        Heroi heroi = Heroi.getInstancia();
        int aumentoDefesa = 10;
        System.out.println("Você usou Adaptabilidade! Sua defesa aumentou em " + aumentoDefesa + " pontos por este turno.");
        heroi.setDefesa(heroi.getDefesa() + aumentoDefesa);

        // Aqui você pode adicionar lógica para remover o bônus no próximo turno
    }
}
