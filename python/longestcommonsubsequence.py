
def longestCommonSubsequence(text1: str, text2: str) -> int:
        # m = len(text1)
        # n = len(text2)

        # helper=[[0 for _ in range(m+1)]for _ in range(n+1)]

        # #for i in helper:
        # #    print(i)
        # for i in range(1,n+1):
        #     for j in range(1,m+1):
        #         if(text2[i-1] == text1[j-1]):
        #             helper[i][j] = helper[i-1][j-1]+1
        #         else:
        #             helper[i][j] = max(helper[i][j-1],helper[i-1][j])

        # return helper[n][m]
        
    m = len(text1)
    n = len(text2)
    
    helper=[[0 for _ in range(m+1)]for _ in range(2)]

    #for i in helper:
    #    print(i)

    for i in range(1,n+1):
        for j in range(1,m+1):
            if(text2[i-1] == text1[j-1]):
                helper[i%2][j] = helper[(i-1)%2][j-1]+1
            else:
                helper[i%2][j] = max(helper[i%2][j-1],helper[(i-1)%2][j])

    return helper[n%2][m]




'''
         "abcde
       0 0 0 0 0 0
    "a" 0 1 1 1 1 1
    "c" 0 1 2 2 2 2
    "e" 0 0 0 0 0 3
'''


            


print(longestCommonSubsequence("xabccde","ace")) 