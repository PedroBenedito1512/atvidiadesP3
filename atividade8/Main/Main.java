package Main;
import java.util.Scanner;
import Banco.RegistraConta;
public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int conta;
        Double valorinicial;
        char diab;
        char opera;
        String nome;
        System.out.println("digite o nome cliente para criarmos sua conta");
        nome = input.next();
        System.out.println("Digite numero da conta?");
        conta = input.nextInt();
        System.out.println("digite o valor inicial para o usuario possa fazer a conta");
        valorinicial = input.nextDouble();
        RegistraConta rg = new RegistraConta(conta, nome,valorinicial);
        System.out.println("informações da conta");
        System.out.println("Nome: "+rg.getNome());
        System.out.println("Numero da conta: "+rg.getConta());
        System.out.println("Calor inicial: "+rg.getValorInicial());

        menu();
        diab=input.next().charAt(0);
        if( diab == '1' || diab =='2'|| diab =='3'|| diab =='4'|| diab =='5'|| diab =='6'|| diab =='7'){
            operamenu();
            opera=input.next().charAt(0);
            if(opera=='1'){
                System.out.println("digite valor a ser depositado");
                valorinicial=input.nextDouble();
                rg.deposito(valorinicial, diab);
                System.out.println("valor na conta R$="+rg.getValorInicial()); 
            }
            else  if(opera=='2'){
                System.out.println("digite valor para ser sacado");
                valorinicial=input.nextDouble();
                rg.saque(valorinicial, diab);
                System.out.println("valor na conta R$="+rg.getValorInicial()); 
            }
            else{
                System.out.println("opção invalida");
            }
        }
        else{
            System.out.println("opção invalida");
        }

        input.close();
            
    }

    public static void menu(){
        System.out.println("digite numero referente ao dia do saque ou deposito na conta");
        System.out.println("1 domingo");
        System.out.println("2 segunda");
        System.out.println("3 terca");
        System.out.println("4 quarta");
        System.out.println("5 quinta");
        System.out.println("6 sexta");
        System.out.println("7 sabado");
    }
    public static void operamenu(){
        System.out.println("escolha a operação");
        System.out.println("1 para deposito");
        System.out.println("2 para saque");
    }
}