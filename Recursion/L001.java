package Recursion;

public class L001 {
  //-----1---------permutation infintie coins
  public static int perCoins(int arr[],int target , String ans){
    if(target == 0){
        //System.out.println(ans);
        return 1;
    }

int count = 0;
for(int ele :arr){
    if (target - ele >= 0){
        count += perCoins(arr , target - ele, ans + " " + ele);
    }
}
return count;
}

//------2---------combination infinite coins
public static int combCoins(int arr[], int indx , int tar,String ans){
    if(tar == 0){
        System.out.println(ans);
        return 1;
    }
    int count = 0;
    for(int i = indx; i < arr.length;i++){
        if(tar-arr[i] >= 0){
            count += combCoins(arr, i , tar - arr[i],ans + "" +arr[i]);
        }
    }
    return count;
}
//------3---------combination infinite coins
public static int combCoins1(int arr[], int indx , int tar,String ans){
if(tar == 0){
    System.out.println(ans);
    return 1;
}
int count = 0;
for(int i = indx; i < arr.length;i++){
    if(tar-arr[i] >= 0){
        count += combCoins1(arr, i + 1, tar - arr[i],ans + "" +arr[i]);
    }
}
return count;
}
//---------------4---------
public static int perCoinsU(int arr[],int target , String ans, int vis[]){
if(target == 0){
    System.out.println(ans);
    return 1;
}

int count = 0;
for(int i = 0; i < arr.length; i++){
if (vis[i]==0 && target - arr[i] >= 0 ){
    vis[i] = 1;
    count += perCoinsU(arr , target - arr[i], ans + " " + arr[i], vis);  
    vis[i] = 0;
}

}
return count;
}   
//---------5-----------
public static int comInfCoins(int arr[], int tar,int idx, String ans){
if(tar == 0 || idx == arr.length){
    if(tar == 0){
        System.out.println(ans);
        return 1;
    }
    return 0;
}
int count = 0;
if(tar - arr[idx]>= 0)
count += comInfCoins(arr, tar - arr[idx], idx , ans + arr[idx]);
count += comInfCoins(arr, tar, idx + 1, ans);
return count;
}
//------6---------
public static int comOneCoins(int arr[], int tar,int idx, String ans){
if(tar == 0 || idx == arr.length){
    if(tar == 0){
        System.out.println(ans);
        return 1;
    }
    return 0;
}
int count = 0;
if(tar - arr[idx]>= 0)
count += comOneCoins(arr, tar - arr[idx], idx + 1 , ans + arr[idx]);
count += comOneCoins(arr, tar, idx + 1, ans);
return count;
}
//-----------7-----------
public static int PerInfCoins(int arr[], int tar,int idx, String ans){
if(tar == 0 || idx == arr.length){
    if(tar == 0){
        System.out.println(ans);
        return 1;
    }
    return 0;
}
int count = 0;
if(tar - arr[idx]>= 0)
count += PerInfCoins(arr, tar - arr[idx], 0 , ans + arr[idx]);
count += PerInfCoins(arr, tar, idx + 1, ans);
return count;
}
//----------8-----------
public static int perOneCoins(int []arr,int tar,int idx,String ans){
if(tar==0 || idx==arr.length){
    if(tar==0){
     System.out.println(ans);
     return 1;
    }
    return 0;
 }
 int count=0;
 if(arr[idx]>0 && tar-arr[idx]>=0){
    int ele= arr[idx];
    arr[idx]= -ele;
    count += perOneCoins(arr,tar-ele,0,ans+ele);
    arr[idx]=ele;
 }
 count += perOneCoins(arr,tar,idx+1,ans);
 return count;
}




public static void solve() {
    // //-------1---------
    int arr[] = {2,3,5,7};
    int target = 10;
    // int result = perCoins(arr, target, "");
    // System.out.println("total permutation :" + result);

    // //-----4---------
    // int vis[] = new int[4];
    // int result3= perCoinsU(arr, target, "",vis);
    // System.out.println("total permutation one coin once: " + result3);

    // //--------2--------
    // int result1 = combCoins(arr, 0, target, "");
    // System.out.println("Total combinations: " + result1);


    //---------3-------
    // int result2 = combCoins1(arr, 0, target, "");
    // System.out.println("Total combinations one coin once: " + result2);

    //---------5--------
    int result5 = comInfCoins(arr, target, 0,"");
    System.out.println("Total combination for infinite subsequence:" +result5);

    //---------6--------
    int result6 = comOneCoins(arr, target, 0,"");
    System.out.println("Total combination for one time coin use subsequence:" +result6);

    //-------7----------
    int result7 = PerInfCoins(arr, target, 0,"");
    System.out.println("Total permutation for infinite subsequence:" +result7);

    //--------8----------
    int result8 = perOneCoins(arr, target, 0,"");
    System.out.println("Total permutation for Single subsequence:" +result8);
}
public static void main(String[] args) {
solve();
}  
}
