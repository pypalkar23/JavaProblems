# 76 Minimum Window Substring  
from collections import defaultdict
def minWindow(s: str, t: str) -> str:
    tmap = defaultdict(int)
    for c in t:
        tmap[c]+=1
    
    count = len(t)
    
    start = 0 
    maxStart = 0
    maxEnd = 0
    
    for end,curr in enumerate(s,1):
        print(end)
        if curr in tmap:
            if tmap[curr]>0:
                count -= 1
            tmap[curr] -= 1
        
        while start<end and count==0:
            if maxEnd==0 or end-start < maxEnd - maxStart:
                maxStart = start
                maxEnd = end
            
            if s[start] in tmap:
                tmap[s[start]]+=1
                if tmap[s[start]] > 0:
                    count += 1
            start += 1
            
    return s[maxStart:maxEnd]
                        

print(minWindow("ADOBECODEBANC","ABC")) #BANC
