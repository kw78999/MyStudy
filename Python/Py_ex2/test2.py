def changeData(x,y): #정수를 매개변수로 사용
    x=x+y
    print("x의 값은 : ",x)

def changeData2(num): #리스트를 매개변수로 사용 
    num[1]=200
    print(num)

a=10
b=20
changeData(a,b)
print(a)

list=[10,20,30]
changeData2(list)
print(list)