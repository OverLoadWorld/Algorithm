obj=main.o
target:$(obj)
	@echo "build target...."
	g++ -g $(obj) -o run
main.o:main.cpp
	@echo "make main.o...."
	g++ -c main.cpp 
clean:
	rm -rf *.o run
