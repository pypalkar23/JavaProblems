import math
def convert(mat):
    
    rows = len(mat)
    cols = len(mat[0])
    means= [0]*cols
    nzero_count = [0]*cols
    zero_indices=[[] for _ in range(cols)]
    
    for i in range(0,rows):
        for j in range(0,cols):
            means[j] += mat[i][j]
            if(mat[i][j]==0):
                zero_indices[j].append(i)
            else:
                nzero_count[j] += 1
                   
    
    for i in range(0,cols):
        means[i] = means[i]/nzero_count[i]
    

    for j in range(cols):
        for idx in zero_indices[j]:
            mat[idx][j]= means[i]
    
    std_deviations =[0]*cols
    for i in range(0,rows):
        for j in range(0,cols):
            std_deviations[j] += math.pow(mat[i][j] - means[j], 2)

    for i in range(0,len(std_deviations)):
        std_deviations[i] = math.sqrt(std_deviations[i]/cols)

    for i in range(0,rows):
        for j in range(0,cols):
            mat[i][j] = (mat[i][j]-means[j])/(std_deviations[j])

    print(mat)

    
           

    
        



    

    
        
    
    
    
   

    

    
convert([[1,2,0],[0,1,1],[5,6,5]])
