import sys

N=int(sys.stdin.readline());
count=0;
total=1;
p1=1
p2=1;
while p1<=N:
  if total==N:
    count+=1;
    p1+=1;
    p2=p1
    total=p1;
  elif total>N:
    p1+=1;
    p2=p1
    total=p1;
  else:
    p2+=1;
    total+=p2;
print(count)