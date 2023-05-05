package Funcionario;
import java.util.Scanner;
public class CadastroPessoas {
    private Funcionario[] vetor;
    private int cont;    
    public CadastroPessoas (int tam) {
        vetor = new Funcionario[tam];
    }
    public void cadastrarPessoa (Funcionario p) { 
    	int repetido;
    	int repetidoNum;
        if (this.cont == this.vetor.length) {
            System.out.println("Lista de funcionarios cheia! funcionario não cadastrado!!!");
        }
        else { 
        	repetido=buscarRepetido(p);
        	repetidoNum=buscarNumeroRepetido(p);
        	if(repetido==-1) {
        		System.out.println("´funcionario não foi registrado, Nome ja existe na lista");
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
    private int buscarRepetido (Funcionario p) {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
            if (p.compareTo (this.vetor[i])== 0) {
                return -1;
            }
        }    
        return cont;
    }
    private int buscarNumeroRepetido (Funcionario p) {
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
    public void exibirTodosHoristas() {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
        	if(this.vetor[i].getTipoC().compareToIgnoreCase("Horista")==0) {
        		System.out.println(this.vetor[i]);
        	}
                       
        }
    }
    public void exibirTodosComissionados() {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
        	if(this.vetor[i].getTipoC().compareToIgnoreCase("Comissionado")==0) {
        		System.out.println(this.vetor[i]);
        	}
                       
        }
    }
    
    public void exibirTodosAssalariados() {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
        	if(this.vetor[i].getTipoC().compareToIgnoreCase("Assalariado")==0) {
        		System.out.println(this.vetor[i]);
        	}
                       
        }
    }
    private int buscar (Funcionario p) {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
            if (p.compareTo (this.vetor[i])== 0) {
                return i;
            }
        }    
        return -1;
    }
    
    public void exibirPessoa (Funcionario p) {
        int retorno = this.buscar(p);
        if (retorno == -1) {
            System.out.println("Contato n�o cadastrado");
        }
        else {
            System.out.println("Dados do contato");
            System.out.println(this.vetor[retorno]);
        }
    }
    
    public void alterarNumeroPessoa (Funcionario p) {
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
    private int achar (String novoNum,Funcionario p) {
    	String nums;
    	for(int i=0;i<=this.cont-1;i++) {
    		nums=this.vetor[i].getNumero();
    		if(nums.compareToIgnoreCase(novoNum)==0) {  			
    			return-1;
    		}
    	}
    	return 1;
    }
    
    public void removerPessoa (Funcionario p) {
        int retorno = this.buscar(p);
        int i;
        if (retorno == -1) {
            System.out.println("Contato não cadastrado");
        }
        else {
            for (i = retorno; i < this.cont-1; i++) {
                this.vetor[i] = this.vetor[i+1];
            }
            this.vetor[i] = null;
            this.cont--;
            System.out.println("Remooção efetuada!");
        }
    }
}
