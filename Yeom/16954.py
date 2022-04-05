from collections import deque
import sys

# 벽이 다 사라질때까지 존버하면 성공 아니면 다이
def fall():
  count=0;
  for c in range(8):
    for r in range(7,0,-1):
      arr[r][c]=arr[r-1][c];
      if arr[r][c]=='#':
        count+=1;
    arr[0][c]='.'
  if count==0:
    return True; # 존버 성공
  else:
    return False; # 존버 더해야함 ;


# 위부터 시계방향으로 이동 + 서있기
dr=[-1,-1,0,1,1,1,0,-1,0];
dc=[0,1,1,1,0,-1,-1,-1,0];
arr=list();
for _ in range(8):
  arr.append(list(sys.stdin.readline().rstrip()));

# 왼쪽 아래부터 시작  r,c,depth(진행 시간)
que=deque([[7,0,0]]);

time=0;

while(que):
  now=que.popleft();
  if now[2]!=time:
    time+=1;
    if fall():
      print(1);
      quit();
  # 현재 서있는게 벽이라면 다이;
  if arr[now[0]][now[1]]=='#':
    continue;
  for i in range(9):
    tr=now[0]+dr[i];
    tc=now[1]+dc[i];
    if tr>=0 and tc>=0 and tr<8 and tc<8:
      if arr[tr][tc]!='#':
        que.append([tr,tc,now[2]+1]);

# 존버 실패
print(0);
