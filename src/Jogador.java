public class Jogador {
  private String nome;
  private int pontos;
  private CartaNormal cartaAtual;

  public Jogador(String nome) {
    this.nome = nome;
  }

  public void setCartaAtual(CartaNormal carta) {
    this.cartaAtual = carta;
  }

  public void somarPontos(int pontos) {
    this.pontos += pontos;
  }

  public String getNome() {
    return this.nome;
  }

  public int getPontos() {
    return this.pontos;
  }

  public CartaNormal getCartaAtual() {
    return this.cartaAtual;
  }

  @Override
  public String toString() {
    return this.nome;
  }
}