import sys

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("blocks.in", "r")
sys.stdout = open("blocks.out", "w")

def computeFreq(s):
    freq = [0 for i in range(26)]
    for c in s:
        freq[ord(c) - ord('a')] += 1

    return freq


n = readInt()
ans = [0 for i in range(26)]
for i in range(n):
    s1, s2 = input().strip().split()
    f1, f2 = computeFreq(s1), computeFreq(s2)
    for j in range(26):
        ans[j] += max(f1[j], f2[j])

print(*ans, sep='\n')
