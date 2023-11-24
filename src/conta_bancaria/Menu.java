package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	
	static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 100);
		contas.cadastrar(cp1);
		
						
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
			
			try {
				opcao = leia.nextInt();
			
			}catch(InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\n Banco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar conta\n\n" );
				System.out.println("Digite o número da agência: ");
				agencia = leia.nextInt();
				
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R");
				titular = leia.nextLine();
				
				System.out.println("Digite o tipo da conta 1- CC ou 2- CP: ");
				tipo = leia.nextInt();
				
				System.out.println("Digite o saldo da conta: ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
					case 1 -> {
						System.out.println("Digite o limite da conta:");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta:");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Listar todas as contas");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Consultar dados da conta - por número");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Atualizar dados da conta");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				Optional<Conta> conta = contas.buscarNaCollection(numero);
				
				if(conta.isPresent()) {
					
					System.out.println("Digite o número da agência: ");
					agencia = leia.nextInt();
					
					System.out.println("Digite o nome do titular: ");
					leia.skip("\\R");
					titular = leia.nextLine();
					
					
					tipo = conta.get().getTipo();
					
					System.out.println("Digite o saldo da conta: ");
					saldo = leia.nextFloat();
					
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o limite da conta:");
							limite = leia.nextFloat();
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo,limite));
						}
						case 2 -> {
							System.out.println("Digite o dia do aniversário da conta:");
							aniversario = leia.nextInt();
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
					}
				} else
					System.out.println("A conta número: " + numero + " não foi encontrada!");
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Apagar a conta");
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Saque");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				System.out.println("Digite o valor do saque: ");
				valor = leia.nextFloat();
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Depósito");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				System.out.println("Digite o valor do depósito: ");
				valor = leia.nextFloat();
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD +"Transferência entre contas");
				
				System.out.println("Digite o número da conta de origem: ");
				numero = leia.nextInt();
				
				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = leia.nextInt();
				
				if(numero != numeroDestino) {
					
				System.out.println("Digite o valor do depósito: ");
				valor = leia.nextFloat();
								
				contas.transferir(numero, numeroDestino, valor);
				
				}else
					System.out.println("Os números das contas são iguais!");
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT +"\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
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
		
		public static void keyPress() {
			try {
				System.out.println("\n\nPressione a tecla Enter para continuar...");
				System.in.read();
			}catch(IOException e){
				System.out.println("Você pressionou a tecla inválida!");
			}
		}
	}
	
	


