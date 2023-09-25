import sys

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("speeding.in", "r")
sys.stdout = open("speeding.out", "w")

n, m = mul()
limit = []
speed = []
for i in range(n):
    r = seq()
    for _ in range(r[0]):
        limit.append(r[1])
for i in range(m):
    s = seq()
    for _ in range(s[0]):
        speed.append(s[1])
ans = 0
it = zip(limit, speed)
for i, j in it:
    ans = max(ans, j - i)
print(ans)
