import fileinput

for line in fileinput.input():
    n, m = [int(x) for x in line.split()]
    break

def square_factors(m):
    result = set({})
    result.add(m)
    curr = m * 1.0
    while(1 not in result):
        curr = (curr * 1.0)/2
        result.add(int(round(curr)))
        curr = int(round(curr))
    return result

def find_square(n, m):
    num_steps = 0
    factors = square_factors(m)
    while(n != m):
        if n in factors:
            n *= 2
        else:
            n -= 1
        num_steps += 1
    return num_steps

print(find_square(n, m))
