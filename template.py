import sys

mul = lambda: map(int,input().strip().split())
seq = lambda: list(map(int,input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("input.in", "r")
sys.stdout = open("output.out", "w")

# t = readInt()
# for _ in range(t):
#     n, m = mul()