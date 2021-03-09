sum = 0 
cnt = 0

while sum<1000:
    a = int(input("숫자를 입력 : "))
    sum +=a
    cnt +=1
else : 
    print("1000을 넘은 수 : {}, 평균은 : {}".format(str(sum),str(sum/cnt)))