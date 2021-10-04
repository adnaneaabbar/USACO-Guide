import sys

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
spl = lambda: input().strip().split()
readInt = lambda: int(input())
readLine = lambda: input().strip()

sys.stdin = open("traffic.in", "r")
sys.stdout = open("traffic.out", "w")

n = readInt()
l = []
highForward = 10**6
lowForward = -10**6
highBack = 10**6
lowBack = -10**6

for _ in range(n):
    l.append(spl())

for a in l:
    if a[0] == "none":
        highForward = min(highForward, int(a[2]))
        lowForward = max(lowForward, int(a[1]))
    if a[0] == "on":
        highForward += int(a[2])
        lowForward += int(a[1])
    if a[0] == "off":
        highForward -= int(a[1])
        lowForward -= int(a[2])

for a in reversed(l):
    if a[0] == "none":
        highBack = min(highBack, int(a[2]))
        lowBack = max(lowBack, int(a[1]))
    if a[0] == "on":
        highBack -= int(a[1])
        lowBack -= int(a[2])
    if a[0] == "off":
        highBack += int(a[2])
        lowBack += int(a[1])

print(max(0, lowBack), max(0, lowBack, highBack))
print(max(0, lowForward), max(0, lowForward, highForward))