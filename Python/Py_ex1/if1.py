a1=int(input("숫자를 입력하세요 : "))
a2=int(input("숫자를 입력하세요 : "))

if a1%2==0 :
    if a2%2==0 :
        print("둘다 짝수입니다") 
    else :
        print("짝수 홀수가 섞여있습니다.")
else : 
    if a2%2==1 :
        print("둘다 홀수입니다") 
    else : 
        print("짝수 홀수가 섞여있습니다.")