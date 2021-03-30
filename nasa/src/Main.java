import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Projeto JokenPo NASA");
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int jogador = 0;
		int maquina = 0;

		while (true) {
			System.out.println("Sua jogada: (PAPEL, TESOURA, PEDRA)");
			String jogada = sc.nextLine();

			int indexJogada = Play.valueOf(jogada.toUpperCase()).ordinal();
			int randomJogadaMaquina = random.nextInt(3);
			Play jogadaMaquina = Play.values()[randomJogadaMaquina];
			System.out.println("Jogada maquina: " + jogadaMaquina);

			boolean papelPedra = indexJogada == 0 && randomJogadaMaquina == 2;
			boolean pedraPapel = indexJogada == 2 && randomJogadaMaquina == 0;
			if (indexJogada == randomJogadaMaquina)
				System.out.println("EMPATE!!\n");
			else if (!pedraPapel && indexJogada > randomJogadaMaquina || papelPedra) {
				System.out.println("VOCE GANHOU!!\n");
				jogador++;
			}
			else {				
				System.out.println("VOCE PERDEU!!\n");
				maquina++;
			}
			
			System.out.println("Jogador: " + jogador + "\nMaquina: " + maquina);
		}
	}
}
