import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int tamanho;
        System.out.print("Informe o tamanho da agenda a ser criado: ");
        tamanho = in.nextInt(); // validar
        in.nextLine();
        CadastroPessoas agenda = new CadastroPessoas(tamanho);
        String nome;
        String numero;
        int   op,test;
        Pessoa p = null;
        do {
            exibeOpcoes();
            op = in.nextInt(); in.nextLine();
            switch (op) {
                case 1: System.out.println("Informe so dados do contato");
                        System.out.print("Informe o nome: ");
                        nome = in.next();
                        System.out.println("numero precisa ter 13 digitos numericos");
                		System.out.println("como nesse exemplo 5587991226618");
                        System.out.print("Informe o Numero: ");
                        numero =in.next();
                        p = new Pessoa (nome,numero);
                        test=p.validaNum(numero);
                        
                        while(test!=1) {
                    		System.out.println("!erro, formato invalido");
                    		System.out.println("numero precisa ter 13 digitos numericos");
                    		System.out.println("como nesse exemplo 5587991226618");
                    		System.out.print("Informe o Numero: ");
                            numero =in.next();                            
                            p = new Pessoa (nome,numero);
                            test=p.validaNum(numero);
                        }
              
                        agenda.cadastrarPessoa (p);
                        
                        break;
                case 2: agenda.exibirTodos();
                        break;
                case 3: System.out.print("Informe o nome do contato: ");
                        nome = in.nextLine();
                        p = new Pessoa (nome);
                        agenda.exibirPessoa(p);
                        break;  
                case 4: System.out.print("Informe o nome do contato: ");
                        nome = in.nextLine();
                        p = new Pessoa (nome);
                        agenda.alterarNumeroPessoa(p);
                        break;
                case 5: System.out.print("Informe o nome do contato: ");
                        nome = in.nextLine();
                        p = new Pessoa (nome);
                       agenda.removerPessoa(p);
                        break;                
                case 0: System.out.println("Bye bye");
                        break;
                default: System.out.println("Op��o inv�lida");
            }
        } while (op != 0);
    }
    
    public static void exibeOpcoes () {
        System.out.println("Op��es");
        System.out.println("1 - Cadastrar um contato na agenda");
        System.out.println("2 - Exibir contatos da agenda");
        System.out.println("3 - Exibir os dados de um contato");
        System.out.println("4 - Alterar o numero de um contato");
        System.out.println("5 - Retirar contato do cadastro");
        System.out.println("0 - Encerrar programa");
        System.out.println("Informe a op��o desejada: ");
    }
    
}  