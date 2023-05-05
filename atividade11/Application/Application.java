package Application;
import java.util.Scanner;
import Banco.CadastroContas;
import Banco.Conta;
import Banco.ContaEspecial;
import Banco.ContaPoupanca;
public class Application {
public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int tamanho;
        System.out.print("Informe o tamanho da lista de contas a ser criado: ");
        tamanho = in.nextInt(); 
        while(tamanho<1) {
        	System.out.println("!erro, informa tamanho superior a zero");
        	tamanho=in.nextInt();
        }
        in.nextLine();
        CadastroContas bk = new CadastroContas(tamanho);
        String tipoC = null;
        String nome = null;
        String numero = null;
        Double valor = 0.0;
        int  test;
        char tipo,op;
        Conta c = null;
        ContaPoupanca cp =null; 
        ContaEspecial ce = null;
        do {
            exibeOpcoes();
            op = in.next().charAt(0); in.nextLine();
            switch (op) {          								
                case '1': 
	                	mensagemTipo();
                		tipo=in.next().charAt(0);
                		while(tipo !='1'&&tipo!='2'&&tipo!='3') {
                			System.out.println("erro! opcão invalida");
                			mensagemTipo();
                			tipo=in.next().charAt(0);
                		}
                		c = new Conta (tipoC,nome,numero,valor);
                		System.out.println("Informe so dados da conta");
                        mensagemNome();
                        nome = in.next();  
                        test=c.validaNome(nome);
                        while(test!=1) {
                        	System.out.println("erro!nome contem caracteres invalidos");
                        	mensagemNome();
                            nome = in.next();  
                            test=c.validaNome(nome);                      	
                        }
                        mensagemConta();
                        numero =in.next();
                        test=c.validaNum(numero);
                        
                        while(test!=1) {
                    		System.out.println("!erro, formato invalido");
                    		mensagemConta();
                            numero =in.next();                            
                            test=c.validaNum(numero);            
                        }
                        System.out.println("informe valor inicial da conta");
                        valor= in.nextDouble();
                        while(valor<0){
                            System.out.println("erro, valor invalido digite valor acima de zero");
                            valor=in.nextDouble();
                        }
                        
                        if(tipo == '1') {
                        	tipoC="Conta Basica";                   
	                        c = new Conta (tipoC,nome,numero,valor);
	                        bk.cadastrarConta(c);;
                        }
                        else if(tipo =='2') {
                        	
                        	tipoC="Conta Poupanca";
                        	cp = new ContaPoupanca(tipoC,nome,numero,valor);                         
                        	bk.cadastrarConta (cp);
                        }
                        else {
                        	tipoC="Conta Especial";
                        	ce = new ContaEspecial(tipoC,nome,numero,valor);                         
                        	bk.cadastrarConta(ce);;
                        	
                        }
                        
                        break;
                case '2': 
                System.out.print("Informe o numero da conta: ");
                numero = in.nextLine();
                c = new Conta (numero);
                    System.out.println("informe valor do saque");
                    valor=in.nextDouble();
                    bk.saque(c, valor);;
                        break;
                case '3':
                System.out.print("Informe o numero da conta: ");
                        numero = in.nextLine();
                        c = new Conta (numero); 
                    System.out.println("informe valor do deposito");
                    valor=in.nextDouble();
                    bk.deposito(c, valor);;
                break;
                case '4': 
                break;
                case '5': bk.exibirTodos();
                break;
                             
                case '0': System.out.println("Bye bye");
                        break;
                default: System.out.println("Opção invalida");
            }
        } while (op != 0);
    }
    
    public static void exibeOpcoes () {
        System.out.println("Opecoes");
        System.out.println("0 - encerrar progama");
        System.out.println("1 - Cadastrar uma conta");
        System.out.println("2 - Sacar dinheiro");
        System.out.println("3 - Depositar valor");
        System.out.println("4 - Atualizar valor das contas poupanças");
        System.out.println("5 - mostra saldo das contas");
        System.out.println("Informe a opção desejada: ");
    } 
    public static void mensagemConta() {
    	System.out.println("numero da conta precisa ter 16 digitos numericos");
		System.out.println("como nesse exemplo 1111777991226618");
		System.out.print("Informe o Numero: ");
    }
    public static void mensagemNome(){
    	System.out.print("Informe o nome: ");
        System.out.println("obs: Nomes contem apenas letras");
    }
    public static void mensagemTipo() {
    	System.out.println("Deseja registrar que tipo de conta:");
		System.out.println("1: conta basica");
		System.out.println("2: conta poupança");
		System.out.println("3: conta especial");
    }

}  