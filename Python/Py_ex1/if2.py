s = input("당신의 성별은? M or m 또는 F or f")
cm = int(input("키를 입력(cm) :"))
kg = int(input("몸무게를 입력(kg) :"))

if s=='m' or s=='M':
    v = cm*cm/10000*22

    if v*1.2<kg :
        print("과체중입니다")
    elif v*1.1 <= kg <= v*1.19:
        print("비만 체중입니다")
    else : 
        print("표준 체중입니다")
elif s=='f' or s=='F':
    v = cm*cm/10000*21

    if v*1.2<kg :
        print("과체중입니다")
    elif v*1.1<=kg and v*1.19>=kg :
        print("비만 체중입니다")
    else : 
        print("표준 체중입니다")
else : 
    print("성별입력이 잘못 되었습니다")