


def gayle_shapley(free_men, free_women):
    couples = []
    while(len(free_men) > 0):
        m = free_men.pop()
        w = m.preferences.pop()
        if(w.spouse == None):
            enage(m, w)
            free_women.remove(w)
        else:
            if(w.prefers(m, w.spouse)):
                breakup(w, w.spouse)
                engage(m,w)
            else:
                free_men.add(m)

def breakup(w, m, couples):
    m.spouse = None
    w.spouse = None
    for(c in couples):
        if(c.m.name == m.name and c.w.name == w.name):
            couples.remove(c)

def engage(m, w, couples):
    m.spouse = w
    w.spouse = m
    couples.add(Couple(m,w))

class Couple(object):
    def __init__(self, m, w):
        self.m = m
        self.w = w

class Person(object):
    name = None
    spouse = None
    preferences = []

    def prefers(self, m1, m2):
        m1rank = self.preferences.index(m1.name)
        m2rank = self.preferences.index(m2.name)
        if(m1rank < m2rank):
            return True
        return False


if __name__ == 'main':
    pass
