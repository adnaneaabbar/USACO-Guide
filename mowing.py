import sys

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("mowing.in", "r")
sys.stdout = open("mowing.out", "w")

def move(direction):
	dx, dy = 0, 0
	if direction == "N":
		dy = 1
	if direction == "S":
		dy = -1
	if direction == "E":
		dx = 1
	if direction == "W":
		dx = -1
	return dx, dy

n = readInt()
grass = [[0 for _ in range(2500)] for _ in range(2500)]
ans = 2500
start_x, start_y = 1250, 1250

count = 0
for _ in range(n):
	d, s = input().split()
	dx, dy = move(d)

	s = int(s)
	for _ in range(s):
		start_x += dx
		start_y += dy
		count += 1
		curr_count = grass[start_x][start_y]
		# if visited update answer if needed with min (distance total - last visited)
		if curr_count > 0:
			ans = min(ans, count - curr_count)
		# update visited
		grass[start_x][start_y] = count

print(-1 if ans == 2500 else ans)
