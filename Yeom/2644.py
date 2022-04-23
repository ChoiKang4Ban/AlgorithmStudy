from collections import deque
import sys

N=int(sys.stdin.readline());
A,B=map(int,sys.stdin.readline().split());
M=int(sys.stdin.readline());

edge=[[] for _ in range(N+1)]

for _ in range(M):
  x,y=map(int,sys.stdin.readline().split());

  edge[x].append(y);
  edge[y].append(x);

chk=[False]*(N+1);

chk[A]=True;
que=deque([[A,0]]);

while que:
  now=que.popleft();
  if now[0]==B:
    print(now[1])
    quit()
  for e in edge[now[0]]:
    if not chk[e]:
      que.append([e,now[1]+1]);
      chk[e]=True;

print(-1);