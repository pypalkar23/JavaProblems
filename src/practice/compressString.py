"aabbbbaa"
def compressString(k,str):
    start = 0
    end = 0
    tempk=1
    index= []
    ans =""
    for i in range(1,len(str)):
        if(str[i]==str[i-1]):
            tempk +=1
        else:
            tempk = 1
        if(tempk==k):
            end= i-(tempk)
            ans += str[start:end+1]
            start = i+1
            end = i+1
            tempk = 1
        end += 1
    ans += str[start:end+1]
    return ans

print(compressString(3,"aabbbaa"))
print(compressString(2,"baac"))
        
        

            

