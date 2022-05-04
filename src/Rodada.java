import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Rodada {
  private List<Jogador> jogadores;
  private int numRodadas;
  private int tipoCarta;

  public Rodada(Jogador[] jogadores, int numRodadas, int tipoCarta) {
    this.jogadores = Arrays.asList(jogadores);
    this.numRodadas = numRodadas;
    this.tipoCarta = tipoCarta;
  }

  public void iniciar() {
    var numJogadores = this.jogadores.size();
    var qntsRecebemPontos = Math.min(numJogadores, 3);
    var jogadoresOrdPorCarta = new ArrayList<Jogador>();
    var cartas = new CartaNormal[numJogadores];

    // Para desduplicar as cartas
    var setCartas = new HashSet<CartaNormal>(numJogadores);

    for (var i = 1; i <= this.numRodadas; i++) {
      setCartas.clear();
      while (setCartas.size() < numJogadores) {
        setCartas.add(this.criaCarta());
      }
      cartas = setCartas.toArray(cartas);

      System.out.printf("Rodada %d:\n", i);

      for (var j = 0; j < numJogadores; j++) {
        var jogador = jogadores.get(j);
        var carta = cartas[j];
        jogador.setCartaAtual(carta);
        System.out.printf("%s recebeu %s, valor da carta %d\n", jogador, carta, carta.getValor());
      }

      jogadoresOrdPorCarta.clear();
      jogadoresOrdPorCarta.addAll(this.jogadores);
      Collections.sort(jogadoresOrdPorCarta, Rodada::compararJogadorPorCarta);

      for (var j = 0; j < qntsRecebemPontos; j++) {
        var jogador = jogadoresOrdPorCarta.get(j);
        var pontos = qntsRecebemPontos - j;
        jogador.somarPontos(pontos);
        System.out.printf("%s recebeu %d pontos\n", jogador, pontos);
      }

      System.out.printf("\nVencedor da rodada é %s\n\n", jogadoresOrdPorCarta.get(0));
    }

    System.out.printf("-------- Fim do jogo --------\n");

    for (var jogador : this.jogadores) {
      System.out.printf("%s terminou com %d pontos\n", jogador, jogador.getPontos());
    }

    System.out.printf("Vencedor do jogo é %s\n", Collections.max(this.jogadores, Rodada::compararJogadorPorPontos));
  }

  private CartaNormal criaCarta() {
    if (this.tipoCarta == 1) {
      return new CartaNormal();
    } else if (this.tipoCarta == 2) {
      return new CartaNaipeMais();
    } else if (this.tipoCarta == 3) {
      return new CartaValorMais();
    }

    return null;
  }

  private static int compararJogadorPorCarta(Jogador jogador1, Jogador jogador2) {
    return jogador2.getCartaAtual().getValor() - jogador1.getCartaAtual().getValor();
  }

  private static int compararJogadorPorPontos(Jogador jogador1, Jogador jogador2) {
    return jogador1.getPontos() - jogador2.getPontos();
  }
}