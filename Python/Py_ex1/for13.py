
i=1
while True:
    num1 = int(input("첫번쨰 점수:"))
    num2 = int(input("두번쨰 점수:"))
    num3 = int(input("세번쨰 점수:"))
    if num1+num2+num3==0:
        print("총{}명 성적 처리함".format(i-1))
        break
    print("{}번쨰 학생 : 총점 {}점, 평균{} 점".format(i,num1+num2+num3,(num1+num2+num3)/3))
    i=i+1