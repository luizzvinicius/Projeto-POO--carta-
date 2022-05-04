import java.util.Objects;
import java.util.Random;

public class CartaNormal {
  public static String[] NUMEROS = {
      "Ás", "Dois", "Três", "Quarto", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez",
      "Valete", "Dama", "Rei"
  };

  public static String[] NAIPES = { "Paus", "Ouros", "Copas", "Espadas" };

  private int numero, naipe, valor;

  private static Random random = new Random();

  public CartaNormal() {
    this.numero = random.nextInt(1, 13);
    this.naipe = random.nextInt(2, 5);
    this.valor = this.calcularValor();
  }

  protected int calcularValor() {
    return getNumero() * getNaipe();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNumero(), getNaipe());
  }

  public boolean equals(CartaNormal outra) {
    return this.getNumero() == outra.getNumero() && this.getNaipe() == outra.getNaipe();
  }

  @Override
  public String toString() {
    return String.format("%s de %s", NUMEROS[getNumero() - 1], NAIPES[getNaipe() - 2]);
  }

  public int getNumero() {
    return this.numero;
  }

  public int getNaipe() {
    return this.naipe;
  }

  public int getValor() {
    return this.valor;
  }
}