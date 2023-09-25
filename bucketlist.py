import sys

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("blist.in", "r")
sys.stdout = open("blist.out", "w")

n = readInt()
s = []; t = []; b = []
for _ in range(n):
    l, m, o = mul()
    s.append(l); t.append(m); b.append(o)

need = [0] * 1005
for i in range(n):
    for j in range(s[i], t[i]):
        need[j] += b[i]
ans = max(need)
print(ans)