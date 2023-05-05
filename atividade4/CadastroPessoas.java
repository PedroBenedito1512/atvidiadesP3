import java.util.Scanner;
public class CadastroPessoas {
    private Pessoa[] vetor;
    private int cont;    
    public CadastroPessoas (int tam) {
        vetor = new Pessoa[tam];
    }
    public void cadastrarPessoa (Pessoa p) { 
    	int repetido;
    	int repetidoNum;
        if (this.cont == this.vetor.length) {
            System.out.println("Agenda cheia! contato n�o cadastrado!!!");
        }
        else { 
        	repetido=buscarRepetido(p);
        	repetidoNum=buscarNumeroRepetido(p);
        	if(repetido==-1) {
        		System.out.println("Contato n�o foi registrado, Nome j� existe na lista telefonica");
        	}
        	else if(repetidoNum==-1) {
        		System.out.println("Contato n�o foi registrado, Numero j� existe na lista telefonica");
        	}
        	else {
        		this.vetor[this.cont] = p;
        		this.cont++;
        		System.out.println("Contato cadastrado com sucesso!");
        	} 
        }
    }
    private int buscarRepetido (Pessoa p) {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
            if (p.compareTo (this.vetor[i])== 0) {
                return -1;
            }
        }    
        return cont;
    }
    private int buscarNumeroRepetido (Pessoa p) {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
            if (p.compareToNumero (this.vetor[i])== 0) {
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
    public void exibirTodosBasicos() {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
        	if(this.vetor[i].getTipoC().compareToIgnoreCase("contato basico")==0) {
        		System.out.println(this.vetor[i]);
        	}
                       
        }
    }
    public void exibirTodosFaculdade() {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
        	if(this.vetor[i].getTipoC().compareToIgnoreCase("contato da faculdade")==0) {
        		System.out.println(this.vetor[i]);
        	}
                       
        }
    }
    
    public void exibirTodosTrabalho() {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
        	if(this.vetor[i].getTipoC().compareToIgnoreCase("contato de trabalho")==0) {
        		System.out.println(this.vetor[i]);
        	}
                       
        }
    }
    private int buscar (Pessoa p) {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
            if (p.compareTo (this.vetor[i])== 0) {
                return i;
            }
        }    
        return -1;
    }
    
    public void exibirPessoa (Pessoa p) {
        int retorno = this.buscar(p);
        if (retorno == -1) {
            System.out.println("Contato n�o cadastrado");
        }
        else {
            System.out.println("Dados do contato");
            System.out.println(this.vetor[retorno]);
        }
    }
    
    public void alterarNumeroPessoa (Pessoa p) {
        Scanner in = new Scanner (System.in);
        String novoNum;
        int test;
        int retorno = this.buscar(p);
        if (retorno == -1) {
            System.out.println("Contato n�o cadastrado");
        }
        else {
            System.out.print("Numero atual do Contato: ");
            System.out.println(this.vetor[retorno].getNumero());
            System.out.print("Informe o novo Numero:");
            novoNum = in.nextLine(); in.nextLine();
            test=achar(novoNum,p);
            if(test==-1) {
            	System.out.println("contato n�o atualizado, numero ja existe na agenda");
            }
            else {
            	this.vetor[retorno].setNumero(novoNum);
            	System.out.println("Numero atualizado");
            	System.out.println(this.vetor[retorno].getNumero());
            }
        }
    }
    private int achar (String novoNum,Pessoa p) {
    	String nums;
    	for(int i=0;i<=this.cont-1;i++) {
    		nums=this.vetor[i].getNumero();
    		if(nums.compareToIgnoreCase(novoNum)==0) {  			
    			return-1;
    		}
    	}
    	return 1;
    }
    
    public void removerPessoa (Pessoa p) {
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
