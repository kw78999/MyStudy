
sum = 0
cnt = 0
for i in range(1,10+1):
    a = int(input("{}번쨰 숫자 입력".format(i)))
    if a>0:
        sum +=a
        cnt +=1
print("0보다 큰수 합계 : {} ,평균 : {}".format(sum,sum/cnt))