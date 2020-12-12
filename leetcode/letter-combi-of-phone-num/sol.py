def letterCombinations(digits):
    if len(digits) == 0:
        return []

    mappings = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
                '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
    prod = [i for i in mappings[digits[0]]]
    #print(prod)
    for c in range(1, len(digits)):
        newlist = []
        for a in mappings[digits[c]]:
            for x in prod:
                newlist.append(x + a)
        prod = newlist 
            
    #print(prod)
    return prod
    #for c in digits:
        


letterCombinations("23")

   
