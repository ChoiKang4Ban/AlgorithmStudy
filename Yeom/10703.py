import sys

R,C=map(int,sys.stdin.readline().split());

arr=list();

for _ in range(R):
  arr.append(list(sys.stdin.readline().rstrip()))

moveCount=sys.maxsize;

for c in range(C):
  minDistance=R-1;
  start=-1;
  for r in range(R):
    if arr[r][c]=='X':
      start=r;
    if start!=-1 and arr[r][c]=='#':
      minDistance=r-start-1;
      break;
  moveCount=min(moveCount,minDistance)

for c in range(C):
  for r in range(R-1,moveCount-1,-1):
    if arr[r-moveCount][c]=='X':
      arr[r][c]='X'
      arr[r-moveCount][c]='.'

for r in range(R):
  for c in range(C):
    print(arr[r][c],end="")
  print()

