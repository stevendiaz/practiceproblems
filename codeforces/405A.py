import fileinput
n = None
weights = None
"""
PARSING
"""
for line in fileinput.input():
    if n is None:
        n = int(line)
    else:
        weights = line.split()
weights = [int(x) for x in weights]


"""
ALGORITHM
"""
def shift_weights(weights, i):
    if i == n - 1:
        return
    elif weights[i + 1] >= weights[i]:
        return
    else:
        remainder = weights[i] - weights[i+1]
        weights[i] = weights[i + 1]
        weights[i + 1] += remainder
        shift_weights(weights, i + 1)

for i in xrange(n - 2, -1, -1):
    shift_weights(weights, i)

print(' '.join(str(x) for x in weights))
