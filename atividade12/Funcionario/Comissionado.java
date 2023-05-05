package Funcionario;

public class Comissionado extends Funcionario {
	private double comissao;
    private double valorBruto;
	

	public Comissionado(String tipoC, String n, String num, double valor,double comissao) {
		super(tipoC, n, num, valor);
		this.comissao=comissao;
        this.valorBruto=valorBruto();
	}

	@Override
	public double valorBruto() {
		return super.valorBruto()+this.comissao;
	}

	public double getImposto() {
		return comissao;
	}

	

	public void setImposto(double comissao) {
		this.comissao = comissao;
	}

    @Override
    public String toString() {
        return "comissao=" + comissao + ", valorBruto=" + valorBruto + "]";
    }



}