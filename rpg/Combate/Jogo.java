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
        int tamanhoMapa = 5; // Default para 5x5
        System.out.println("Escolha o tamanho do mapa:");
        System.out.println("1. Pequeno (5x5)");
        System.out.println("2. Médio (15x15)");
        System.out.println("3. Grande (25x25)");
        System.out.print("Escolha uma opção: ");
        int escolhaTamanho = scanner.nextInt();

        switch (escolhaTamanho) {
            case 1 -> tamanhoMapa = 5;
            case 2 -> tamanhoMapa = 15;
            case 3 -> tamanhoMapa = 25;
            default -> {
                System.out.println("Escolha inválida! O tamanho padrão será 5x5.");
                tamanhoMapa = 5;
            }
        }

        // Escolha do Nome
        System.out.println("\nEscolha seu nome de herói:");
        scanner.nextLine(); // Consumindo o \n pendente
        String nomeHeroi = scanner.nextLine();

        // Escolha da Raça
        System.out.println("\nEscolha sua raça:");
        System.out.println("1. Humano (Equilibrado)");
        System.out.println("2. Elfo (Ataque e Agilidade)");
        System.out.println("3. Anão (Defesa e Vida)");
        System.out.println("4. Orc (Ataque e Vida)");
        int escolhaRaca = scanner.nextInt();
        String raca = "";
        int bonusVida = 0;
        int bonusAtaque = 0;
        int bonusDefesa = 0;

        switch (escolhaRaca) {
            case 1 -> {
                raca = "Humano";
                bonusVida = 10;
                bonusAtaque = 10;
                bonusDefesa = 10;
            }
            case 2 -> {
                raca = "Elfo";
                bonusVida = 0;
                bonusAtaque = 15;
                bonusDefesa = 5;
            }
            case 3 -> {
                raca = "Anão";
                bonusVida = 20;
                bonusAtaque = 5;
                bonusDefesa = 15;
            }
            case 4 -> {
                raca = "Orc";
                bonusVida = 15;
                bonusAtaque = 15;
                bonusDefesa = 0;
            }
            default -> {
                System.out.println("Escolha inválida! Definindo como Humano.");
                raca = "Humano";
                bonusVida = 10;
                bonusAtaque = 10;
                bonusDefesa = 10;
            }
        }

        // Escolha da Classe
        System.out.println("\nEscolha sua classe:");
        System.out.println("1. Guerreiro (Equilibrado)");
        System.out.println("2. Mago (Ataque Alto, Defesa Baixa)");
        System.out.println("3. Arqueiro (Ataque Médio, Agilidade Alta)");
        System.out.println("4. Ladino (Ataque Rápido, Defesa Baixa)");
        int escolhaClasse = scanner.nextInt();
        String classe = "";
        int vidaBase = 100;
        int ataqueBase = 20;
        int defesaBase = 10;

        switch (escolhaClasse) {
            case 1 -> {
                classe = "Guerreiro";
                vidaBase = 120;
                ataqueBase = 20;
                defesaBase = 15;
            }
            case 2 -> {
                classe = "Mago";
                vidaBase = 85;
                ataqueBase = 35;
                defesaBase = 6;
            }
            case 3 -> {
                classe = "Arqueiro";
                vidaBase = 95;
                ataqueBase = 27;
                defesaBase = 12;
            }
            case 4 -> {
                classe = "Ladino";
                vidaBase = 90;
                ataqueBase = 22;
                defesaBase = 12;
            }
            default -> {
                System.out.println("Escolha inválida! Definindo como Guerreiro.");
                classe = "Guerreiro";
                vidaBase = 130;
                ataqueBase = 22;
                defesaBase = 18;
            }
        }

        // Confirmar Escolhas
        System.out.println("\nResumo da Criação de Personagem:");
        System.out.println("Nome: " + nomeHeroi);
        System.out.println("Raça: " + raca);
        System.out.println("Classe: " + classe);
        System.out.println("Vida: " + (vidaBase + bonusVida));
        System.out.println("Ataque: " + (ataqueBase + bonusAtaque));
        System.out.println("Defesa: " + (defesaBase + bonusDefesa));
        System.out.println("\nConfirma as escolhas? (S/N)");
        char confirmar = scanner.next().toUpperCase().charAt(0);

        if (confirmar == 'S') {
            // Criar o jogador com base nas escolhas
            Heroi.inicializarHeroi(
                    nomeHeroi,
                    raca,
                    classe,
                    vidaBase + bonusVida,
                    ataqueBase + bonusAtaque,
                    defesaBase + bonusDefesa,
                    0 // Iniciando com 0 moedas
            );

            Heroi jogador = Heroi.getInstancia();

            System.out.println("\nVocê criou um(a) " + raca + " " + classe + " chamado(a) " + jogador.getNome());
            // Iniciar Exploração com o tamanho do mapa escolhido
            Mundo mundo = new Mundo(tamanhoMapa);
            mundo.explorar(jogador);
        } else {
            System.out.println("Criação de personagem cancelada.");
        }

        scanner.close();
    }
}
