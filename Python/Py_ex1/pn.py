p = int(input("소수 검증 숫자 입력 : "))

for i in range(2,p):
    if p%i==0:
        print("소수가 아닙니다")
        break
else:
    print("소수 입니다")

print("검증 완료")
    


p2 = int(input("소수 검증 숫자 입력 : "))
i=2
while i<p2:
    if p%i==0:
        print("소수가 아닙니다")
        break
    i += 1
else:
    print("소수 입니다")

print("검증 완료")
