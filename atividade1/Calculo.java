public class Calculo {
    private double a;
    private double b;
    private double c;
    private double d;

	
 public Calculo(double n1,double n2,double n3) {
    this.a=n1;
    this.b=n2;
    this.c=n3;
    this.d=(n2*n2)+(-4*n1*n3);
 }	
	
 
 

  public void raizes () {
    double x1,x2;
    if(this.d<0) {
        System.out.println("N�o existe raiz Real");
    }
    else {
	x1 = (-(this.b) + Math.sqrt(this.d)) / (2 * this.a);
	x2 = (-(this.b) - Math.sqrt(this.d)) / (2 * this.a);

	System.out.println("x1 = " + x1);
	System.out.println("x2 = " + x2);
    }	  
  }
  
}