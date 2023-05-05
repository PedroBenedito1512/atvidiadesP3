package Banco;
public class Conta implements Comparable <Conta> {
    private String tipoC,nome,numero;
	private double valor;

	public Conta (String n) {
        this.numero = n;
    }
    
    public Conta (String tipoC,String n, String num,double valor) {
    	this.tipoC=tipoC;
        this.nome = n;
        this.numero=num;
		this.valor=valor;
    }   
    
    public int compareTo (Conta outra) {
        int result;
        result = this.nome.compareToIgnoreCase(outra.nome);
        return result;
    }
    public int compareToNumero (Conta outra) {
        int result;
        result = this.numero.compareToIgnoreCase(outra.numero);
        return result;
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

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int validaNum (String novoNum) {
    	int tam=novoNum.length();
    	char chara;
    	int cha;
    	if(tam!=16) {
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
    
    
    public void atualizarNum (String novoNum) {
    	int test=validaNum(novoNum);
    	if(test==1) {
    		this.numero=novoNum;
    		System.out.println("numero adicionado");
    	}
    	else if(test==-1) {
    		System.out.println("!erro, formato invalido");
    		System.out.println("Numero n�o foi adicionado");
    	}
    }

	public double deposito(double valor){
		if(this.valor>0){
			this.valor+=valor;
			System.out.println("valor atualizado");
			return this.valor;
		}
		else{
			System.out.println("Erro, valor não foi depositado, digite valor valido ");
		}
		return this.valor;
	}

	public double saque(double valor){
		if(this.valor<=valor){
			this.valor-=valor;
			System.out.println("valor atualizado");
			return this.valor;
		}
		else{
			System.out.println("Erro, valor não foi sacodo, digite valor valido");
		}
		return this.valor;
	}
    
	public String toString() {
		return "Tipo do Contato= "+tipoC+", Nome= " + nome + ", Numero= +" + numero+ ", Valor= +" + valor;
	}
    
 
}
