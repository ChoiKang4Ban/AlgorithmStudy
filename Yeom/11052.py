import sys
# DP 문제 
N=int(sys.stdin.readline())

# 0인 패딩 행렬을 주기 위해
money=[0]+list(map(int,sys.stdin.readline().split()));
dp=[[0]*(N+1) for _ in range(N+1)];

# 카드 팩의 가격 순으로 돌고
for cardInd in range(1,N+1):
  # 골라야 하는 카드의 갯수만큼 또 돈다.
  for cardCount in range(1,N+1):
    # 처음은 아무것도 안고른것.
    maxMoney=dp[cardInd-1][cardCount]; 

    # 현재 카드를 구매할 수 있다면.
    if cardInd<=cardCount:

      # 1개만 고를 수 있는게 아니라 여러개 고를 수 있기에
      # count값을 주어서 관리
      count=1;
      prevCount=cardCount-cardInd;
      while prevCount>=0:
        maxMoney=max(maxMoney,dp[cardInd-1][prevCount]+money[cardInd]*count);
        count+=1;
        prevCount-=cardInd;
      
    # cardCount만큼 카드를 구매할때 cardInd까지 고려한 최댓값
    dp[cardInd][cardCount]=maxMoney;

print(dp[N][N]);
