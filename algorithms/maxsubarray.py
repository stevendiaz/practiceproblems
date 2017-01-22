

def findMaxSubIndex(a, size):
    start = end = curr_max = prev_max = _start = 0
    prev_max = a[0]
    for i in range(1, size):
        curr_max = curr_max + a[i]
        if curr_max < prev_max:
            start = i + 1
            curr_max = 0
        elif curr_max > prev_max:
            end = i
            _start = start
            prev_max = curr_max

    print("%d %d" % (_start, end))

a = [ -3, -1, -6]
#b = [-1, 3, 4, 3, 5, -1, -2]
#c = [631, -583, -975]
findMaxSubIndex(a,len(a))
