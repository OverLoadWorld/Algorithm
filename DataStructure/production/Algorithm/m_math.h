#ifndef M_MATH_H
#define M_MATH_H
#include <iostream>
using namespace std;
namespace sort{
    //排序算法
    //快速排序
    void quick_sort(int arr[],int left,int right){
         if(left >= right){
             return;
         }
         int flag = arr[left];
         int begin = left + 1;
         int end = right;
         while(begin <= end)
         {
            while(begin <= end && arr[begin] <= flag)
            {
                begin++;
            }
            while(begin <= end && arr[end] > flag)
            {
                end--;
            }
            if(begin < end){
                int temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp; 
            } 
         }
         arr[left] = arr[end];
         arr[end] = flag;
         quick_sort(arr,left,end - 1);
         quick_sort(arr,end + 1,right);
    };
    //插入排序
    void insert_sort(int arr[], int length){
        if(length < 1){
            return;
        }
        for(int current_no = 1;current_no < length;current_no++){
            int temp = arr[current_no];
            int current_ps = current_no;
            for(int set = current_no -1;set >= 0;set--)
            {
                if(arr[set] <= temp){
                        break;
                }else{
                    arr[set + 1] = arr[set];
                    current_ps--;
                }
            }
            if(current_ps < current_no)
            {
                arr[current_ps] = temp;
            }
        }   
    }
    //希尔排序
    void shell_sort(int arr[],int length){
        if(length < 1)
        {
            return;
        }
        int step = length/2;
        while(step >= 1){
             for(int current_no = step;current_no < length;current_no++)
             {
                int temp = arr[current_no];
                int current_ps = current_no; 
                for(int set = current_no - step;set >= 0;set-=step){
                    if(arr[set] <= temp){
                        break;
                    }else{
                    arr[set + step] = arr[set];
                        current_ps-=step;
                    }
                }
                if(current_ps < current_no)
                {   
                    arr[current_ps] = temp;
                } 
            }
            step = step/2;
        }
    }
    //归并排序
    void mergeSort(int arr[],int left,int right){
         if(left >=right)
         {
            return;
         }
         int mid = (left + right)/2;
         mergeSort(arr,left,mid);
         mergeSort(arr,mid+1,right);
         //merge(arr,left,mid,right);
    }

    void merge(int arr[],int begin,int mid,int end){
         int length = end - begin;
         int left = begin;
         int right = mid + 1;
         int arr_temp[length];
         for(int index =0;index < length;index++)
         {
            arr_temp[index] = arr[index+length];
         }
         for(int current_index = begin;current_index <= end;current_index++)
         {
            if(left > mid){
                arr[current_index] = arr_temp[right-length];
                right++;
            }else if(right > end){
                arr[current_index] = arr_temp[left-length];
                left++;
            }else if(arr[left] > arr[right]){
                arr[current_index] = arr_temp[left - length];
                left++;
            }else{
                arr[current_index] = arr_temp[right -length];
                right++;
            }
         }
    }

    //堆排序
    void maxHeap(int arr[],int heapSize,int current_node){
         int left_child = 2*current_node + 1;
         int right_child = 2*current_node + 2;
         int large_node = current_node;
         if(left_child < heapSize && arr[left_child] > arr[large_node]){
            large_node = left_child;
         }
         if(right_child < heapSize && arr[right_child] > arr[large_node]){
            large_node = right_child;
         }

         if(large_node!=current_node){
            int temp = arr[current_node];
            arr[current_node] = arr[large_node];
            arr[large_node] = temp;
         } 
    }    
    
    void buildMaxHeap(int arr[],int length){
        //反复进行调整
        for(int index = length;index >= 0;index--){
            maxHeap(arr,length + 1,index);
        }
    }
    
    void heap_sort(int arr[],int length){
        //每次循环都能取到一个最大值，该值为根节点
        for(int index = length - 1; index>=0; index--){
            //每次调整都是从根节点开始i不断减小，保证前一次最大节点不会参与到调整堆
            buildMaxHeap(arr,index);
            int temp = arr[index];
            arr[index] = arr[0];
            arr[0] = temp;
        }
    }
}
#endif //M_MATH_H
