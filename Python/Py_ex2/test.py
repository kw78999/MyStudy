def BigSmall(a,b):
    if a>b:
        big=a
        small=b
    else:
        big=b
        small=a
    return big,small


print(BigSmall(10,11))