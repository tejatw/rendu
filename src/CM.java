import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CM {

	
	public static void main (String args[]) {
		
		CM cm = new CM();
		
		Future<String> response = null;
		
		try {
			response = cm.calculateAsync();
			
			System.out.println(response.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Future<String> calculateAsync() throws InterruptedException {
		
		CompletableFuture<String> completableFuture
		  = CompletableFuture.supplyAsync(() -> "Hello");
		 
		CompletableFuture<String> future = completableFuture
		  .thenApply(s -> s + " World");
		
		return future;
	}
}
