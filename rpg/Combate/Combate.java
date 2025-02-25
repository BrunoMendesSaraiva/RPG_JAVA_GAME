package rpg.Combate;

import java.util.Scanner;
import rpg.Personagem.Heroi;
import rpg.Personagem.Inimigos.Inimigo;
import rpg.Personagem.Inimigos.Especiais.Mimico;

public class Combate {
    public static void iniciarCombate(Heroi heroi, Inimigo inimigo) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== INÍCIO DO COMBATE =====");
        System.out.println(inimigo.getNome() + " está pronto para lutar!");
        System.out.println(inimigo.getNome() + " tem " + inimigo.getVida() + " pontos de vida.");

        // Loop do combate
        while (heroi.getVida() > 0 && inimigo.getVida() > 0) {
            System.out.println("\n===== SUA VEZ =====");
            System.out.println("Sua Vida: " + heroi.getVida());
            System.out.println(inimigo.getNome() + " Vida: " + inimigo.getVida());

            System.out.println("\nEscolha uma ação:");
            System.out.println("1. Atacar");
            System.out.println("2. Usar Poção");
            System.out.println("3. Usar Habilidade");
            if (!(inimigo instanceof Mimico)) {
                System.out.println("4. Fugir");
            }
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> { // Atacar
                    System.out.println("Escolher do Cinto (C) ou da Mochila (M)?");
                    String origem = scanner.next().toUpperCase();

                    if (origem.equals("C")) {
                        System.out.println("Escolha uma arma do cinto:");
                        heroi.mostrarCinto();
                        int indice = scanner.nextInt();
                        heroi.usarItemCinto(indice, inimigo);
                    } else if (origem.equals("M")) {
                        System.out.println("Escolha uma arma da mochila:");
                        heroi.mostrarMochila();
                        int indice = scanner.nextInt();
                        heroi.usarItemMochila(indice, inimigo);
                    } else {
                        System.out.println("Escolha inválida! Você perdeu a vez.");
                    }
                }

                case 2 -> { // Usar Poção
                    System.out.println("Escolher do Cinto (C) ou da Mochila (M)?");
                    String origem = scanner.next().toUpperCase();

                    if (origem.equals("C")) {
                        System.out.println("Escolha uma poção do cinto:");
                        heroi.mostrarCinto();
                        int indicePocao = scanner.nextInt();
                        heroi.usarItemCinto(indicePocao, inimigo);
                    } else if (origem.equals("M")) {
                        System.out.println("Escolha uma poção da mochila:");
                        heroi.mostrarMochila();
                        int indicePocao = scanner.nextInt();
                        heroi.usarItemMochila(indicePocao, inimigo);
                    } else {
                        System.out.println("Escolha inválida! Você perdeu a vez.");
                    }
                }

                case 3 -> { // Usar Habilidade
                    System.out.println("Escolha uma habilidade:");
                    heroi.mostrarHabilidades();
                    int indiceHabilidade = scanner.nextInt();
                    heroi.usarHabilidade(indiceHabilidade, inimigo);
                }

                case 4 -> { // Fugir
                    if (inimigo instanceof Mimico) {
                        System.out.println("Você não pode fugir de um Mímico!");
                    } else {
                        System.out.println("Você fugiu da batalha!");
                        return;
                    }
                }

                default -> System.out.println("Escolha inválida!");
            }

            // Turno do Inimigo
            if (inimigo.getVida() > 0) {
                System.out.println("\n===== TURNO DO INIMIGO =====");
                inimigo.atacar(heroi);
                System.out.println("Sua vida: " + heroi.getVida());
            }

            // Verificar o estado do combate
            if (heroi.getVida() <= 0) {
                System.out.println("Você foi derrotado!");
                return;
            }
            if (inimigo.getVida() <= 0) {
                System.out.println("Você derrotou o " + inimigo.getNome() + " e recebeu " + inimigo.getMoedas() + " moedas!");
                heroi.setMoedasTotais(heroi.getMoedasTotais() + inimigo.getMoedas());
                return;
            }
        }
        System.out.println("===== FIM DO COMBATE =====");
    }
}
