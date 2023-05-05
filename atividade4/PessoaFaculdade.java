public class PessoaFaculdade extends Pessoa {
	private String ocupacao;
	private String emailInstitucional;
	

	public PessoaFaculdade(String tipo,String n, String num,String cargo,String email) {
		super(tipo,n, num);
		this.ocupacao=cargo;
		this.emailInstitucional=email;
	}
	
	public int validaCargo(String cargo) {
		if(cargo.compareToIgnoreCase("Aluno")==0||cargo.compareToIgnoreCase("Aluna")==0) 
		{
			return 1;
		}
		else if (cargo.compareToIgnoreCase("Professor")==0||cargo.compareToIgnoreCase("Professora")==0) 
		{
			return 1;
		}
		else if  (cargo.compareToIgnoreCase("Professor")==0) {
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
		if(emailV.compareToIgnoreCase("@unicap.com")!=0) {
			return-1;
		}
		if(numNom!=1) {
			return -1;
		}
		return 1;
			
			
	}
	

	public String getCargo() {
		return ocupacao;
	}


	public String getEmail() {
		return emailInstitucional;
	}


	@Override
	public String toString() {
		return  super.toString() +" cargo= " + ocupacao + ", email= " + emailInstitucional;
	}

}