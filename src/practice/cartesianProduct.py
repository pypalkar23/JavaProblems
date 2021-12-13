import sys
def cartesianProduct(arr1,arr2,tuple1):
    index1= -1
    index2= -1
    n=len(arr2)

    for ele in arr1:
        if not ele.isdigit():
            return -1

    for ele in arr2:
        if not ele.isdigit():
            return -1
      

    return((int(tuple1[0])*n)+int(tuple1[1]))

a1=[]
a2=[]
coord=()
for i,line in enumerate(sys.stdin):
    if i==0:
        a1 = line[1:-2].split(",")
    elif i==1:
        a2 = (line[1:-2].split(","))
    elif i==2:
        ip = line[1:-1].split(",")
        coord = (ip[0],ip[1])
print(cartesianProduct(a1,a2, coord))

    
