def main():
    print("Hello World")
    a=3
    x=int(input())
    y="text"
    print(x)
    print(y)
    a=7
    if a>5+x:
        print("menor que 4")
        print("acabar o if")
    else:
        print("else")

    while x>0:
        print(x)
        x=x-1
        if x==1:
            print(1)
        else:
            print("else")


if __name__ == "__main__":
    main()
