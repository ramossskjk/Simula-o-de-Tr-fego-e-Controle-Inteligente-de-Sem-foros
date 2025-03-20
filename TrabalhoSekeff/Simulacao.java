import javax.swing.*;
import java.awt.*;

public class Simulacao extends JFrame {
    private Grafo grafo;

    public Simulacao(Grafo grafo) {
        this.grafo = grafo;
        setTitle("Simulação de Tráfego");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new PainelGrafo());
    }

    // Classe interna para desenhar o grafo
    class PainelGrafo extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Desenhar arestas
            for (int i = 0; i < grafo.nos.tamanho(); i++) {
                No no = grafo.nos.obter(i);
                int x1 = (no.id % 10) * 50; // Coordenada X do nó
                int y1 = (no.id / 10) * 50; // Coordenada Y do nó

                for (int j = 0; j < no.arestas.tamanho(); j++) {
                    Aresta aresta = no.arestas.obter(j);
                    int x2 = (aresta.destino.id % 10) * 50; // Coordenada X do destino
                    int y2 = (aresta.destino.id / 10) * 50; // Coordenada Y do destino
                    g.drawLine(x1 + 10, y1 + 10, x2 + 10, y2 + 10); // Linha entre os nós
                }
            }

            // Desenhar nós
            for (int i = 0; i < grafo.nos.tamanho(); i++) {
                No no = grafo.nos.obter(i);
                int x = (no.id % 10) * 50; // Coordenada X do nó
                int y = (no.id / 10) * 50; // Coordenada Y do nó
                g.setColor(Color.BLUE);
                g.fillOval(x, y, 20, 20); // Círculo para representar o nó
                g.setColor(Color.BLACK);
                g.drawString("Nó " + no.id, x, y + 30); // Rótulo do nó
            }
        }
    }

    // Método main - Ponto de entrada do programa
    public static void main(String[] args) {
        // Crie sua rede urbana aqui
        Grafo grafo = new Grafo();
        No no1 = new No(1);
        No no2 = new No(2);
        No no3 = new No(3);
        grafo.adicionarNo(no1);
        grafo.adicionarNo(no2);
        grafo.adicionarNo(no3);
        grafo.adicionarAresta(no1, no2, 10);
        grafo.adicionarAresta(no2, no3, 15);

        // Inicie a interface gráfica
        SwingUtilities.invokeLater(() -> {
            Simulacao simulacao = new Simulacao(grafo);
            simulacao.setVisible(true);
        });
    }
}