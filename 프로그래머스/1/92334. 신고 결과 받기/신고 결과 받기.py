def solution(id_list, report, k):
    
    reported = {}
    result = [0 for _ in range(len(id_list))]
    for i in id_list: reported[i] = []
    
    for i in report:
        er, ed = i.split(" ")
        if er in reported[ed]:
            continue
        reported[ed].append(er)
    
    for i in reported:        
        if len(reported[i])>=k:
            for j in reported[i]:
                result[id_list.index(j)] += 1
    return result
    