import sys

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("lostcow.in", "r")
sys.stdout = open("lostcow.out", "w")

x, y = mul()
ans = 0
start = x
for i in range(abs(y-x)):
    step = (-2)**i
    finish = x + step
    if (x < y < finish) or (x > y > finish):
        ans += abs(y - start)
        break
    else:
        ans += abs(finish - start)
    start = finish
print(ans)