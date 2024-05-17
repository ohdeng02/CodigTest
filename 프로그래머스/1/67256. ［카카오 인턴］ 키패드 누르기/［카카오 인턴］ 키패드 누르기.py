def solution(numbers, hand):    
    result = ""
    npad = [[1,2,3],[4,5,6],[7,8,9],['*',0,'#']]
    l = [3,0]
    r = [3,2]
    
    for n in numbers:
        if n==1 or n==4 or n==7:
            l = [(n-1)//3, 0]
            result += "L"
        elif n==3 or n==6 or n==9:
            r = [n//3-1, 2]
            result += "R"
        else:
            if n==0:
                idx = [3,1]    
            else:
                idx = [(n+1)//3-1, 1]
            ld =  abs(idx[0]-l[0])+abs(idx[1]-l[1])
            rd =  abs(idx[0]-r[0])+abs(idx[1]-r[1])
            if ld < rd: 
                result += "L"
                l = idx
            elif ld > rd: 
                result += "R"
                r = idx
            else: 
                result += hand[0].upper()
                if hand[0]=='r': r = idx
                else : l = idx
    return result