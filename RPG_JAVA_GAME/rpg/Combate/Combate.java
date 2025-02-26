package rpg.Combate;

import java.util.Random;
import java.util.Scanner;
import rpg.Personagem.Heroi;
import rpg.Personagem.Inimigos.Inimigo;
import rpg.Personagem.Inimigos.Especiais.Mimico;
import rpg.Personagem.Inimigos.Bosses.*;

public class Combate {

    public static void iniciarCombate(Heroi heroi, Inimigo inimigo) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

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
                case 1 -> {
                    System.out.println("Escolher do Cinto (C) ou da Mochila (M)?");
                    String origem = scanner.next().toUpperCase();

                    if (origem.equals("C")) {
                        System.out.println("Escolha uma arma do cinto:");
                        heroi.mostrarCinto();
                        int indice = scanner.nextInt();

                        // Cálculo de esquiva do inimigo
                        int chanceEsquiva = random.nextInt(100);
                        if (chanceEsquiva < inimigo.getChanceEsquiva()) {
                            System.out.println(inimigo.getNome() + " esquivou do seu ataque!");
                        } else {
                            heroi.usarItemCinto(indice, inimigo);
                        }
                    } else if (origem.equals("M")) {
                        System.out.println("Escolha uma arma da mochila:");
                        heroi.mostrarMochila();
                        int indice = scanner.nextInt();

                        int chanceEsquiva = random.nextInt(100);
                        if (chanceEsquiva < inimigo.getChanceEsquiva()) {
                            System.out.println(inimigo.getNome() + " esquivou do seu ataque!");
                        } else {
                            heroi.usarItemMochila(indice, inimigo);
                        }
                    } else {
                        System.out.println("Escolha inválida! Você perdeu a vez.");
                    }
                }

                case 2 -> {
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

                case 3 -> {
                    heroi.mostrarHabilidades();
                    if (!heroi.getHabilidades().isEmpty()) {
                        int indiceHabilidade = scanner.nextInt();
                        heroi.usarHabilidade(indiceHabilidade, inimigo);
                    } else {
                        System.out.println("Você não possui habilidades para usar!");
                    }
                }

                case 4 -> {
                    if (inimigo instanceof Mimico) {
                        System.out.println("Você não pode fugir de um Mímico!");
                    } else {
                        System.out.println("Você fugiu da batalha!");
                        exibirCreditos();
                    }
                }

                default -> System.out.println("Escolha inválida!");
            }

            // Turno do Inimigo
            if (inimigo.getVida() > 0) {
                System.out.println("\n===== TURNO DO INIMIGO =====");

                // Cálculo de esquiva do herói
                int chanceEsquiva = random.nextInt(100);
                if (chanceEsquiva < heroi.getChanceEsquiva()) {
                    System.out.println("Você esquivou do ataque do " + inimigo.getNome() + "!");
                } else {
                    inimigo.atacar(heroi);
                }

                System.out.println("Sua vida: " + heroi.getVida());
            }

            // Verificar o estado do combate
            if (heroi.getVida() <= 0) {
                System.out.println("Você foi derrotado!");

                // Se for um Boss, mostrar mensagem de derrota final
                if (inimigo instanceof DarkKnight || inimigo instanceof Dragao || inimigo instanceof LichKing ||
                        inimigo instanceof LordeMorcego || inimigo instanceof ReiEsqueleto || inimigo instanceof SlimeGigante) {
                    System.out.println("O mundo foi dominado pela escuridão...");
                }
                exibirCreditos();
            }

            if (inimigo.getVida() <= 0) {
                System.out.println("Você derrotou o " + inimigo.getNome() + " e recebeu " + inimigo.getMoedas() + " moedas!");
                heroi.setMoedasTotais(heroi.getMoedasTotais() + inimigo.getMoedas());

                // Se for um Boss, finalizar o jogo com vitória
                if (inimigo instanceof DarkKnight || inimigo instanceof Dragao || inimigo instanceof LichKing ||
                        inimigo instanceof LordeMorcego || inimigo instanceof ReiEsqueleto || inimigo instanceof SlimeGigante) {
                    System.out.println("\n===== PARABÉNS! VOCÊ DERROTOU O BOSS! =====");
                    exibirCreditos();
                }
            }
        }
    }

    private static void exibirCreditos() {
        System.out.println("\n===== FIM DO JOGO =====");
        System.out.println("Obrigado por jogar!");
        System.out.println("Bruno \"Nancom\" Saraiva");
        System.out.println("Gabriel \"Schutz\" Schutz");
        System.out.println("Paulo \"Petruz\" Petruz");
        System.exit(0);  // Finaliza o programa
    }
}
