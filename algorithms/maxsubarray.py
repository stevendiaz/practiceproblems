

def findMaxSubIndex(a, size):
    start = end = curr_max = prev_max = _start = 0
    prev_max = a[0]
    for i in range(0, size):
        curr_max = curr_max + a[i]
        if curr_max < 0:
            start = i + 1
            curr_max = 0
        elif curr_max > prev_max:
            end = i
            _start = start
            prev_max = curr_max

    print("%d %d" % (_start, end))

a = [0, -1, -1, 4, 5, 6, -6]
b = [-1, 3, 4, 3, 5, -1, -2]
c = [631, -583, -975]
findMaxSubIndex(c,len(c))
