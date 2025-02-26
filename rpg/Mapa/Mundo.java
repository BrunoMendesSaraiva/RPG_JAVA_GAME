package rpg.Mapa;

import rpg.Personagem.Heroi;

import java.io.IOException;
import java.util.Random;


public class Mundo {
    private Mapa mapa;
    private Random random;

    public Mundo(int tamanhoMapa) {
        this.mapa = new Mapa(tamanhoMapa);
        this.random = new Random();
    }

    public void explorar(Heroi heroi) {
        boolean explorando = true;

        while (explorando) {
            mapa.mostrarMapa();
            System.out.println("\nVocê está em " + mapa.getPosicao());
            System.out.println("Escolha uma ação:");
            System.out.println("W - Mover para Norte");
            System.out.println("S - Mover para Sul");
            System.out.println("D - Mover para Leste");
            System.out.println("A - Mover para Oeste");
            System.out.println("E - Ver Status Atuais");
            System.out.println("Q - Sair da exploração");

            try {
                char escolha = (char) System.in.read();
                System.in.skip(System.in.available()); // Limpa o buffer

                switch (Character.toUpperCase(escolha)) {
                    case 'W' -> mapa.moverNorte(heroi);
                    case 'S' -> mapa.moverSul(heroi);
                    case 'D' -> mapa.moverLeste(heroi);
                    case 'A' -> mapa.moverOeste(heroi);
                    case 'E' -> heroi.mostrarStatus();
                    case 'Q' -> {
                        System.out.println("Você encerrou a exploração.");
                        exibirCreditos();
                        explorando = false;
                    }
                    default -> System.out.println("Escolha inválida! Use WASD, E ou Q.");
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler entrada: " + e.getMessage());
            }
        }
    }

    private void exibirCreditos() {
        System.out.println("\n===== FIM DO JOGO =====");
        System.out.println("Obrigado por jogar!");
        System.out.println("Bruno \"Nancom\" Saraiva");
        System.out.println("Gabriel \"Schutz\" Schutz");
        System.out.println("Paulo \"Petruz\" Petruz");
        System.exit(0);
    }
}
