package Taxi;
import java.util.Scanner;
public class Application {

	public static void main(String[] args) {
		Scanner	in=new Scanner(System.in);
		double a,b,c;
		String nomeP,nomeM;
		double notaP,notaM;
		boolean respP,respM;
		double distancia,preco;
		double saldo;
		String telefone;
		char resp;

		do{
		System.out.println("informe dados do passageiro");
		System.out.println("Nome:");
		nomeP=in.next();
		System.out.println("Nota das avaliações:");
		notaP=in.nextDouble();
		System.out.println("telefone");
		telefone=in.next();

		System.out.println("digite pontos de  distancia entre motorista mais proximo  e  opasageiro");
		System.out.println("ponto 1:");
		a=in.nextDouble();
		System.out.println("ponto 2:");
		b=in.nextDouble();
		System.out.println("ponto 3:");
		c=in.nextDouble();
		Taxi pontos =new Taxi(a, b, c);
		
		distancia=pontos.getDistancia();
		preco=pontos.getPrecoCorrida();

		System.out.println("informe dados do motorista mais proximo");
		System.out.println("Nome:");
		nomeM=in.next();
		System.out.println("Nota das avaliações:");
		notaM=in.nextDouble();
		System.out.println("saldo atual");
		saldo=in.nextDouble();

		System.out.println("A distancia mapeada pelos pontos foi de "+distancia);
		System.out.println("preço da corrida ficara de "+preco);
		System.out.println("passageiro Confirma a corrida por esse valor?");
		System.out.println("digite (true) para sim ou (false) para não");
		respP=in.nextBoolean();
		Passageiro p= new Passageiro(nomeP, telefone, notaP, respP);
		System.out.println("o motorista aceita fazer a corrida?" );
		System.out.println("digite (true) para sim ou (false) para não");
		respM=in.nextBoolean();
		Motorista m = new Motorista(nomeM, saldo, notaM, respM);
		m.motoristaAceita(respP);
		p.PasageiroPedir(respM);
		System.out.println("Dados Armazenados do motorista hoje");
		m.toString();
		System.out.println("Dados Armazenados do passageiro hoje");
		p.toString();


		System.out.println("se precisar organizar outra corrida digite s, caso queri finalizar progama digite n");
		resp=in.next().charAt(0);
		resp=Character.toLowerCase(resp);
		while(resp!='s'&& resp!='n'){
			System.out.println("erro, responda ou s ou n");
			resp=in.next().charAt(0);
			resp=Character.toLowerCase(resp);
		}

		}while(resp=='n');


	}

}
