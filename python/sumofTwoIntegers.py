def getSum(a,b):
    if(b==0):
        return a
    else:
        return (getSum(a^b,(a&b)<<1))

print(getSum(1,2))
print(getSum(2,3))
print(getSum(5,7))
print(getSum(1000,1000))
print(getSum(-12,-8))     

'''
0001
0010

0011
0000

0010
0011

0001
0010

0011
'''