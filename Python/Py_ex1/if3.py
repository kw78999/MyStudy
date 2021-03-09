num = int(input("팩토리얼 숫자 입력: "))
a =1

for i in range(num,0,-1):
   a=a*i
print("{}의 팩토리얼 값은 : {}".format(num,a))