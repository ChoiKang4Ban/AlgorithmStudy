import sys

N=int(sys.stdin.readline());

arr=list(map(int,sys.stdin.readline().split()));

dp=[-1001]*N;
dp[0]=arr[0];

for i in range(1,N):
  dp[i]=max(dp[i],arr[i],dp[i-1]+arr[i]);

print(max(dp))