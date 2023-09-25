import sys

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("mixmilk.in", "r")
sys.stdout = open("mixmilk.out", "w")
l = []
for i in range(3):
    l.append(seq())
flag = 1
for _ in range(100):
    if flag == 1:
        poured = min(l[0][1], l[1][0] - l[1][1])
        l[0][1] -= poured
        l[1][1] += poured
        flag = 2
    elif flag == 2:
        poured = min(l[1][1], l[2][0] - l[2][1])
        l[1][1] -= poured
        l[2][1] += poured
        flag = 3
    elif flag == 3:
        poured = min(l[2][1], l[0][0] - l[0][1])
        l[2][1] -= poured
        l[0][1] += poured
        flag = 1
for i in range(3):
    print(l[i][1])