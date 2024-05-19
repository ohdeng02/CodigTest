def solution(today, terms, privacies):
    result=[]
    pri=[]
    rule={}
    for term in terms:
        arr=term.split(" ")
        rule[arr[0]]=int(arr[1])
    for str in privacies: pri.append(str.split(" "))
    today=list(map(int,today.split(".")))

    for i,p in enumerate(pri):
        per=list(map(int, p[0].split(".")))
        totper=per[0]*28*12+per[1]*28+per[2]-1
        tottoday=today[0]*28*12+today[1]*28+today[2]
        totper+=rule[p[1]]*28
        if totper<tottoday:
            result.append(i+1)
    return result