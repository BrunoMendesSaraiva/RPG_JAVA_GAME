
package rpg.Eventos;

import rpg.Combate.Combate;
import rpg.Item.ItemBase;
import java.util.Scanner;
import rpg.Arma.*;
import rpg.Item.ItemCura;
import rpg.Item.ItemDano;
import rpg.Personagem.Inimigos.Especiais.Mimico;
import java.util.Random;
import rpg.Personagem.Inimigos.Inimigo;
import rpg.Personagem.Heroi;
import rpg.Pocoes.ElixirOfRenewal;
import rpg.Pocoes.TearsOfPhoenix;
import rpg.Pocoes.WarriorRespite;
import rpg.Personagem.Inimigos.Bosses.DarkKnight;
import rpg.Personagem.Inimigos.Bosses.Dragao;
import rpg.Personagem.Inimigos.Bosses.LichKing;
import rpg.Personagem.Inimigos.Bosses.LordeMorcego;
import rpg.Personagem.Inimigos.Bosses.ReiEsqueleto;
import rpg.Personagem.Inimigos.Bosses.SlimeGigante;
import rpg.Personagem.Inimigos.Comuns.Esqueleto;
import rpg.Personagem.Inimigos.Comuns.Goblin;
import rpg.Personagem.Inimigos.Comuns.Morcego;
import rpg.Personagem.Inimigos.Comuns.Orc;
import rpg.Personagem.Inimigos.Comuns.Slime;

public class Eventos {
    private static final Scanner scanner = new Scanner(System.in);

    // ===============================
    // EVENTO: Encontrar Inimigo
    // ===============================
    public static void encontrarInimigo(Heroi heroi) {
        System.out.println("Você sente algo estranho...");
        try {
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Sorteia qual inimigo comum será encontrado com novas frequências
        int sorteInimigo = new Random().nextInt(100);
        Inimigo inimigo;

        if (sorteInimigo < 30) {
            inimigo = new Esqueleto();
            System.out.println("Um Esqueleto apareceu do nada!");
        } else if (sorteInimigo < 60) {
            inimigo = new Goblin();
            System.out.println("Você foi emboscado por um Goblin traiçoeiro!");
        } else if (sorteInimigo < 80) {
            inimigo = new Morcego();
            System.out.println("Um Morcego gigante desceu do teto da caverna!");
        } else if (sorteInimigo < 95) {
            inimigo = new Orc();
            System.out.println("Um Orc poderoso surge à sua frente!");
        } else {
            inimigo = new Slime();
            System.out.println("Um Slime gosmento bloqueia seu caminho!");
        }

        // Chama o combate direto, sem narrativa adicional
        Combate.iniciarCombate(heroi, inimigo);
    }

    // ===============================
    // EVENTO: Encontrar Arma
    // ===============================
    public static void encontrarArma(Heroi heroi) {
        int sorteArma = new Random().nextInt(100); // Ajuste para porcentagens
        ArmaBase arma;

        if (sorteArma < 10) {
            arma = new HeavensBlade();
            System.out.println("Você encontrou a raríssima Heaven's Blade!");
        } else if (sorteArma < 25) {
            arma = new Frostmourne();
            System.out.println("Você encontrou a maldita Frostmourne!");
        } else if (sorteArma < 40) {
            arma = new Thunderfury();
            System.out.println("Você encontrou a lendária Thunderfury!");
        } else if (sorteArma < 55) {
            arma = new InfernosEdge();
            System.out.println("Você encontrou a flamejante Inferno's Edge!");
        } else if (sorteArma < 70) {
            arma = new DragonsBane();
            System.out.println("Você encontrou a poderosa Dragons Bane!");
        } else if (sorteArma < 85) {
            arma = new BladeOfTheEternalFlame();
            System.out.println("Você encontrou a Blade of the Eternal Flame!");
        } else if (sorteArma < 95) {
            arma = new ShadowReaver();
            System.out.println("Você encontrou a mística Shadow Reaver!");
        } else {
            arma = new Shadowfang();
            System.out.println("Você encontrou as sombrias Shadowfang!");
        }

        adicionarAoInventario(heroi, arma);
    }



    // ===============================
    // EVENTO: Encontrar Poção
    // ===============================
    public static void encontrarPocao(Heroi heroi) {
        int sortePocao = new Random().nextInt(100); // Ajuste para porcentagens
        ItemBase pocao;

        if (sortePocao < 20) {
            pocao = new ElixirOfRenewal();
            System.out.println("Você encontrou um Elixir of Renewal!");
        } else if (sortePocao < 50) {
            pocao = new TearsOfPhoenix();
            System.out.println("Você encontrou Tears of Phoenix!");
        } else {
            pocao = new WarriorRespite();
            System.out.println("Você encontrou Warrior Respite!");
        }

        adicionarAoInventario(heroi, pocao);
    }


    // ===============================
    // EVENTO: Encontrar Baú
    // ===============================
    public static void encontrarBau(Heroi heroi) {
        System.out.println("Você decidiu abrir o baú...");
        try {
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sorteMimico = new Random().nextInt(100);
        if (sorteMimico < 20) { // 20% de chance de Mímico
            System.out.println("O baú era um Mímico! Prepare-se para lutar!");
            Mimico mimico = new Mimico();
            Combate.iniciarCombate(heroi, mimico);
        } else {
            encontrarArma(heroi); // Caso contrário, encontra uma arma
        }
    }


    // ===============================
    // EVENTO: Encontrar Boss
    // ===============================
    public static void encontrarBoss(Heroi heroi) {
        System.out.println("Você sente uma presença poderosa se aproximando...");
        try {
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sorteBoss = new Random().nextInt(100); // Ajuste para porcentagens
        Inimigo boss;

        if (sorteBoss < 15) {
            boss = new DarkKnight();
            System.out.println("O Cavaleiro das Trevas emerge das sombras!");
        } else if (sorteBoss < 30) {
            boss = new Dragao();
            System.out.println("Um Dragão colossal aparece no horizonte!");
        } else if (sorteBoss < 50) {
            boss = new LichKing();
            System.out.println("O Rei Lich desperta de seu sono eterno!");
        } else if (sorteBoss < 70) {
            boss = new LordeMorcego();
            System.out.println("O Lorde Morcego desce dos céus!");
        } else if (sorteBoss < 85) {
            boss = new ReiEsqueleto();
            System.out.println("O Rei Esqueleto se ergue das cinzas!");
        } else {
            boss = new SlimeGigante();
            System.out.println("Um Slime Gigante bloqueia seu caminho!");
        }

        // Inicia o combate com o Boss
        Combate.iniciarCombate(heroi, boss);
    }


    // ===============================
    // METODO AUXILIAR: Adicionar ao Inventário
    // ===============================
    private static void adicionarAoInventario(Heroi heroi, ItemBase item) {
        // Verifica se é um item de dano (Arma) ou de cura (Poção)
        if (item instanceof ItemDano) {
            int poderAtaque = ((ItemDano) item).getPoderAtaque();
            System.out.println(item.getNome() + " foi encontrada com " + poderAtaque + " de dano!");
        } else if (item instanceof ItemCura) {
            int poderCura = ((ItemCura) item).getPoderCura();
            System.out.println(item.getNome() + " foi encontrada com " + poderCura + " de cura!");
        } else {
            System.out.println(item.getNome() + " foi encontrada.");
        }

        // Pergunta onde o jogador quer guardar o item
        System.out.println("Deseja guardar na Mochila (M) ou no Cinto (C)?");
        String escolha = scanner.nextLine().toUpperCase();
        if (escolha.equals("M")) {
            heroi.adicionarNaMochila(item);
        } else {
            heroi.adicionarAoCinto(item);
        }
    }
}
