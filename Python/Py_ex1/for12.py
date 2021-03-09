

for i in range(2,10):
    print("=={}단==".format(i))
    for j in range(1,10):
        if i*j%2==0:
            print("{} * {} = {}".format(i,j,i*j))