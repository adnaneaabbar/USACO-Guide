import sys
from collections import deque

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("cbarn.in", "r")
sys.stdout = open("cbarn.out", "w")

n = readInt()
l = []
ans = 10**9
for _ in range(n):
    l.append(readInt())

barn = deque(range(n))
for i in range(n):
    ans = min(sum([barn[i] * l[i] for i in range(n)]), ans)
    barn.rotate(1)

print(ans)