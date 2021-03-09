sum = 0
i = 1

while i<6:
    a= int(input("{}번째 성적 입력 : ".format(i)))
    if a<0 or a>100 :
       print("유효하지 않은 값입니다")
       continue
    sum = sum + a
    i+=1
else : 
    print("총점 : "+str(sum))
    print("평균 : "+str(sum/5))