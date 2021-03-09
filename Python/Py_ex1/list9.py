import random
n =set()
while True:
    for i in range(10):
        n.add(random.randint(1,100))
    if len(n)==10:
        break;
    n.clear()


print(n)

list=list(n)
minnum=list[0]
for i in range(10):
    if minnum>list[i]:
        minnum=list[i]
maxnum=list[0]
for i in range(10):
    if maxnum<list[i]:
        maxnum=list[i]

print(minnum)
print(maxnum)
list.sort()
print(list[0])
print(list[-1])