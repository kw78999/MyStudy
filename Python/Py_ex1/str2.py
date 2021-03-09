s1 = input('영어 문장 입력: ')

print("입력된 문장의 길이: ",len(s1))
print("각 단어의 첫 문자를 대문자로 : ",s1.title())
print("모든 글자 대문자로 : ",s1.upper())
print("문자열에 a가 몇번 나오는지 : ",s1.count('a'))
print("모두 문자인가 ? ",s1.isalpha()) # 전부 문자인지 검사
print("모두 숫자인가 ? ",s1.isdigit())#전부 숫자인가?
print("모두 대문자인가? ",s1.isupper())#전부 대문자인가?
