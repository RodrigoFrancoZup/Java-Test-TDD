package br.com.caelum.leilao.dominio;

public class Main {
	
public static void main(String[] args) {
	//Aqui estamos fazendo um teste "manual"

			// Montando o cenário
			Usuario rodrigo = new Usuario("Rodrigo");
			Usuario pedro = new Usuario("Pedro");
			Usuario ana = new Usuario("Ana");

			Leilao leilao = new Leilao("Leilao de Macbook aprrendido pela PF");

			Lance lanceRodrigo = new Lance(rodrigo, 1000);
			leilao.propoe(lanceRodrigo);
			
			Lance lancePedro = new Lance(pedro, 2000);
			leilao.propoe(lancePedro);
			
			Lance LanceAna = new Lance(ana, 3000);
			leilao.propoe(LanceAna);
			
			Avaliador leiloeiro = new Avaliador();
			
			//Executa a ação
			leiloeiro.avalia(leilao);
			
			
			//Avaliando a saida
			System.out.println("Maior lance = " + leiloeiro.getMaiorValor());
			System.out.println("Menor lance = " + leiloeiro.getMenorValor());
			
			//Avaliando de uma maneira mais parecida com o teste automatizado
			Double maiorValorEsperado = 3000.0;
			Double menorValorEsperado = 1000.0;
			
			System.out.println(maiorValorEsperado == leiloeiro.getMaiorValor());
			System.out.println(menorValorEsperado == leiloeiro.getMenorValor());
}
	

}
