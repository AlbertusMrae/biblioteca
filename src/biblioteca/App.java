package biblioteca;

/**
 * Programa standalone inicial do TP1 — Sistema de Biblioteca.
 * Objetivo: validar o ambiente (JDK 21) com tipos primitivos,
 * operadores e controle de fluxo, sem orientação a objetos.
 */
public class App {

	public static void main(String[] args) {
		System.out.println("=== Biblioteca - validacao do ambiente (TP1) ===");
		System.out.println();

		// Tipos primitivos (cenario ficticio de emprestimo)
		int diasAtraso = 5;
		double valorMultaPorDia = 2.50;
		int livrosEmprestados = 2;
		int limiteEmprestimos = 3;
		boolean usuarioAtivo = true;

		// Operadores aritmeticos e de atribuicao
		double multaTotal = diasAtraso * valorMultaPorDia;
		int vagasRestantes = limiteEmprestimos - livrosEmprestados;
		boolean podeEmprestar = usuarioAtivo && vagasRestantes > 0 && multaTotal == 0.0;

		System.out.println("Dias de atraso: " + diasAtraso);
		System.out.println("Multa por dia: R$ " + valorMultaPorDia);
		System.out.println("Multa total: R$ " + multaTotal);
		System.out.println("Livros emprestados: " + livrosEmprestados + " / " + limiteEmprestimos);
		System.out.println("Vagas restantes: " + vagasRestantes);
		System.out.println();

		// Controle de fluxo: if / else
		if (podeEmprestar) {
			System.out.println("Status: novo emprestimo AUTORIZADO.");
		} else if (!usuarioAtivo) {
			System.out.println("Status: emprestimo NEGADO - usuario inativo.");
		} else if (multaTotal > 0.0) {
			System.out.println("Status: emprestimo NEGADO - ha multa pendente.");
		} else {
			System.out.println("Status: emprestimo NEGADO - limite de livros atingido.");
		}
		System.out.println();

		// Controle de fluxo: for (simulacao de multa acumulada dia a dia)
		System.out.println("Simulacao de multa acumulada:");
		double acumulado = 0.0;
		for (int dia = 1; dia <= diasAtraso; dia++) {
			acumulado += valorMultaPorDia;
			System.out.println("  Dia " + dia + " -> R$ " + acumulado);
		}
		System.out.println();

		// Controle de fluxo: switch (faixa de atraso)
		int faixa;
		if (diasAtraso <= 0) {
			faixa = 0;
		} else if (diasAtraso <= 3) {
			faixa = 1;
		} else if (diasAtraso <= 7) {
			faixa = 2;
		} else {
			faixa = 3;
		}

		switch (faixa) {
		case 0:
			System.out.println("Faixa de atraso: em dia.");
			break;
		case 1:
			System.out.println("Faixa de atraso: leve (ate 3 dias).");
			break;
		case 2:
			System.out.println("Faixa de atraso: moderado (4 a 7 dias).");
			break;
		default:
			System.out.println("Faixa de atraso: grave (acima de 7 dias).");
			break;
		}

		System.out.println();
		System.out.println("Ambiente OK: programa compilou e executou com sucesso.");
	}
}
