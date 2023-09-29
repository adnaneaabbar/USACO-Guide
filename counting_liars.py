from typing import NamedTuple

readInt = lambda: int(input())
readLine = lambda: input().strip()

class Cow(NamedTuple):
    pos: int
    direction: str

n = readInt()
cows = []
for _ in range(n):
    direction, pos = readLine().split()
    cows.append(Cow(int(pos), direction))

cows.sort(key=lambda c: c.pos)

lying_left = [0 for _ in range(n)]
lying_right = [0 for _ in range(n)]

for i in range(1, n):
    lying_left[i] += lying_left[i - 1]
    if cows[i - 1].direction == "L" and cows[i].pos > cows[i - 1].pos:
        lying_left[i] += 1

for i in range(n - 2, -1, -1):
    lying_right[i] += lying_right[i + 1]
    if cows[i + 1].direction == "G" and cows[i].pos < cows[i + 1].pos:
        lying_right[i] += 1

ans = n
for i in range(n):
    ans = min(ans, lying_left[i] + lying_right[i])

print(ans)