import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var numJogadores = perguntarNumJogadores(scanner);
    var numRodadas = perguntarNumRodadas(scanner);
    var tipoCarta = escolherTipoCarta(scanner);
    scanner.nextLine(); // Gambiarra

    var jogadores = new Jogador[numJogadores];
    for (var i = 0; i < numJogadores; i++) {
      System.out.printf("Digite o nome do %dº jogador: ", i + 1);
      var nome = scanner.nextLine();

      jogadores[i] = new Jogador(nome);
      System.out.printf("Jogador %s cadastrado\n\n", nome); 
    }

    scanner.close();

    var rodada = new Rodada(jogadores, numRodadas, tipoCarta);
    rodada.iniciar();
  }

  public static int perguntarNumJogadores(Scanner scanner) {
    var numJogadores = 0;

    while (numJogadores < 2 || numJogadores > 4) {
      System.out.print("Digite o número de jogadores que vão participar da rodada: ");
      numJogadores = scanner.nextInt();
      System.out.println();
    }

    return numJogadores;
  }

  public static int perguntarNumRodadas(Scanner scanner) {
    var numRodadas = 0;

    while (numRodadas < 1 || numRodadas > 5) {
      System.out.print("Digite o número de rodadas a serem jogadas: ");
      numRodadas = scanner.nextInt();
      System.out.println();
    }

    return numRodadas;
  }

  public static int escolherTipoCarta(Scanner scanner) {
    var opcoes = "Tipos de cartas disponíveis:\n";
    opcoes += "1. Carta Normal\n";
    opcoes += "2. Carta Naipe+\n";
    opcoes += "3. Carta Valor+\n";
    System.out.println(opcoes);

    var tipo = 0;
    while (tipo < 1 || tipo > 3) {
      System.out.print("Digite o tipo que será usado: ");
      tipo = scanner.nextInt();
      System.out.println();
    }

    return tipo;
  }
}