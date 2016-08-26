

free_men = []
free_women = []
couples = []

def init_sets():
    pass

def gayle_shapley(free_men, free_women):
    couples = []
    while(len(free_men) > 0):
        m = free_men.pop()
        w = m.preferences.pop()
        if(w.spouse == None):
            m.enages(w)
            couples.add(Couple(m, w))
        else:
            if(w.prefers(m, w.spouse)):
                breakup(w, w.spouse)
                m.engages(w)
                couples.add(Couple(m, w))
            else:
                free_men.add(m)
    return couples

class Couple(object):
    def __init__(self, m, w):
        self.m = m
        self.w = w
        
    def breakup(m, w):
        m.spouse = None
        w.spouse = None
        free_men.add(m)
        free_women.add(w)
        
        for(c in couples):
            if self is c:
                couples.remove(c)

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
        
    def engages(m, w):
        m.spouse = w
        w.spouse = m
        free_men.remove(m)
        free_women.remove(w)


if __name__ == 'main':
    pass
