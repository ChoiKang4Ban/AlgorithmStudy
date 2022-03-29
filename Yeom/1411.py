from curses.ascii import islower
import sys

# 50*50*100 ? , 25000 << 2초 ? 
# 시간제한 널널히나 전체 돌리기.

N=int(sys.stdin.readline());

arr=list();
for _ in range(N):
  arr.append(sys.stdin.readline().rstrip());
answer=0;
for left in range(N):
  for right in range(left+1,N):

    # 추적해야할 값은 바뀐 알파벳 값이랑 바뀐 인덱스
    # 인덱스값을 또 추적하긴 귀찮다.
    chkAlpha=[False]*26;
    tmp=arr[right];
    for k in range(len(arr[left])):
      # 변경되지 않은 값이라면
      if islower(tmp[k]):
        # 근데 변경할값이 쓸 수 없는 값이라면
        if chkAlpha[ord(arr[left][k])-ord("a")]:
          ## 여기는 같을 수가 없으므로 쓰레기값 할당
          tmp=-1;
          break;
        else:
          chkAlpha[ord(arr[left][k])-ord("a")]=True;
          ## 바뀐 인덱스 값을 추가로 추적하기 귀찮아서
          ## 바뀐 인덱스라면 어차피 소문자만 들어오니
          ## 대문자로 치환해준다.
          ## 인덱스 값을 추적 안해주면 예제 3번에서 문제가 생긴다.
          tmp=tmp.replace(tmp[k],arr[left][k].upper());

    ## 치환값은 대문자 값이므로 소문자로 치환해서 검사
    if arr[left]==str(tmp).lower():
      answer+=1;

print(answer)