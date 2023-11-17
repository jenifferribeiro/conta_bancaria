package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {
	
	static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcao;
		
		/*Criar Objetos da classe conta para testes*/
		
		Conta c1 = new Conta(1, 123, 1, "Jeniffer Ribeiro", 100000.00f);
		c1.visualizar();
		System.out.println("Exibir o saldo: " + c1.getSaldo());
		c1.setSaldo(200000.00f);
		c1.visualizar();
		c1.sacar(210000.00f);
		c1.visualizar();
		c1.depositar(5000.00f);
		c1.visualizar();
		
		
		while (true) {
			
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "*************************************************");
			System.out.println("                                                 ");
			System.out.println("       BANCO DO BRAZIL COM Z                     ");
			System.out.println("                                                 ");
			System.out.println("*************************************************");
			System.out.println("                                                 ");
			System.out.println("     1 - Criar conta                             ");
			System.out.println("     2 - Listar todas as contas                  ");
			System.out.println("     3 - Buscar conta por numero                 ");
			System.out.println("     4 - Atualizar dados da conta                ");
			System.out.println("     5 - Apagar conta                            ");
			System.out.println("     6 - Sacar                                   ");
			System.out.println("     7 - Depositar                               ");
			System.out.println("     8 - Transferir valores entre contas         ");
			System.out.println("     9 - Sair                                    ");
			System.out.println("                                                 ");
			System.out.println("*************************************************");
			System.out.println("Entre com a opção desejada:                      ");
			System.out.println("                                                 " + Cores.TEXT_RESET);
			
			opcao = leia.nextInt();
			
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\n Banco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar conta /n/n");
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Listar todas as contas /n/n");
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Consultar dados da conta - por número/n/n");
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Atualizar dados da conta /n/n");
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Apagar a conta /n/n");
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Saque /n/n");
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Depósito /n/n");
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Transferência entre contas /n/n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT +"\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}			
		}
	}
		public static void sobre() {
			System.out.println("*********************************************************");
			System.out.println("Projeto Desenvolvido por: ");
			System.out.println("Jeniffer Ribeiro");
			System.out.println("github.com/jenifferribeiro");
			System.out.println("*********************************************************");
		}
	}
	
	


