t = 1,2,4,4,2,3,7,7,9,3,7,3,7,9,0,0
list=[]

for i in range(10):
    if t.count(i)>1:
        print("중복된 숫자 : ",i,t.count(i),"회")
for i in range(10):
    if i in t:
        list.append(i)
print(list)


