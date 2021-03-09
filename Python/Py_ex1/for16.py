
sum = 0
for i in range(1,100+1):
    sum+=i
    if i%10==0:
        print("1 - {} : {}".format(i,sum))