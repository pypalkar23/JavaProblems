def checkOrder(a):
    isIncreasing = False
    isDecreasing = False
    for i in range(3,len(a),2):
        if a[i]>a[i-2]:
            isIncreasing = True
        if a[i]<a[i-2]:
            isDecreasing = True
        if (a[i]==a[i-2]):
            return "none"
    
        if isIncreasing and isDecreasing:
            return "none"
    
    if(not isIncreasing and not isDecreasing):
        return "none"
    if(isIncreasing):
        return "increasing"
    else:
        return "decreasing"

def sum(a,b):
    n1 = len(a)-1
    n2 = len(b)-1
    res = ""
    while(n1>=0 and n2>=0):
        str1 = int(a[n1])
        str2 = int(b[n2])
        n1 -= 1
        n2 -= 1
        res = str(str1+str2) + res

    while(n1>=0):
        res = a[n1] + res
        n1 -= 1
    
    while(n2>=0):
        res = b[n2] + res
        n2 -= 1
    return res


print(checkOrder([0]))
print(checkOrder([0,1,2,3]))
print(checkOrder([10,9,8,7]))
print(checkOrder([1,3,1,5,4,2]))


print(checkOrder([1,3,2,5,2,2]))

print(sum("11","9"))


