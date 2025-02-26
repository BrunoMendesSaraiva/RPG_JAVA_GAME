package rpg.Mapa;

import java.util.Random;
import rpg.Personagem.Heroi;
import rpg.Eventos.Eventos;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Mapa {
    private String[][] mapa;
    private int tamanho;
    private int x;
    private int y;
    private Random random;

    // Construtor que recebe o tamanho do mapa
    public Mapa(int tamanho) {
        this.tamanho = tamanho;
        this.mapa = new String[tamanho][tamanho];
        this.random = new Random();
        inicializarMapa();
    }

    // Inicializa o mapa com eventos aleatórios
    private void inicializarMapa() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                mapa[i][j] = "."; // Todos os espaços começam vazios
            }
        }

        // Coloca o Boss obrigatoriamente
        colocarBoss();

        // Adiciona eventos aleatórios no mapa
        int quantidadeEventos = (tamanho * tamanho) / 5; // 20% do mapa com eventos
        for (int k = 0; k < quantidadeEventos; k++) {
            adicionarEventoAleatorio();
        }

        // Define a posição inicial do herói no centro do mapa
        x = tamanho / 2;
        y = tamanho / 2;
        mapa[x][y] = "H";
    }

    // Coloca o Boss no mapa (1 por mapa)
    private void colocarBoss() {
        int eventoX, eventoY;
        do {
            eventoX = random.nextInt(tamanho);
            eventoY = random.nextInt(tamanho);
        } while (mapa[eventoX][eventoY].equals("H"));
        mapa[eventoX][eventoY] = "X"; // Boss
    }

    // Adiciona um evento aleatório no mapa
    private void adicionarEventoAleatorio() {
        int eventoX, eventoY;
        do {
            eventoX = random.nextInt(tamanho);
            eventoY = random.nextInt(tamanho);
        } while (!mapa[eventoX][eventoY].equals("."));

        // Sorteia entre Baú ou Inimigo
        int tipoEvento = random.nextInt(2); // 0 para Baú, 1 para Inimigo

        if (tipoEvento == 0) {
            mapa[eventoX][eventoY] = "B"; // Baú
        } else {
            mapa[eventoX][eventoY] = "I"; // Inimigo
        }
    }

    public void mostrarMapa() {
        System.out.println("\nMapa:");

        // Construindo o topo e a base da moldura dinamicamente
        StringBuilder linhaTopo = new StringBuilder("╔");
        StringBuilder linhaBase = new StringBuilder("╚");
        for (int i = 0; i < tamanho; i++) {
            linhaTopo.append("═══");
            linhaBase.append("═══");
        }
        linhaTopo.append("╗");
        linhaBase.append("╝");

        // Imprimindo a borda superior
        System.out.println(linhaTopo);

        // Imprimindo o conteúdo do mapa com bordas laterais e cores
        for (int i = 0; i < tamanho; i++) {
            System.out.print("║"); // Borda lateral esquerda
            for (int j = 0; j < tamanho; j++) {
                String elemento;

                // Mapeando os caracteres para símbolos e cores personalizados
                switch (mapa[i][j]) {
                    case ".":
                        elemento = " - "; // Espaço Vazio (Padrão)
                        break;
                    case "H":
                        elemento = "\u001B[32m @ \u001B[0m"; // Herói em Verde
                        break;
                    case "I":
                        elemento = "\u001B[31m X \u001B[0m"; // Inimigo em Vermelho
                        break;
                    case "B":
                        elemento = "\u001B[33m $ \u001B[0m"; // Baú em Amarelo
                        break;
                    case "X":
                        elemento = "\u001B[35m & \u001B[0m"; // Boss em Roxo
                        break;
                    default:
                        elemento = " ? "; // Caso algum símbolo inesperado apareça
                        break;
                }

                System.out.print(elemento);
            }
            System.out.println("║"); // Borda lateral direita
        }

        // Imprimindo a borda inferior
        System.out.println(linhaBase);
    }


    // Retorna a posição atual do herói no formato "(x, y)"
    public String getPosicao() {
        return "Posição atual: (" + x + ", " + y + ")";
    }

    // Verifica o evento na posição atual
    public String verificarPosicao() {
        return mapa[x][y];
    }

    // Limpa um evento da posição atual
    public void limparPosicao() {
        mapa[x][y] = "H";
    }

    // Movimentação para Norte
    public void moverNorte(Heroi heroi) {
        if (x > 0) {
            mapa[x][y] = "."; // Limpa a posição atual
            x--;
            verificarEvento(heroi);
            mapa[x][y] = "H"; // Atualiza a nova posição
        } else {
            System.out.println("Você não pode se mover para o Norte.");
        }
    }

    // Movimentação para Sul
    public void moverSul(Heroi heroi) {
        if (x < tamanho - 1) {
            mapa[x][y] = ".";
            x++;
            verificarEvento(heroi);
            mapa[x][y] = "H";
        } else {
            System.out.println("Você não pode se mover para o Sul.");
        }
    }

    // Movimentação para Leste
    public void moverLeste(Heroi heroi) {
        if (y < tamanho - 1) {
            mapa[x][y] = ".";
            y++;
            verificarEvento(heroi);
            mapa[x][y] = "H";
        } else {
            System.out.println("Você não pode se mover para o Leste.");
        }
    }

    // Movimentação para Oeste
    public void moverOeste(Heroi heroi) {
        if (y > 0) {
            mapa[x][y] = ".";
            y--;
            verificarEvento(heroi);
            mapa[x][y] = "H";
        } else {
            System.out.println("Você não pode se mover para o Oeste.");
        }
    }

    // Verifica e inicia evento na posição atual
    private void verificarEvento(Heroi heroi) {
        String evento = mapa[x][y];
        switch (evento) {
            case "X" -> {
                Eventos.encontrarBoss(heroi);
                limparPosicao();
            }
            case "I" -> {
                Eventos.encontrarInimigo(heroi);
                limparPosicao();
            }
            case "B" -> {
                System.out.println("Você encontrou um Baú! Vamos ver o que tem dentro...");
                Eventos.encontrarBau(heroi);
                limparPosicao();
            }
            default -> System.out.println("Não há nada de interessante aqui.");
        }
    }
}
