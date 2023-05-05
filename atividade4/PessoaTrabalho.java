public class PessoaTrabalho extends Pessoa {
	private String cargo;
	private String email;
	

	public PessoaTrabalho(String tipo,String n, String num,String cargo,String email) {
		super(tipo,n, num);
		this.cargo=cargo;
		this.email=email;
	}
	
	public int validaCargo(String cargo) {
		if(cargo.compareToIgnoreCase("Diretor")==0||cargo.compareToIgnoreCase("Diretora")==0) {;
			return 1;
		}
		else if (cargo.compareToIgnoreCase("Gerente")==0) {;
			return 1;
		}
		else if (cargo.compareToIgnoreCase("Progamador")==0||cargo.compareToIgnoreCase("Progamadora")==0) {;
			return 1;
		}
		return -1;
	}
	
	private int acharPosicao(String email) {
		char chara;
		for(int i=0;i<=email.length()-1;i++ ) {
			chara=email.charAt(i);
			if(chara=='@') {
				return i;
			}
		}
		return -1;
	}
	
		
	private int nomeEmail(String email) {
		String nomeEmail;
		String nome=getNome();
		int fim=nome.length();
		nomeEmail=email.substring(0, fim);
		if(nomeEmail.compareToIgnoreCase(nome)!=0) {
			return -1;
			
		}
		return 1;
	}

		
	
	public int validaEmail(String email) {
		int pos=acharPosicao(email);
		int numNom=nomeEmail(email);
		String emailV;
		emailV=email.substring(pos);
		if(emailV.compareToIgnoreCase("@gmail.com")!=0 && emailV.compareToIgnoreCase("@hotmail.com")!=0) {
			return-1;
		}
		if(numNom!=1) {
			return -1;
		}
		return 1;
			
			
	}
	

	public String getCargo() {
		return cargo;
	}


	public String getEmail() {
		return email;
	}


	@Override
	public String toString() {
		return  super.toString() +" cargo= " + cargo + ", email= " + email;
	}

}
