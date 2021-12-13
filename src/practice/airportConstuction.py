
def getTimeDiff(time1, time2):
    hr1 = time1//100
    min1 = time1%100

    hr2 = time2//100
    min2 = time2%100

    hrDiff = hr2-hr1
    minDiff = min2-min1
    
    if(minDiff<0):
        minDiff += 60
        hrDiff -=1

    waitTime = hrDiff*60 + minDiff
    return waitTime

def getMinGates(landingTimes, takeOffTimes, maxWaitTime, initialPlanes):
    maxPlanes = 0
    currPlanes = initialPlanes
    record = []
    for i in landingTimes:
         record.append((i,'a'))
    for i in takeOffTimes:
        record.append((i,'d'))

    arr = 0
    dept = 0
    record = sorted(record,key = lambda x: x[0])
    print(record)
    for i in record:
        if i[1]=='a' or i[1]=='d':
            currPlanes +=1
            lastArrivalTime = i[0]
            arr+=1
        else:
            #if its d
            if getTimeDiff(lastArrivalTime,i[0]) > maxWaitTime:
                print(lastArrivalTime, getTimeDiff(lastArrivalTime,i[0]))
                currPlanes -=1
        print(currPlanes)

        
    return currPlanes

def getMinGates1(landingTimes, takeOffTimes, maxWaitTime, initialPlanes):
    i = 0
    j = 0

    n1 = len(landingTimes)
    n2 = len(takeOffTimes)

    while (i<n1 or j<n2):
        print(i,j)
        diffTime = getTimeDiff(landingTimes[i],takeOffTimes[j])
        if diffTime > 0 and diffTime < maxWaitTime:
            initialPlanes += 1
            i += 1
        else:
            initialPlanes -= 1
            j += 1
        


    return initialPlanes   


print(getMinGates([630,645,730,1100],[700,845,1015,1130],20,1))

#print(getMinGates1([630,645,730,1100],[700,845,1015,1130],20,1))



    

    


    