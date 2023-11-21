package conta_bancaria.model;

public class ContaCorrente extends Conta { // herdar classe conta

	private float limite;
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
		
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(float valor) {
		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n Saldo Insuficiente");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
	
		if(this.getSaldo() < 0)
		this.setLimite(this.getLimite() - Math.abs( this.getSaldo()));
		return true;
	}
	
	
	@Override // Método subscrito a partir da classe que ta herdando (conta)
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite da conta: " + this.limite);
	}

}
