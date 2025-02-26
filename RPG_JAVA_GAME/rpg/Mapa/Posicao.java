package rpg.Mapa;

public class Posicao {
    private int x;
    private int y;

    // Construtor
    public Posicao(int novox, int novoy) {
        this.x = novox;
        this.y = novoy;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Sobrescrevendo o equals() para comparar posições
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Posicao posicao = (Posicao) obj;
        return x == posicao.x && y == posicao.y;
    }

    // Para exibir a posição como texto
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
