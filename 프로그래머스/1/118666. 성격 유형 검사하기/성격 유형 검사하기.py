def solution(survey, choices):
    result=""
    ctg = {"R":0,"T":0,"C":0,"F":0, "J":0,"M":0,"A":0,"N":0}
    for i,s in enumerate(survey):
        c = choices[i]
        if c>=1 and c<=3:
            ctg[s[0]] += 4-c
        elif c>=5 and c<=7:
            ctg[s[1]] += c-4
            
    keys = list(ctg.keys())
    for i in range(0, len(keys), 2):
        if ctg[keys[i]]>ctg[keys[i+1]]:
            result += keys[i]
        elif ctg[keys[i]]<ctg[keys[i+1]]:
            result += keys[i+1]
        else: result += keys[i]
    return result
    