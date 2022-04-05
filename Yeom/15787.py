import sys
# 시뮬레이션??
# 브루트포스

N,M=map(int,sys.stdin.readline().split());

trains=[[False]*20 for _ in range(N+1)];

for _ in range(M):
  command=list(map(int,sys.stdin.readline().split()));

  # 명령 수행 
  if command[0]==1:
    trains[command[1]][command[2]-1]=True
  elif command[0]==2:
    trains[command[1]][command[2]-1]=False
  elif command[0]==3:
    trains[command[1]]=[False]+trains[command[1]][:-1]
  elif command[0]==4:
    trains[command[1]]=trains[command[1]][1:]+[False]

memo=list();
count=0;

for i in range(1,N+1):
  if not trains[i] in memo:
    count+=1;
    memo.append(trains[i])

print(count)
