from typing import List


class M:
    def minArray(self, numbers: List[int]) -> int:
        length = len(numbers) - 1
        if length > 0:
            for i in range(length):
                if numbers[i] > numbers[i + 1]:
                    return numbers[i + 1]
        if length is -1:
            return None
        return numbers[0]


a = M()
print(a.minArray([1]))
