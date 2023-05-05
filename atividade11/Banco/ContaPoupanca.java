package Banco;
public class ContaPoupanca extends Conta {
    public ContaPoupanca(String tipoC, String n, String num,double valor) {
        super(tipoC, n, num,valor);
    }

    private double atualizarRendimento(){
        double taxa=1;
        if(taxa>0&&taxa<100){
            taxa= getValor()/100;
        taxa+=getValor();
        this.setValor(taxa);
        return  this.getValor();
        }
        return  this.getValor();
    }   

    
    
}
