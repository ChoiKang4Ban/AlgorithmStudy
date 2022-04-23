from collections import deque
import sys

MAX_SIZE=10**9+1;

A,B=map(int,sys.stdin.readline().split());

que=deque([[A,1]]);

while que:
  now =que.popleft();
  if now[0] == B:
    print(now[1]);
    quit()

  x2=now[0]*2;
  if x2 <MAX_SIZE:
    que.append([x2,now[1]+1]);

  append1=int(str(now[0])+"1");
  if append1 <MAX_SIZE:
    que.append([append1,now[1]+1]);

print(-1)