def solution(s):
    m = len(s)
    for i in range(1, len(s)//2+1):
        result=""
        count=1
        first = s[0:i]
        for j in range(i, len(s), i):
            if first == s[j:j+i]:
                count += 1
            else: 
                if count == 1:
                    result += first
                else:
                    result += str(count)+first
                first = s[j:j+i]
                count = 1
        result += str(count)+first if count>=2 else first
        m = min(m, len(result))            
    return m
            