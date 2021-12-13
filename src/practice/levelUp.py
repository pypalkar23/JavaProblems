'''

public static int levelUp(int k, List<Integer> score) {
        if(k <= 0) return 0;
        Collections.sort(score, Collections.reverseOrder());
        int rank = 1;
        int res = 0;
        for(int i = 0; i < score.length(); i++) {
            if(i == 0) {
                rank = 1;
            } else if(score.get(i) != score.get(i - 1)) {
                rank = i + 1;
            }
            if(rank <= k && score.get(i) > 0) res++;
            else break;
        }
        return res;
    }

'''

def levelUp(k, scores):
    if k<=0:
        return 0
    scores= sorted(scores, reverse=True)
    rank =1 
    res = 0
    for i in range(0, len(scores)):
        if i==0:
            rank = 1
        elif scores[i] != scores[i-1]:
            rank = i+1
        if rank <=k and scores[i]>0:
            res+=1
        else:
            break
    
    return res


print(levelUp(3, [100,50,50,25]))
print(levelUp(4, [20,40,60,80,100]))


