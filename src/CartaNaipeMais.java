public class CartaNaipeMais extends CartaNormal {
  @Override
  protected int calcularValor() {
    return this.getNumero();
  }

  @Override
  public int hashCode() {
    return this.getNumero();
  }

  @Override
  public boolean equals(CartaNormal outra) {
    return this.getNumero() == outra.getNumero();
  }

  @Override
  public String toString() {
    return String.format("%s", NUMEROS[getNumero() - 1]);
  }
}