package Banco;
public class RegistraConta{
    private int conta;
    private String nome;
    private double valorInicial;

    public RegistraConta(int conta, String nome, double valorInicial) {
        this.conta = conta;
        this.nome = nome;
        this.valorInicial = valorInicial ;
    }

    public double deposito (double valor, char dia){
        if(valida(valor) == 1){
            if(dia != '1' && dia != '7'){
                this.valorInicial+=valor;
            }
            else{
                System.out.println("valor não adicionado, Dias de folga");
            }    
        }
        else{
            System.out.println("valor não adicionado, coloque valor valido");
        }
        return this.valorInicial;
    }

    public double saque (double valor, char dia){
        if(validaSaque(valor) == 1 && valida(valor)==1){
            if(dia != '1' && dia != '7'){
                    this.valorInicial=this.valorInicial-valor;    
            }
            else{
                System.out.println("valor não sacado, Dias de folga");
            }    
        }
        else{
            System.out.println("valor não sacado, coloque valor valido");
        }
        return this.valorInicial;
    }

    private int validaSaque (double valor){
        if(this.valorInicial>valor){
            return 1;
        }
        return -1;
    }

    private int valida (double valor){
        if(valor<0){
            return -1;
        }
        return 1;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    
    public int getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }



    
        
}