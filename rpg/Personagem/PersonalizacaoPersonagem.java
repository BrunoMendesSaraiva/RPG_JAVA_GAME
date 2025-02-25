// Classe: PersonalizacaoPersonagem
package rpg.Personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import rpg.Personagem.Habilidades.Habilidade;
import rpg.Personagem.Habilidades.Raca.Adaptabilidade;
import rpg.Personagem.Habilidades.Raca.AgilidadeSobrenatural;
import rpg.Personagem.Habilidades.Raca.Fortaleza;
import rpg.Personagem.Habilidades.Raca.FuriaMelkor;
import rpg.Personagem.Habilidades.Classe.ForcaBruta;
import rpg.Personagem.Habilidades.Classe.MagiaArdente;
import rpg.Personagem.Habilidades.Classe.PrecisaoMortal;

public class PersonalizacaoPersonagem {

    public static Heroi criarPersonagem() {
        Scanner scanner = new Scanner(System.in);
        String nomeHeroi = "";
        String raca = "";
        String classe = "";
        int bonusVida = 0, bonusForca = 0, bonusAgilidade = 0, bonusInteligencia = 0;
        int bonusAtaque = 0, bonusDefesa = 0;

        // ===============================
        // Escolha do Nome
        // ===============================
        while (nomeHeroi.isBlank()) {
            System.out.print("Escolha o nome do seu herói: ");
            nomeHeroi = scanner.nextLine().trim();
            if (nomeHeroi.isBlank()) {
                System.out.println("Nome não pode ser vazio! Digite um nome válido.");
            }
        }

        // ===============================
        // Escolha da Raça
        // ===============================
        int escolhaRaca = -1;
        while (escolhaRaca < 1 || escolhaRaca > 4) {
            System.out.println("\nEscolha sua raça:");
            System.out.println("1. Humano (Equilibrado)");
            System.out.println("2. Elfo (Ataque e Agilidade)");
            System.out.println("3. Anão (Defesa e Vida)");
            System.out.println("4. Orc (Ataque e Vida)");
            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                escolhaRaca = scanner.nextInt();
                scanner.nextLine(); // Consumir quebra de linha
            } else {
                scanner.nextLine(); // Consumir entrada inválida
                escolhaRaca = -1;
            }

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
                    System.out.println("Escolha inválida! Tente novamente.");
                }
            }
        }

        // ===============================
        // Escolha da Classe
        // ===============================
        int escolhaClasse = -1;
        while (escolhaClasse < 1 || escolhaClasse > 4) {
            System.out.println("\nEscolha sua classe:");
            System.out.println("1. Guerreiro (Equilibrado)");
            System.out.println("2. Mago (Ataque Alto, Defesa Baixa)");
            System.out.println("3. Arqueiro (Ataque Médio, Agilidade Alta)");
            System.out.println("4. Ladino (Ataque Rápido, Defesa Baixa)");
            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                escolhaClasse = scanner.nextInt();
                scanner.nextLine(); // Consumir quebra de linha
            } else {
                scanner.nextLine(); // Consumir entrada inválida
                escolhaClasse = -1;
            }

            switch (escolhaClasse) {
                case 1 -> {
                    classe = "Guerreiro";
                    bonusVida += 20;
                    bonusAtaque += 15;
                    bonusDefesa += 10;
                }
                case 2 -> {
                    classe = "Mago";
                    bonusVida += 10;
                    bonusAtaque += 30;
                    bonusDefesa += 5;
                }
                case 3 -> {
                    classe = "Arqueiro";
                    bonusVida += 15;
                    bonusAtaque += 20;
                    bonusDefesa += 8;
                }
                case 4 -> {
                    classe = "Ladino";
                    bonusVida += 15;
                    bonusAtaque += 20;
                    bonusDefesa += 7;
                }
                default -> {
                    System.out.println("Escolha inválida! Tente novamente.");
                }
            }
        }

        // ===============================
        // Confirmação das Escolhas
        // ===============================
        char confirmar = 'N';
        while (confirmar != 'S' && confirmar != 'N') {
            System.out.println("\nResumo da Criação de Personagem:");
            System.out.println("Nome: " + nomeHeroi);
            System.out.println("Raça: " + raca);
            System.out.println("Classe: " + classe);
            System.out.println("Vida: " + bonusVida);
            System.out.println("Ataque: " + bonusAtaque);
            System.out.println("Defesa: " + bonusDefesa);
            System.out.print("\nConfirma as escolhas? (S/N): ");
            confirmar = scanner.next().toUpperCase().charAt(0);
        }

        if (confirmar == 'S') {
            // Criação do herói com base nas escolhas
            Heroi heroi = new Heroi(nomeHeroi, raca, classe, bonusVida, bonusAtaque, bonusDefesa, 0);
            System.out.println("\nVocê criou um(a) " + raca + " " + classe + " chamado(a) " + heroi.getNome());
            return heroi;
        } else {
            System.out.println("Criação de personagem cancelada.");
            return null;
        }
    }
}
