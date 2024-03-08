def rotate(d,order):
    if order == 'L':
        if d == 3: d = 0
        else: d += 1 
    else:
        if d == 0: d=3
        else: d -= 1
    return d


a, b = map(int, input().split())
n, m = map(int, input().split())

robots = []
orders = []
dir = {"E":3, "S":2, "W":1, "N":0}
dx = [0,-1,0,1]
dy = [1,0,-1,0]

for _ in range(n):
    x,y,d = input().split(" ")
    robots.append([int(x), int(y), dir[d]])

for i in range(m):
    r,o,it = input().split(" ")
    orders.append([int(r), o, int(it)])
    
board = [[0]*a for _ in range(b)]

for i in robots:
    x = i[0]-1
    y = b-i[1]
    board[y][x] = 1

for i in orders:
    r = robots[i[0]-1]
    for _ in range(i[2]):
        if i[1] == 'F':
            nx = r[0] + dx[r[2]]
            ny = r[1] + dy[r[2]]
            if nx<1 or nx>a or ny<1 or ny>b:
                print(f"Robot {i[0]} crashes into the wall")
                exit(0)
            elif board[b-ny][nx-1] == 1: 
                k=0
                for k,ro in enumerate(robots): 
                    if ro[0]==nx and ro[1]==ny : break 
                print(f"Robot {i[0]} crashes into robot {k+1}") 
                exit(0) 
            else: 
                board[b-r[1]][r[0]-1] = 0 
                r[0] = nx 
                r[1] = ny 
                board[b-ny][nx-1] += 1 
        else: 
            r[2] = rotate(r[2],i[1])        
print("OK")