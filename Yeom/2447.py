def dStar(x, y, dep, stars):
    for i in range(x, x+dep):
        for k in range(y, y+dep):
            stars[i][k] = ' '


def pStar(x, y, dep, stars):
    if dep == 3:
        stars[x+1][y+1] = ' '
    else:
        for dx in range(x, x+dep, dep//3):
            for dy in range(y, y+dep, dep//3):
                if dx == x+dep//3 and dy == y+dep//3:
                    dStar(dx, dy, dep//3, stars)
                else:
                    pStar(dx, dy, dep//3, stars)


n = int(input())
stars = [['*']*n for _ in range(n)]
pStar(0, 0, n, stars)
for row in stars:
    for star in row:
        print(star, end='')
    print()
