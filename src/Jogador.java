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
         *  A palavra reservada synchronized significa que s� uma Thread pode acessar
         *  o m�todo de cada vez.
         */
        
        public synchronized void atira(Jogador adversario) {  
            Jogador jogador = this;  
            System.out.println(jogador.nome + ": atirei no " + adversario.nome);  
            adversario.atiraDeVolta(jogador) ;  
        }  
  
        /*
         * A implementa��o do m�todo "atira" chama o m�todo "atiraDeVolta" do
         * adversario para atirar no jogador.
         * 
         * Ambos os m�todos est�o marcados com synchronized, vai ocorrer um DeadLock,
         * pois:
         * A Thread do Jogador 1 n�o poder� invocar o m�todo "atiraDeVolta" do 
         * Jogador 2 enquanto o Jogador 2 n�o terminar de executar o m�todo "atira";
         *  
		 * E Thread do Jogador 2 n�o vai terminar de executar o m�todo "atira" enquanto
		 * ela n�o chamar o m�todo "atiraDeVolta" do Jogador 1.
         */
        
        public synchronized void atiraDeVolta(Jogador adversario) {  
            Jogador jogador = this;  
            System.out.println(jogador.nome + ": atirei de volta no " + adversario.nome);  
        }  

}