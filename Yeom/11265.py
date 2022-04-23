from collections import deque
import sys

N,M=map(int,sys.stdin.readline().split());
arr=list();
for _ in range(N):
  arr.append(list(map(int,sys.stdin.readline().split())));

# 경 출 도
for k in range(N):
  for s in range(N):
    for e in range(N):
      if arr[s][e]>arr[s][k]+arr[k][e]:
        arr[s][e]=arr[s][k]+arr[k][e];

for _ in range(M):
  A,B,C=map(int,sys.stdin.readline().split());
  if arr[A-1][B-1]<=C:
    print("Enjoy other party");
  else:
    print("Stay here");