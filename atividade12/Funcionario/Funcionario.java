package Funcionario;
public class Funcionario implements Comparable <Funcionario> {
    private String tipoC,nome,numero;
	private double valor;
	private double valorBruto;
    
    public int compareTo (Funcionario outra) {
        int result;
        result = this.nome.compareToIgnoreCase(outra.nome);
        return result;
    }
    public int compareToNumero (Funcionario outra) {
        int result;
        result = this.numero.compareToIgnoreCase(outra.numero);
        return result;
    }
    
    public Funcionario (String n) {
        this.nome = n;
    }
    
    public Funcionario (String tipoC,String n, String num,double valor) {
    	this.tipoC=tipoC;
        this.nome = n;
        this.numero=num;
		this.valor=valor;
		this.valorBruto=valorBruto();
    }    
    
    public void setNumero (String novoNumero) {
        this.numero = novoNumero;
    }
    
    public String getNumero() {
        return this.numero;
    }
    
    
    public String getTipoC() {
		return tipoC;
	}
    

	public String getNome() {
		return nome;
	}
	public double getValor() {
		return valor;
	}

	public int validaNum (String novoNum) {
    	int tam=novoNum.length();
    	char chara;
    	int cha;
    	if(tam!=11) {
    		// retornar -1 se tiver menos de 13 digitos formato invalido
    		// formato  ideal exemplo(55 81 991333333)
    		return -1;
    	}
    	else {
    		for (int i=0; novoNum.length()-1>i;i++) {
    			chara=novoNum.charAt(i);
    			if(Character.isDigit(chara)==false) {
    				// retornar -1 se encotnrar digito invalidos
    				//so numeros s�o aceitos
    				return -1;
    			}
    			cha=chara;
    			if(cha<0) {
    				return-1;
    			}
    			
    		}	
    	}
    	// retorna 1 se estiver em um formato aceitavel(13 digitos de numeros inteiros)
    	return 1;
    }
	public  int validaNome(String nome) {
		char chara;
		for(int i=0; i<=nome.length()-1;i++) {
			chara=nome.charAt(i);
			if(Character.isLetter(chara)==false) {
				return -1;
			}
			
		}
		return 1;
	}
    
	public double valorBruto(){
		return this.valor;
	}
	
	public String toString() {
		return "Tipo do Funcionario= "+tipoC+", Nome= " + nome + ", Numero= +" + numero;
	}
}
