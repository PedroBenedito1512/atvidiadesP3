import java.util.Scanner;
public class CadastroPessoas {
    private Pessoa[] vetor;
    private int cont;    
    public CadastroPessoas (int tam) {
        vetor = new Pessoa[tam];
    }
    public void cadastrarPessoa (Pessoa p) {       
        if (this.cont == this.vetor.length) {
            System.out.println("Agenda cheia! contato n�o cadastrado!!!");
        }
        else {
            this.vetor[this.cont] = p;
            this.cont++;
            System.out.println("Contato cadastrado com sucesso!");
        }
    }
    public void exibirTodos() {
        int i;
        for (i = 0; i <= this.cont - 1; i++) {
            System.out.println(this.vetor[i]);           
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
        int retorno = this.buscar(p);
        if (retorno == -1) {
            System.out.println("Contato n�o cadastrado");
        }
        else {
            System.out.print("Numero atual do Contato: ");
            System.out.println(this.vetor[retorno].getNumero());
            System.out.print("Informe o novo Numero:");
            novoNum = in.nextLine(); in.nextLine();
            this.vetor[retorno].setNumero(novoNum);
            System.out.println("Numero atualizado");
            System.out.println(this.vetor[retorno].getNumero());
        }
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
