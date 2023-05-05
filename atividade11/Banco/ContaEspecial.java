package Banco;
public class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial(String tipoC, String n, String num, double valor) {
        super(tipoC, n, num, valor);
        this.limite=2000;
    }

    public double saqueEspecial(double valor){
        double l = getValor()+this.limite;
        double saque;
        if(valor>0){
            if(valor<=l){
                saque=this.getValor()-valor;
                setValor(saque);
                return getValor();
            }
            else{
                System.out.println("erro, saque maior que valor limite e dinheiro disponivel");
            }

        }
        else{
            System.out.println("erro, coloque um valor positivo maior que zero para saque");
        }
        return this.getValor();
    }
    
    
}
