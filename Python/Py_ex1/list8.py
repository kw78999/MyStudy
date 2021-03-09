p={}

for i in range(2):
    id=int(input(str(i+1)+"번째 학생 학번 : "))
    pnum=int(input(str(i+1)+"번째 학생 전화번호 : "))

    p[id]=pnum
print("완성입니다")


id=int(input("학번 입력하세요"))

if id in p:
    print(p[id])  
else:
    print("none")
