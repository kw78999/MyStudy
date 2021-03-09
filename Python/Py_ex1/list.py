list = [[0],[21,22,23],[31,3,-3,34],[43]]
sum = 0
min2 = list[0][0]
for j in range(len(list)):
    if min2 >min(list[j]):
        min2 = min(list[j])
    for i in range (len(list[j])):
        sum += list[j][i]



print("합 : ",sum)
print(min2)