def find_uniq(arr):
    non_uniq = arr[0 if comp(arr[0], arr[1]) else 2]
    for a in arr:
        if not comp(non_uniq, a): 
            return a
    raise Exception("Bad input")

def comp(s0, s1):
    s0 = s0.strip()
    s1 = s1.strip()
    if len(s0) > 0 and len(s1) > 0:
        s0 = set(s0.lower())
        s1 = set(s1.lower())
        return s0 == s1
    elif len(s0) == 0 and len(s1) == 0:
        return True
    else:
        return False
print(find_uniq([ 'Aa', 'aa', 'aaaaa', 'BbBb', 'Aaaa', 'AaAaAa', 'a' ]))
print(comp("Aa", "aa"))

print(comp(" c  ", " dfd "))