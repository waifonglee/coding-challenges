class Solution:
    #Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        # backtracking algo. add ( if current num is less than n, 
        # add ) only if number of ) is less than num of (
        def gen(string, left, right): 
            if len(string) == 2 * n:
                ans.append(string)
                return
            if left < n:
                gen(string + '(', left + 1, right)
            if right < left:
                gen(string + ')', left, right + 1)
        gen('', 0, 0)
        return ans
            

