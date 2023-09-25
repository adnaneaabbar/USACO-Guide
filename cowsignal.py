import sys

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("cowsignal.in", "r")
sys.stdout = open("cowsignal.out", "w")

m, n, k = seq()
for i in range(m):
    row = ""
    line = readLine()
    for ch in line:
        row += ch * k
    for j in range(k):
        print(row)