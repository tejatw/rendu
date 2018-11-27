package javaconcepts;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SampleAsync {

	
	public static void main (String args[]) {
		
		SampleAsync sampleAsync = new SampleAsync();
		
		Future<String> response = null;
		
		try {
			response = sampleAsync.calculateAsync();
			
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
