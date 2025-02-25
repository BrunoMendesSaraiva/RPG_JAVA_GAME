package rpg.Combate;

import rpg.Personagem.Heroi;
import rpg.Mapa.Mundo;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        System.out.println("Bem-vindo à Jornada Épica!");
        iniciarJogo();
    }

    public static void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);

        // Escolha do Tamanho do Mapa
        int tamanhoMapa = 5;
        boolean escolhaValida = false;

        do {
            System.out.println("Escolha o tamanho do mapa:");
            System.out.println("1. Pequeno (5x5)");
            System.out.println("2. Médio (15x15)");
            System.out.println("3. Grande (25x25)");
            System.out.print("Escolha uma opção: ");

            String escolha = scanner.nextLine();

            try {
                int escolhaTamanho = Integer.parseInt(escolha);
                switch (escolhaTamanho) {
                    case 1 -> {
                        tamanhoMapa = 5;
                        escolhaValida = true;
                    }
                    case 2 -> {
                        tamanhoMapa = 15;
                        escolhaValida = true;
                    }
                    case 3 -> {
                        tamanhoMapa = 25;
                        escolhaValida = true;
                    }
                    default -> System.out.println("Escolha inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            }
        } while (!escolhaValida);

        // Escolha do Nome
        String nomeHeroi;
        do {
            System.out.println("\nEscolha seu nome de herói:");
            nomeHeroi = scanner.nextLine().trim();

            // Verificação de nome vazio, numérico ou caracteres especiais
            if (nomeHeroi.isEmpty() || nomeHeroi.matches("[0-9]+") || !nomeHeroi.matches("[A-Za-z ]+")) {
                System.out.println("Nome inválido! Por favor, insira um nome válido (somente letras e espaços).");
                nomeHeroi = "";
            }
        } while (nomeHeroi.isEmpty());

        // Escolha da Raça
        String raca = "";
        int bonusVida = 0;
        int bonusAtaque = 0;
        escolhaValida = false;

        do {
            System.out.println("\nEscolha sua raça:");
            System.out.println("1. Humano (Equilibrado)");
            System.out.println("2. Elfo (Ataque e Agilidade)");
            System.out.println("3. Anão (Defesa e Vida)");
            System.out.println("4. Orc (Ataque e Vida)");
            String escolhaRaca = scanner.nextLine();

            try {
                int escolhaInt = Integer.parseInt(escolhaRaca);
                switch (escolhaInt) {
                    case 1 -> {
                        raca = "Humano";
                        bonusVida = 10;
                        bonusAtaque = 10;
                        escolhaValida = true;
                    }
                    case 2 -> {
                        raca = "Elfo";
                        bonusVida = 0;
                        bonusAtaque = 15;
                        escolhaValida = true;
                    }
                    case 3 -> {
                        raca = "Anão";
                        bonusVida = 20;
                        bonusAtaque = 5;
                        escolhaValida = true;
                    }
                    case 4 -> {
                        raca = "Orc";
                        bonusVida = 15;
                        bonusAtaque = 15;
                        escolhaValida = true;
                    }
                    default -> System.out.println("Escolha inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            }
        } while (!escolhaValida);

        // Escolha da Classe
        String classe = "";
        int vidaBase = 100;
        int ataqueBase = 20;
        int defesaBase = 10;
        escolhaValida = false;

        do {
            System.out.println("\nEscolha sua classe:");
            System.out.println("1. Guerreiro (Equilibrado)");
            System.out.println("2. Mago (Ataque Alto, Defesa Baixa)");
            System.out.println("3. Arqueiro (Ataque Médio, Agilidade Alta)");
            System.out.println("4. Ladino (Ataque Rápido, Defesa Baixa)");
            String escolhaClasse = scanner.nextLine();

            try {
                int escolhaInt = Integer.parseInt(escolhaClasse);
                switch (escolhaInt) {
                    case 1 -> {
                        classe = "Guerreiro";
                        vidaBase = 120;
                        ataqueBase = 20;
                        defesaBase = 15;
                        escolhaValida = true;
                    }
                    case 2 -> {
                        classe = "Mago";
                        vidaBase = 85;
                        ataqueBase = 35;
                        defesaBase = 6;
                        escolhaValida = true;
                    }
                    case 3 -> {
                        classe = "Arqueiro";
                        vidaBase = 95;
                        ataqueBase = 27;
                        defesaBase = 12;
                        escolhaValida = true;
                    }
                    case 4 -> {
                        classe = "Ladino";
                        vidaBase = 90;
                        ataqueBase = 22;
                        defesaBase = 12;
                        escolhaValida = true;
                    }
                    default -> System.out.println("Escolha inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            }
        } while (!escolhaValida);

        // Confirmar Escolhas
        String confirmar;
        do {
            System.out.println("\nResumo da Criação de Personagem:");
            System.out.println("Nome: " + nomeHeroi);
            System.out.println("Raça: " + raca);
            System.out.println("Classe: " + classe);
            System.out.println("Vida: " + (vidaBase + bonusVida));
            System.out.println("Ataque: " + (ataqueBase + bonusAtaque));
            System.out.println("\nConfirma as escolhas? (S/N)");
            confirmar = scanner.nextLine().toUpperCase();
        } while (!confirmar.equals("S") && !confirmar.equals("N"));

        if (confirmar.equals("S")) {
            Heroi.inicializarHeroi(
                    nomeHeroi,
                    raca,
                    classe,
                    vidaBase + bonusVida,
                    ataqueBase + bonusAtaque,
                    0
            );

            Heroi jogador = Heroi.getInstancia();
            System.out.println("\nVocê criou um(a) " + raca + " " + classe + " chamado(a) " + jogador.getNome());
            Mundo mundo = new Mundo(tamanhoMapa);
            mundo.explorar(jogador);
        } else {
            System.out.println("Criação de personagem cancelada.");
        }

        scanner.close();
    }
}
