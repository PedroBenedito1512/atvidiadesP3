package Funcionario;

public class Assalariado extends Funcionario {
	private double imposto;
	private double valorBruto;
	

	public Assalariado(String tipoC, String n, String num, double valor,double imposto) {
		super(tipoC, n, num, valor);
		this.imposto=imposto;
		this.valorBruto=valorBruto();
	}





	@Override
	public double valorBruto() {
		return super.valorBruto()-imposto;
	}




	public double getImposto() {
		return imposto;
	}

	

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}





	@Override
	public String toString() {
		return "imposto=" + imposto + ", valorBruto=" + valorBruto + "]";
	}


}