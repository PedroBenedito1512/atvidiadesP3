package Funcionario;
public class Horista extends Funcionario{
    private int quantidadeHoras;
    private double valorBruto;

    public Horista(String tipoC, String n, String num, double valor,int qh) {
        super(tipoC, n, num, valor);
        this.quantidadeHoras=qh;
        this.valorBruto=valorBruto();
    }

    @Override
    public String toString() {
        return "quantidadeHoras=" + quantidadeHoras + ", valorBruto=" + valorBruto + "]";
    }



    

    
    
}
