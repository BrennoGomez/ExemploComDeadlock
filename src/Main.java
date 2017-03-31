/**
 * 
 * @author BRENO
 * Classe que representa a execução das threads.
 */

public class Main {

	public static void main(String[] args) {  
		final Jogador jogador1 = new Jogador("Adbul Al Khalifa") ;  
		final Jogador jogador2 = new Jogador("Raphael Magnata") ;  
		
		Thread thread1 = new Thread( new Runnable() {  
			public void run() {  
				jogador1.atira(jogador2) ;  
			}  
		}, "Thread do Jogador 1") ;
		
		Thread thread2 = new Thread(new Runnable() {  
			public void run() {  
				jogador2.atira(jogador1) ;  
			}  
		}, "Thread do Jogador 2") ;
		
		thread1.start() ;  
	    thread2.start() ;  
	    }  
}
