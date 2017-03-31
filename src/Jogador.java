/**
 * 
 * @author BRENO
 * Classe que representa um exemplo de um deadlock
 * 
 */

public class Jogador {  
  
        final String nome;  
  
        public Jogador(String nome) {  
            this.nome = nome;  
        }  
  
        /*
         *  A palavra reservada synchronized significa que só uma Thread pode acessar
         *  o método de cada vez.
         */
        
        public synchronized void atira(Jogador adversario) {  
            Jogador jogador = this;  
            System.out.println(jogador.nome + ": atirei no " + adversario.nome);  
            adversario.atiraDeVolta(jogador) ;  
        }  
  
        /*
         * A implementação do método "atira" chama o método "atiraDeVolta" do
         * adversario para atirar no jogador.
         * 
         * Ambos os métodos estão marcados com synchronized, vai ocorrer um DeadLock,
         * pois:
         * A Thread do Jogador 1 não poderá invocar o método "atiraDeVolta" do 
         * Jogador 2 enquanto o Jogador 2 não terminar de executar o método "atira";
         *  
		 * E Thread do Jogador 2 não vai terminar de executar o método "atira" enquanto
		 * ela não chamar o método "atiraDeVolta" do Jogador 1.
         */
        
        public synchronized void atiraDeVolta(Jogador adversario) {  
            Jogador jogador = this;  
            System.out.println(jogador.nome + ": atirei de volta no " + adversario.nome);  
        }  

}