package standardalgos;
class GFG  
{ 
static int phi(int n) 
{ 
    // Initialize result as n 
    int result = n;  
  
    // Consider all prime factors  
    // of n and subtract their 
    // multiples from result 
    for (int p = 2; p * p <= n; ++p) 
    {   
        System.out.println("n "+n);
        System.out.println("factor "+p);
        // Check if p is  
        // a prime factor. 
        if (n % p == 0)  
        { 
            System.out.println("prime factor "+p);
            // If yes, then update 
            // n and result 
            while (n % p == 0) 
                n /= p; 
            result -= result / p; 
            System.out.println("result "+result);
        } 
    } 
  
    // If n has a prime factor 
    // greater than sqrt(n) 
    // (There can be at-most  
    // one such prime factor) 
    if (n > 1) 
        result -= result / n; 
    return result; 
} 
  
// Driver Code 
public static void main (String[] args) 
{ 
    //int n; 
    //for (n = 1; n <= 10; n++) 
        System.out.println("phi(" + 10 +  
                           ") = " + phi(10)); 
} 
} 