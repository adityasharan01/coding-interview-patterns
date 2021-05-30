class Solution:
    def solve(self, shows, durations, k):
        ans = {}
        for i, j in zip(shows, durations):

            if i in ans:
                ans[i] += j
            else:
                ans[i] = j

        s = 0
        for i, m in enumerate(sorted(ans.values(), reverse=True)):
            if i > k - 1:
                break
            s += m
        return s

//
class Solution:
    def solve(self, shows, durations, k):
        d = dict()
        for i, j in zip(shows, durations):
            if i in d:
                d[i] = d[i] + j
            else:
                d.update({i: j})
        a = list(d.values())
        a.sort(reverse=True)
        return sum(a[:k])
