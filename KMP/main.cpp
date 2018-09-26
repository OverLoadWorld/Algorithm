#include <iostream>
#include <iomanip>
#include <string>
using namespace std;
/* function:solve max prefix surfirx
 * input: 
 * output:
 *
 */
int max_presuf(string str,int array[]){ 
    int ret = -1;
    int length = str.length();
    int pre_end = 0;
    if(length == 0){
        cout << "pattern string is empty" << endl;
        return ret;
    }
    for(int index = 1;index < length;index++){
        while((pre_end >0 )&&(str[pre_end]!=str[index])){
            pre_end = array[pre_end - 1];
        }
        if(str[pre_end] == str[index]){
            pre_end++;
        }  
            array[index] = pre_end;
    }    
    return ret;
};
int kmp(string ts,string ps,int array[]){
    int t_length = ts.size();
    int p_length = ps.size();
    int pre_end = 0;
    if(t_length == 0 || p_length == 0){
        return -1;
    }
    //solve max prefix suffix array
    max_presuf(ps,array);
    for(int index = 0;index < t_length;index++){
       while(pre_end > 0 && ps[pre_end] != ts[index]){
            pre_end = array[pre_end - 1];
       }
       if(ps[pre_end] == ts[index]){
            pre_end++;
       }
       if(pre_end == p_length){
           return index - p_length + 1;
       }
   } 
   return -1;
}

int main(){
    string ts;  //target string
    string ps;  //pattern string
    cout << "pleaase input pattern string:"<<endl;
    cin >> ps;
    int length = ps.size();
    int *F = new int[length];
    for(int index = 0;index < length;index ++){
        F[index] = -1;
    }
    F[0] = 0;
    cout << "please input target string:" << endl;
    cin >> ts;
    int position = kmp(ts,ps,F);
    for(int index = 0;index < length;index++){
        cout <<ps.substr(0,index + 1) <<": "<<right<<setw(length - index)<<F[index]<<endl;
    }
    cout <<"position:" << position <<endl;
    return 0;
}
