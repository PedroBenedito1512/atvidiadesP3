import java.util.Scanner;
public class Aplication {
    public static void main(String[] args) {
        Scanner in=new Scanner (System.in);
        Calculo x;
        double a,b,c;
		
        System.out.println("Digite valor de A");
        a=in.nextDouble();
        System.out.println("Digite valor de B");
        b=in.nextDouble();
        System.out.println("Digite valor de C");
        c=in.nextDouble();
        x=new Calculo(a,b,c);
        x.raizes();
    }
}
