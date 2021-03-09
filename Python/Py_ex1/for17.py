
i=1
sum = 0

while i<11:
    a = int(input("{}번째 숫자 입력".format(i)))
    if i%2==0:
            a = -a
    sum += a
    i+=1
else:
    print("합계 : "+str(sum))
    
print(3*3*13*179*271*1381*2423)