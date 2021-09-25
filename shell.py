import sys

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("shell.in", "r")
sys.stdout = open("shell.out", "w")

n = readInt()
pos = [0, 1, 2, 3]
ans = [0, 0, 0, 0]
for i in range(n):
    a, b, g = mul()
    pos[a], pos[b] = pos[b], pos[a]
    ans[pos[g]] += 1
print(max(ans))