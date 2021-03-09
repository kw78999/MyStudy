list = []

for i in range(2,10000):
    dcnt=0
    for j in range(1,i+1):
        if i%j==0:
            dcnt+=1
    if dcnt==2:
        list.append(i)
print(list)
print("1부터 1000까지 소수의 갯수",len(list))