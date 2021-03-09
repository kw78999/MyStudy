num = int(input("숫자 입력: "))
pnum=[]  #빈 리스트 생성

for i in range(1,num+1):
    dcnt=0   #약수의 갯수를 저장하는 변수

    for j in range(1,i+1):
        if i%j==0:
            dcnt+=1
    if dcnt==2: #약수의 갯수가 2개면
        pnum.append(i)
print("1부터",num,"까지의 소수 리스트 : ",pnum)
print("1부터",num,"까지의 소수 개수 :",len(pnum))
