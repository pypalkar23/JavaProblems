'''
public static int countAnalogousArrays( List<Integer> consecutiveDifference, int lowerBound, int upperBound )  {
    int count = 0;
    int min = lowerBound, max = lowerBound;
    int prev = lowerBound, curr = 0;
    for ( int i = 1; i<= consecutiveDifference.size(); i++ ){
        curr = prev - consecutiveDifference.get(i-1);
        min = Math.min(min, curr);
        max = Math.max(max, curr);
        prev = curr;
    }
      
    while (max <= upperBound ){
        if ( min >= lowerBound ) count++;
        min = min + 1;
        max = max + 1;  
    }
    return count;
}
'''

def maxHarvest(k, profit):
    i = 0
    j = 0
    sum  = 0
    p = float('-inf')
    n = len(profit)
    while(j<n):
        sum += profit[j]+ profit[(n//2+j)%n]
        while(j-i+1==k):
            p = max(p,sum)
            sum -= profit[i]+profit[(i+n//2)%n]
            i += 1
        j+=1
    return int(p)

print(maxHarvest(1,[3,-5]))
print(maxHarvest(1,[-3,-6,3,6]))
