# def subset(cnt,chk,data):
#   total=0;
#   if cnt==len(chk):
#     total=1;
#     for i in range(len(chk)):
#       if chk[i]:
#         total*=data[i]
#     print(chk,total)
#     return total;
  
#   chk[cnt]=True;
#   total+=subset(cnt+1,chk,data);
#   chk[cnt]=False;
#   total+=subset(cnt+1,chk,data);
#   return total;

def solution(clothes):
    answer = 1
    
    hmap =dict()

    for cloth in clothes:
      if cloth[1] not in hmap:
        hmap[cloth[1]]=1;
      else:
        hmap[cloth[1]]+=1;

    # isSelected=[False]*len(hmap)
    #
    # values=list(hmap.values())
    for v in hmap.values():
      answer*=(v+1)
    # return subset(0,isSelected,values)-1
    return answer-1