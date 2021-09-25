import sys

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("shuffle.in", "r")
sys.stdout = open("shuffle.out", "w")

n = readInt()
ans = [0] * (n+1)
pos = seq()
numbers = seq()
for _ in range(3):
    for i in range(n):
        ans[i] = numbers[pos[i] - 1]
    numbers = ans.copy()
for i in range(n):
    print(ans[i])