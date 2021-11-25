import sys

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("censor.in", "r")
sys.stdout = open("censor.out", "w")
# sys.stdin = open("input.in", "r")
# sys.stdout = open("output.out", "w")

s = readLine()
pattern = readLine()
ans = ""
for i in range(len(s)):
    ans += s[i]
    if len(ans) >= len(pattern):
        if ans[len(ans) - len(pattern) : ] == pattern:
            ans = ans[ : len(ans) - len(pattern)]
print(ans)