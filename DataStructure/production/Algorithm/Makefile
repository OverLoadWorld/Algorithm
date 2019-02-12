obj = main.o
target:$(obj)
	g++ $(obj) -o run
main.o:main.cpp m_math.h
	g++ -c main.cpp 
clean:
	rm -rf *.o run

