#include <iostream>
#include "m_math.h"
using namespace std;
using namespace sort;

int main(){
    int arr[10] = {1,3,4,5,2,6,9,7,8,0};
    heap_sort(arr,10);
    for(int index = 0;index < 10;index++){
        cout << arr[index] <<endl;
    }
    return 0;
}
