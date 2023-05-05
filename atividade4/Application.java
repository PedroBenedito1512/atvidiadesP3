import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int tamanho;
        System.out.print("Informe o tamanho da agenda a ser criado: ");
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
        String email= null;
        String cargo= null;
        int  test;
        char tipo,op;
        Pessoa p = null;
        PessoaTrabalho pt =null; 
        PessoaFaculdade pf = null;
        do {
            exibeOpcoes();
            op = in.next().charAt(0); in.nextLine();
            switch (op) {          								
                case '1': 
	                	mensagemTipo();
                		tipo=in.next().charAt(0);
                		while(tipo !='1'&&tipo!='2'&&tipo!='3') {
                			System.out.println("erro! opc�o invalida");
                			mensagemTipo();
                			tipo=in.next().charAt(0);
                		}
                		p = new Pessoa (tipoC,nome,numero);
                		System.out.println("Informe so dados do contato");
                        mensagemNome();
                        nome = in.next();  
                        test=p.validaNome(nome);
                        while(test!=1) {
                        	System.out.println("erro!nome contem caracteres invalidos");
                        	mensagemNome();
                            nome = in.next();  
                            test=p.validaNome(nome);                      	
                        }
                        mensagemNum();
                        numero =in.next();
                        test=p.validaNum(numero);
                        
                        while(test!=1) {
                    		System.out.println("!erro, formato invalido");
                    		mensagemNum();
                            numero =in.next();                            
                            test=p.validaNum(numero);            
                        }
                        
                        if(tipo == '1') {
                        	tipoC="Contato Basico";                   
	                        p = new Pessoa (tipoC,nome,numero);
	                        agenda.cadastrarPessoa (p);
                        }
                        else if(tipo =='2') {
                        	
                        	tipoC="Contato de Trabalho";
                        	pt = new PessoaTrabalho(tipoC,nome,numero,cargo,email);                         
                            
                            mensagemCargo();
                            cargo=in.next();   
                            test=pt.validaCargo(cargo);
                            while(test!=1) {
                            	System.out.println("erro!! cargo invalido");
                            	mensagemCargo();
                                cargo=in.next();	
                                test=pt.validaCargo(cargo);
                            }
                            
                            mensagemEmail();
                            email = in.next();
                            test=pt.validaEmail(email);
                            while(test!=1) {
                            	System.out.println("Email invalido");
                            	mensagemEmail();
                                email = in.next();
                                test=pt.validaEmail(email); 	
                            }
                            
                        	pt = new PessoaTrabalho(tipoC,nome,numero,cargo,email);
                        	agenda.cadastrarPessoa (pt);
                        }
                        else {
                        	tipoC="Contato da Faculdade";
                        	pf = new PessoaFaculdade(tipoC,nome,numero,cargo,email);                         
                            
                            mensagemOcupacao();
                            cargo=in.next();   
                            test=pf.validaCargo(cargo);
                            while(test!=1) {
                            	System.out.println("erro!! ocupa��o invalido");
                            	mensagemCargo();
                                cargo=in.next();	
                                test=pf.validaCargo(cargo);
                            }
                            
                            mensagemEmailInstitucional();
                            email = in.next();
                            test=pf.validaEmail(email);
                            while(test!=1) {
                            	System.out.println("Email institucional invalido");
                            	mensagemEmailInstitucional();
                                email = in.next();
                                test=pf.validaEmail(email); 	
                            }
                            
                        	pf = new PessoaFaculdade(tipoC,nome,numero,cargo,email);
                        	agenda.cadastrarPessoa (pf);
                        	
                        }
                        
                        break;
                case '2': agenda.exibirTodos();
                        break;
                case '3': agenda.exibirTodosBasicos();
                break;
                case '4': agenda.exibirTodosTrabalho();
                break;
                case '5': agenda.exibirTodosFaculdade();
                break;
                case '6': System.out.print("Informe o nome do contato: ");
                        nome = in.nextLine();
                        p = new Pessoa (nome);
                        agenda.exibirPessoa(p);
                        break;  
                case '7': System.out.print("Informe o nome do contato: ");
                        nome = in.nextLine();
                        p = new Pessoa (nome);
                        agenda.alterarNumeroPessoa(p);
                        break;
                case '8': System.out.print("Informe o nome do contato: ");
                        nome = in.nextLine();
                        p = new Pessoa (nome);
                       agenda.removerPessoa(p);
                        break;                
                case '0': System.out.println("Bye bye");
                        break;
                default: System.out.println("Op��o inv�lida");
            }
        } while (op != 0);
    }
    
    public static void exibeOpcoes () {
        System.out.println("Op��es");
        System.out.println("1 - Cadastrar um contato na agenda");
        System.out.println("2 - Exibir todos contatos da agenda");
        System.out.println("3 - Exibir apenas contatos do basico");        
        System.out.println("4 - Exibir apenas contatos do trabalho");
        System.out.println("5 - Exibir apenas contatos da faculdade");
        System.out.println("6 - Exibir os dados de um unico contato");
        System.out.println("7 - Alterar o numero de um contato");
        System.out.println("8 - Retirar contato do cadastro");
        System.out.println("0 - Encerrar programa");
        System.out.println("Informe a op��o desejada: ");
    }
    public static void mensagemEmail() {
    	System.out.print("Informe o email: ");
        System.out.println("obs1:Email tem que ter OBRIGATORIAMENTE (nome do usuario+endere�o de email)");
        System.out.println("obs2:Caracteres apos nome proprio e ante @ s�o opcionais");
        System.out.println("exemplo: pepa@gmail.com ou pepa@hotmail.com");
    }
    public static void mensagemCargo() {
    	System.out.println("informe um dos cargos abaixo:");
        System.out.println("Diretor(a)");
        System.out.println("Gerente");
        System.out.println("Progamador(a)");
    }
    
    public static void mensagemNum() {
    	System.out.println("numero precisa ter 13 digitos numericos");
		System.out.println("como nesse exemplo 5587991226618");
		System.out.print("Informe o Numero: ");
    }
    public static void mensagemNome(){
    	System.out.print("Informe o nome: ");
        System.out.println("obs: Nomes contem apenas letras");
    }
    public static void mensagemTipo() {
    	System.out.println("Deseja adicionar que tipo de contato:");
		System.out.println("1: contato basico");
		System.out.println("2: contato do trabalho");
		System.out.println("3: contato da faculdade");
    }
    public static void mensagemOcupacao() {
    	System.out.println("informe uma das ocupa��oes abaixo:");
        System.out.println("Professor(a)");
        System.out.println("funcionario(a)");
        System.out.println("Aluno(a)");
    	
    }
    public static void mensagemEmailInstitucional() {
    	System.out.print("Informe o email istitucional: ");
        System.out.println("obs1:Email tem que ter OBRIGATORIAMENTE (nome do usuario+endere�o de email)");
        System.out.println("obs2:Caracteres apos nome proprio e antes do @ s�o opcionais");
        System.out.println("exemplo: pepa@unicap.com");
    }

}  