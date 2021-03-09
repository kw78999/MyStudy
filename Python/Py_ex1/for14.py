n1=int(input("숫자 입력 :"))
n2=int(input("숫자 입력 :"))

if n1>n2:
    type = n1
    n1 = n2
    n2 = type 

if n1%2==0:
    n1 +=110
for i in range(n1+2,n2,2):    
    print(i)