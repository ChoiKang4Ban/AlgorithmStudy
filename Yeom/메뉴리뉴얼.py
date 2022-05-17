from collections import deque

def solution(orders, course):
  answer = []
  global dic;
  for clen in course:
    dic=dict();
    for order in orders:
      comb(0,0,clen,[""]*clen,order)
      print(dic)
    if dic:
      maxCnt=max(dic.values())
      if maxCnt>=2:
        for key,value in dic.items():
          if maxCnt==value:
            answer.append(key)

  answer.sort()
  return answer
def comb(cnt,start,l,comArr,ableAlpha):
  if cnt==l:
    ableMenu ="".join(sorted(comArr));
    if ableMenu not in dic.keys():
      dic[ableMenu]=1
    else:
      dic[ableMenu]=dic.get(ableMenu)+1;
    return
  for i in range(start,len(ableAlpha)):
    comArr[cnt]=ableAlpha[i];
    comb(cnt+1,i+1,l,comArr,ableAlpha);