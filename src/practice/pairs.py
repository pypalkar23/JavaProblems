def countPairs(a, b, K): 

    n1 = len(a)
    n2 = len(b)  
    # Initialize pairs to 0 
    res = 0#result to be returned
      
    # Create dictionary of elements 
    # of array A1 
    m = dict() 
    for i in range(0, n1): 
        if a[i] not in m.keys(): 
            m[a[i]] = 1
        else: 
            m[a[i]] = m[a[i]] + 1
          
    # count total pairs 
    for i in range(0, n2): 
        temp = K - b[i] 
        if temp in m.keys(): 
            res = res + 1
              
            # Every element can be part 
            # of at most one pair 
            #m[temp] = m[temp] - 1
      
    # return total pairs 
    return res 

def solution(a,b,query):
    result = []
    for q in query:
        if len(q) == 2:#if query has length 2, then we count the number of pairs in 2 arrays with a partucular sum
            result.append(countPairs(a,b,q[1]))
        else:
            a[q[1]] += q[2]#if query length is 2 then we update the list b
        
    return result


print(solution([2,3],[1,2,2],[[1,4],[0,0,1],[1,5]]))
