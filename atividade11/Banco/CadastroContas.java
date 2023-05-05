package Banco;
public class CadastroContas {
    private Conta[] vetor;
    private int cont;

    public CadastroContas (int tam) {
        vetor = new Conta[tam];
    }

    public void cadastrarConta (Conta c) { 
    	int repetido;
    	int repetidoNum;
        if (this.cont == this.vetor.length) {
            System.out.println("lista cheia! conta não cadastrada!!!");
        }
        else { 
        	repetido=buscarRepetido(c);
        	repetidoNum=buscarNumeroRepetido(c);
        	if(repetido==-1) {
        		System.out.println("Conta não foi registrada, Nome já existe na lista de contas do banco");
        	}
        	else if(repetidoNum==-1) {
        		System.out.println("Conta não foi registrado, Numero de conta já existe na lista de contas do banco");
        	}
        	else {
        		this.vetor[this.cont] = c;
        		this.cont++;
        		System.out.println("Conta cadastrado com sucesso!");
        	} 
        }
    }
    private int buscarRepetido (Conta c) {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
            if (c.compareTo (this.vetor[i])== 0) {
                return -1;
            }
        }    
        return cont;
    }
    private int buscarNumeroRepetido (Conta c) {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
            if (c.compareToNumero (this.vetor[i])== 0) {
                return -1;
            }
        }    
        return cont;
    }
    public void exibirTodos() {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
            System.out.println(this.vetor[i]);           
        }
    }
    
    public void exibirTodosPouoanca() {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
        	if(this.vetor[i].getTipoC().compareToIgnoreCase("Conta Poupanca")==0) {
        		System.out.println(this.vetor[i]);
        	}
                       
        }
    }
    

    private int buscar (Conta p) {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
            if (p.compareTo (this.vetor[i])== 0) {
                return i;
            }
        }    
        return -1;
    }
    
    public void exibirConta (Conta p) {
        int retorno = this.buscar(p);
        if (retorno == -1) {
            System.out.println("Contato n�o cadastrado");
        }
        else {
            System.out.println("Dados do contato");
            System.out.println(this.vetor[retorno]);
        }
    }
    public void saque (Conta p,Double valor) {
        int retorno = this.buscar(p);
        if (retorno == -1) {
            System.out.println("Conta não cadastrada");
        }
        else {
            this.vetor[retorno].saque(valor);
 
        }
    }
    public void deposito (Conta p,Double valor) {
        int retorno = this.buscar(p);
        if (retorno == -1) {
            System.out.println("Conta não cadastrada");
        }
        else {
            this.vetor[retorno].deposito(valor);
 
        }
    }
    
    private int achar (String novoNum,Conta p) {
    	String nums;
    	for(int i=0;i<=this.cont-1;i++) {
    		nums=this.vetor[i].getNumero();
    		if(nums.compareToIgnoreCase(novoNum)==0) {  			
    			return-1;
    		}
    	}
    	return 1;
    }
    
    public void removerConta (Conta p) {
        int retorno = this.buscar(p);
        int i;
        if (retorno == -1) {
            System.out.println("Contato n�o cadastrado");
        }
        else {
            for (i = retorno; i < this.cont-1; i++) {
                this.vetor[i] = this.vetor[i+1];
            }
            this.vetor[i] = null;
            this.cont--;
            System.out.println("Remo��o efetuada!");
        }
    }
}

