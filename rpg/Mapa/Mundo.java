package rpg.Mapa;

import java.util.Random;
import java.util.Scanner;
import rpg.Personagem.Heroi;
import rpg.Eventos.Eventos;

public class Mundo {
    private Mapa mapa;
    private Random random;
    private Scanner scanner;

    // Construtor que recebe o tamanho do mapa
    public Mundo(int tamanhoMapa) {
        this.mapa = new Mapa(tamanhoMapa);
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    // Método principal de exploração do mundo
    // Método principal de exploração do mundo
    public void explorar(Heroi heroi) {
        boolean explorando = true;

        while (explorando) {
            mapa.mostrarMapa();
            System.out.println("\nVocê está em " + mapa.getPosicao());
            System.out.println("Escolha uma ação:");
            System.out.println("1. Mover para Norte (W)");
            System.out.println("2. Mover para Sul (S)");
            System.out.println("3. Mover para Leste (D)");
            System.out.println("4. Mover para Oeste (A)");
            System.out.println("5. Ver Status Atuais");
            System.out.println("6. Sair da exploração");

            String escolha = scanner.next().toUpperCase(); // Aceita letras e números

            switch (escolha) {
                case "1", "W" -> mapa.moverNorte(heroi);
                case "2", "S" -> mapa.moverSul(heroi);
                case "3", "D" -> mapa.moverLeste(heroi);
                case "4", "A" -> mapa.moverOeste(heroi);
                case "5" -> heroi.mostrarStatus();
                case "6" -> {
                    System.out.println("Você encerrou a exploração.");
                    explorando = false;
                }
                default -> System.out.println("Escolha inválida! Use WASD ou números de 1 a 6.");
            }
        }
    }
}
