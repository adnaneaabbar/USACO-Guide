import sys

mul = lambda: map(int, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))
readInt = lambda: int(input())
readLine = lambda: input().strip()
sys.stdin = open("tttt.in", "r")
sys.stdout = open("tttt.out", "w")

def addSet(answer, cows):
    s = set()
    for cow in cows:
        s.add(cow)
    if len(s) == 1:
        if s not in answer[0]:
            answer[0].append(s)
    elif len(s) == 2:
        if s not in answer[1]:
            answer[1].append(s)

# will hold 2 lists of sets of possible answers fo one cow and two cows
ans = [[] for i in range(3)]

board = []
for i in range(3):
    board.append(list(input().strip()))

for i in range(3):
    # lines
    addSet(ans, board[i])
for j in range(3):
    # columns
    addSet(ans, [board[0][j], board[1][j], board[2][j]])
# diags
addSet(ans, [board[0][0], board[1][1], board[2][2]])
addSet(ans, [board[0][2], board[1][1], board[2][0]])

print(len(ans[0]))
print(len(ans[1]))
