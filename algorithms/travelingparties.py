from random import shuffle
import copy


def run(pairs, hosts, rounds):
    for rnd in range(0, rounds):
        print("ROUND %d" % rnd)
        temp_pairs = copy.deepcopy(pairs)
        temp_hosts = copy.deepcopy(hosts)
        shuffle(temp_pairs)
        shuffle(temp_hosts)
        print("%s : %s %s %s %s"    %  (temp_hosts.pop(), temp_pairs.pop(), temp_pairs.pop(), temp_pairs.pop(), temp_pairs.pop()))
        print("%s : %s %s %s %s"    %  (temp_hosts.pop(), temp_pairs.pop(), temp_pairs.pop(), temp_pairs.pop(), temp_pairs.pop()))
        print("%s : %s %s %s %s"    %  (temp_hosts.pop(), temp_pairs.pop(), temp_pairs.pop(), temp_pairs.pop(), temp_pairs.pop()))
        print("%s : %s %s %s %s %s" %  (temp_hosts.pop(), temp_pairs.pop(), temp_pairs.pop(), temp_pairs.pop(), temp_pairs.pop(), temp_pairs.pop()))
        print("\n")

if __name__ == "__main__":
    hosts = ['A', 'C', 'L', 'J']
    pairs = range(1, 22)
    print(pairs)
    print(hosts)
    rounds = 4
    run(pairs, hosts, rounds)
