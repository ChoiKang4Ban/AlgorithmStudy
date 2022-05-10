from collections import deque

def solution(n, computers):
  answer = 0
  chk=[False]*n;
  for i in range(n):
    if not chk[i]:
      answer+=1;
      
      # bfs
      chk[i]=True
      que=deque([i])
      while que:
        now =que.popleft();
        for j in range(n):
          if not chk[j] and computers[now][j]==1:
            que.append(j)
            chk[j]=True;
  return answer