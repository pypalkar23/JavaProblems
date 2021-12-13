import math

def lightBulbs(states, numbers):
    prime_dict = {}
    
    for n in numbers:
        primeset = set()
        while n % 2 == 0:
            primeset.add(2)
            n = n//2
            
        for i in range(3, int(math.sqrt(n))+1,2):
            while n % i == 0:
                n = n // i
                primeset.add(i)
        
        if n > 2:
                primeset.add(n)
    

        for num in primeset:
            if num in prime_dict:
                prime_dict[num]+=1
            else:
                prime_dict[num]=1
    
    print(prime_dict)
    
    indexmap={}
    for key in prime_dict:
        if prime_dict[key]%2==1:
            for i in range(int(key)-1,len(states),int(key)):
                if i in indexmap:
                    indexmap[i]+=1
                else:
                    indexmap[i] =1
    
    for i in indexmap:
        if indexmap[i]%2==1:
            if states[i]==0:
                states[i]=1
            else:
                states[i]=0

    return states
    
