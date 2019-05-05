import java.math.BigInteger;

public class FibFinder {

	public boolean fiber(int k) {
		
		BigInteger Fib0= BigInteger.ZERO;
        BigInteger Fib1= BigInteger.ONE;
        BigInteger current = new BigInteger("0");
        
        String kHolder = Integer.toString(k);
        BigInteger test = new BigInteger(kHolder);
		
        if(k <= 1 && k>=0) { // 1 and 0 both in fib sequence 
        	return true;
        }
        
        for(int i=2;i<k+2;i++) {
        	
        	 current = Fib0.add(Fib1);
             Fib0=Fib1;
             Fib1=current;
            
            if(current.equals(test)) {
            	return true;
            }
            
        	
        	
        }
        return false;
        
	}
	
	
	
}
