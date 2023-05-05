package Main;
import java.util.Scanner;

import Funcionario.Assalariado;
import Funcionario.CadastroPessoas;
import Funcionario.Comissionado;
import Funcionario.Funcionario;
import Funcionario.Horista;
public class Application {
	public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int tamanho;
        System.out.print("Informe o tamanho da lista de funcionarios a ser criado: ");
        tamanho = in.nextInt(); 
        while(tamanho<1) {
        	System.out.println("!erro, informa tamanho superior a zero");
        	tamanho=in.nextInt();
        }
        in.nextLine();
        CadastroPessoas agenda = new CadastroPessoas(tamanho);
        String tipoC = null;
        String nome = null;
        String numero = null;
        int  test;
        char tipo,op;
        double valor=0,valor2=0;
        int qh=0;
        Funcionario f=null;
        Assalariado a = null;
        Horista h =null; 
        Comissionado c = null;
        do {
            exibeOpcoes();
            op = in.next().charAt(0); in.nextLine();
            switch (op) {          								
                case '1': 
	                	mensagemTipo();
                		tipo=in.next().charAt(0);
                		while(tipo !='1'&&tipo!='2'&&tipo!='3') {
                			System.out.println("erro! opção invalida");
                			mensagemTipo();
                			tipo=in.next().charAt(0);
                		}
                		f = new Funcionario (tipoC,nome,numero,valor);
                		System.out.println("Informe os dados do funcionario");
                        mensagemNome();
                        nome = in.next();  
                        test=f.validaNome(nome);
                        while(test!=1) {
                        	System.out.println("erro!nome contem caracteres invalidos");
                        	mensagemNome();
                            nome = in.next();  
                            test=f.validaNome(nome);                      	
                        }
                        mensagemNum();
                        numero =in.next();
                        test=f.validaNum(numero);
                        
                        while(test!=1) {
                    		System.out.println("!erro, formato invalido");
                    		mensagemNum();
                            numero =in.next();                            
                            test=f.validaNum(numero);            
                        }
                        
                        if(tipo == '1') {
                        	tipoC="Assalariado";
                            System.out.println("Informe salario do funcionario acima de zero");
                            valor=in.nextDouble();
                            
                            while(valor>0){
                                System.out.println("Informe salario do funcionario acima de zero");
                                valor=in.nextDouble();
                            }
                            System.out.println("informe imposto que sera subtraido ao sabario do funcionario");   
                            valor2=in.nextDouble();
                            while(valor2>0&&valor>valor2){
                                System.out.println("informe imposto que sera subtraido ao sabario do funcionario");   
                                valor2=in.nextDouble();

                            }               
	                        a = new Assalariado (tipoC,nome,numero,valor,valor2);
	                        agenda.cadastrarPessoa (a);
                        }
                        else if(tipo =='2') {
                        	tipoC="Comissionado";  
                            
                            System.out.println("Informe valor total das vendas maior que zero");
                            valor=in.nextDouble();
                            
                            while(valor>0){
                                System.out.println("Informe valor total das vendas maior que zero");
                                valor=in.nextDouble();
                            }
                            System.out.println("informe comissão que sera adicionada ao salario do funcionario");   
                            valor2=in.nextDouble();
                            while(valor2>0&&valor>valor2){
                                System.out.println("informe comissão que sera adicionada ao salario do funcionario"); 
                                System.out.println("comissão não pode ser maior que valor total das vendas nem menor que zero");  
                                valor2=in.nextDouble();

                            }
                        	c = new Comissionado(tipoC,nome,numero,valor,valor2);
                        	agenda.cadastrarPessoa (c);
       
                        }
                        else {
                        	tipoC="Horista"; 

                            System.out.println("Informe valor da hora de trabalho maior que zero");
                            valor=in.nextDouble();
                            
                            while(valor>0){
                                System.out.println("Informe valor da hora de trabalho maior que zero");
                                valor=in.nextDouble();
                            }
                            System.out.println("informe numero de horas trabalhadas pelo funcionario maior que zero");   
                            qh=in.nextInt();
                            while(qh>0){
                                System.out.println("informe numero de horas trabalhadas pelo funcionario maior que zero");   
                                qh=in.nextInt();

                            }
                        	h =new Horista(tipoC, nome, numero, valor, qh);
                        	agenda.cadastrarPessoa (h);
                        	
                        }
                        
                        break;
                case '2': agenda.exibirTodos();
                        break;
                case '3': agenda.exibirTodosAssalariados();
                break;
                case '4': agenda.exibirTodosComissionados();
                break;
                case '5': agenda.exibirTodosHoristas();
                break;
                case '6': System.out.print("Informe o nome do funcionario: ");
                        nome = in.nextLine();
                        f = new Funcionario (nome);
                        agenda.exibirPessoa(f);
                        break;  
                case '7': System.out.print("Informe o nome do funcionario: ");
                        nome = in.nextLine();
                        f = new Funcionario (nome);
                       agenda.removerPessoa(f);
                        break;                
                case '0': System.out.println("Bye bye");
                        break;
                default: System.out.println("Opção invalida");
            }
        } while (op != 0);
    }
    
    public static void exibeOpcoes () {
        System.out.println("Opções");
        System.out.println("1 - Cadastrar um novo funcionario");
        System.out.println("2 - Exibir todos Funcionarios");
        System.out.println("3 - Exibir apenas Funcionarios Assalariados");        
        System.out.println("4 - Exibir apenas Funcionarios Comissionados");
        System.out.println("5 - Exibir apenas Funcionarios Horistas");
        System.out.println("6 - Exibir os dados de um unico Funcionario");
        System.out.println("7 - Retirar funcionario da lista");
        System.out.println("0 - Encerrar programa");
        System.out.println("Informe a opção desejada: ");
    } 
    public static void mensagemNum() {
    	System.out.println("cpf precisa ter 11 digitos numericos");
		System.out.println("como nesse exemplo 1113225580");
		System.out.print("Informe o cpf: ");
    }
    public static void mensagemNome(){
    	System.out.print("Informe o nome: ");
        System.out.println("obs: Nomes contem apenas letras");
    }
    public static void mensagemTipo() {
    	System.out.println("Deseja adicionar que tipo de Funcionario:");
		System.out.println("1: Assalariado");
		System.out.println("2: Comissionado");
		System.out.println("3: Horista");
    }

}  