public class CartaValorMais extends CartaNormal {
  @Override
  protected int calcularValor() {
    var valor = super.calcularValor();
    return this.éPrimo(valor) ? valor * 3 : valor;
  }

  private boolean éPrimo(int número) {
    for (var i = 2; i < número / 2 + 1; i++) {
      if (número % i == 0) {
        return false;
      }
    }

    return true;
  }
}