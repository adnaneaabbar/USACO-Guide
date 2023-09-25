import sys

'''
Adnane Aabbar
github : @adnaneaabbar
'''
mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
mulstr = lambda: map(str, input().strip().split())
seqstr = lambda: list(map(str, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
# sys.stdin = open("input.in", "r")
# sys.stdout = open("output.out", "w")
sys.stdin = open("measurement.in", "r")
sys.stdout = open("measurement.out", "w")

milkCount = {
    "Bessie" : 7,
    "Elsie" : 7,
    "Mildred" : 7
}
wall = [["Bessie", "Elsie", "Mildred"]]

def winner():
    b, e, m = milkCount.values()
    wallEntry = []
    win = max(b, e, m)
    if win == b:
        wallEntry.append("Bessie")
    if win == e:
        wallEntry.append("Elsie")
    if win == m:
        wallEntry.append("Mildred")
    return wallEntry

n = readInt()
l = []
for i in range(n):
    l.append(seqstr())
l.sort(key=lambda x : int(x[0]))
ans = 0
for wallEntry in l:
    milkCount[wallEntry[1]] += int(wallEntry[2])
    we = winner()
    if wall[-1] != we:
        ans += 1
        wall.append(we)

print(ans)