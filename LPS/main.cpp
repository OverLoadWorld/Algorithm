#include <iostream>
#include <string>
using namespace std;

string longestPalindrome(string &s) {
           // write your code here
           int length = s.length();
           if(length < 1){
               return nullptr;
           }
           bool palindrome[length][length];
           int max_p = 1;
           int str_start = 0;
           //initialize palindrome
           for(int str_index = 0;str_index < length;str_index++){

               for(int index = 0;index < length;index++){
                   palindrome[str_index][index] = false;
               }

           }

           for(int end = 0;end < length;end++){
               for(int start = 0;start <= end;start++){
                    if(end - start < 2){
                        if(s[start] == s[end]){
                            palindrome[start][end] = true;
                        }else{
                            palindrome[start][end] = false;
                        }
                    }else{
                        if(s[start] == s[end] && palindrome[start+1][end -1]){
                            palindrome[start][end] = true;
                        }else{
                            palindrome[start][end] = false;
                        }
                    }
                    if(palindrome[start][end]){
                        if(max_p < (end - start + 1)){
                            max_p = end -start + 1;
                            str_start = start;
                        }
                    }

               }
           }
           return s.substr(str_start,max_p);
    }

int main(){
    string str;
    cin>>str;
    string result =longestPalindrome(str);
    cout << result <<endl;
    return 0;
}
