s1 = 'i Like python languege'
s2=s1.capitalize()  #맨앞글자만 대문자
s3=s1.title()      #공백을 기준으로 맨앞글자 대문자
s4=s1.upper()   #모두 대문자

s1='i like python'
s2=s1.center(40) #전체 길이 40으로 바꾸고 가운데로 정렬
s3=s1.center(30,"*") #전체길이 30 가운데 정렬 빈공간은 *
s4.count('L')  # s4에 L이 몇개 들어있는지 검사

s1='i like python languege'
s1.index('i')  #인덱스중 i가 몇번째에 있는지 검사
s1.rindex('l') #l이 몇번쨰에 있는지 오른쪽에서 부터 검사
s1.find('python') #python 단어가 몇번째 있는지 검사 없을경우 -1
s1.index('python') #위와 동일 없을경우 에러

print(s1.find('p'))