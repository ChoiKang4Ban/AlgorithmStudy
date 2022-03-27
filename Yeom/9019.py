# 문제 6초..
# D,S,L,R 경로로 최단으로 가야함
# BFS로 구현

from collections import deque
import sys

T=int(sys.stdin.readline());

for _ in range(T):
  a,b=map(int,sys.stdin.readline().split());

  # 현재 번호와 경로를 체크하기위해 빈 문자열을 준다.
  que=deque([[a,""]]);

  # 체크 bfs
  chk=[False]*10000;
  chk[a]=True;

  while que:
    nowN,nowPath =que.popleft();

    # 이동한 숫자가 b라면 도착!
    if nowN==b:
      print(nowPath)
      break;
    
    # D 구현
    D=nowN*2;
    if D>9999:
      D=D%10000;
    if not chk[D]:
      que.append([D,nowPath+"D"]);
      chk[D]=True;

    # S 구현
    S=nowN-1;
    if S==-1:
      S=9999;
    if not chk[S]:
      que.append([S,nowPath+"S"]);
      chk[S]=True;

    # L 구현
    L=str(nowN);
    if len(L)==4:
      L=L[1:]+L[0];
    elif len(L)<=3:
      L=L+'0';

    while L!='0' and L[0]=='0':
      L=L[1:];
    L=int(L);
    if not chk[L]:
      que.append([L,nowPath+"L"]);
      chk[L]=True;

    # R 구현
    R=str(nowN);
    if len(R)==4:
      R=R[-1]+R[0:-1]
    if len(R)<=3:
      R='0'*(4-len(R))+R;
      R=R[-1]+R[0:-1]

    while  R!='0' and R[0]=='0':
      R=R[1:];
    R=int(R)
    if not chk[R]:
      que.append([R,nowPath+"R"]);
      chk[R]=True;

