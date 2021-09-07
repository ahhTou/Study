class Solution_Dfs:
    def movingCount(self, m: int, n: int, k: int) -> int:

        visited = set()

        def dfs(i: int, j: int) -> int:
            if i >= m or j >= n or k < (0.9 * (i % 10 + j % 10) + (i + j) / 10) or (i, j) in visited:
                return 0
            visited.add((i, j))
            return 1 + dfs(i+1, j) + dfs(i, j+1)

        return dfs(0, 0)


class Solution_Bfs:
    def movingCount(self, m: int, n: int, k: int) -> int:

        visited, queue = set(), [(0, 0)]

        while queue:
            i, j = queue.pop()
            if i >= m or j >= n or k < (0.9 * (i % 10 + j % 10) + (i + j) / 10) or (i, j) in visited:
                continue
            visited.add((i, j))
            queue.append((i+1, j))
            queue.append((i, j+1))

        return len(visited)
