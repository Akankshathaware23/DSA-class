import java.util.ArrayList;
import java.util.Collections;

public class L001 {
    // Time complexity : 0(n)
    // use case:
    // 1) Search in array
    // 2) do task for a n numbers kind of single for loop tasks
    // 3) one call recursion(single for loop)

    public static void printIncreasing(int a, int b) {
        if (a == b + 1)
            return;
        System.out.println(a);
        printIncreasing(a + 1, b);
    }

    public static void printDecreasing(int a, int b) {
        if (a == b + 1)
            return;
        printDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void printIncreDecre(int a, int b) {
        if (a > b)
            return;
        System.out.println(b);
        printIncreDecre(a, b - 1);
        System.out.println(b);

    }

    public static void printEvenOdd(int a, int b) {
        if (a > b)
            return;
        if (a % 2 == 0) {
            System.out.println(a);
        }
        printEvenOdd(a + 1, b);
        if (a % 2 != 0) {
            System.out.println(a);
        }
    }

    public static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int m = fact(n - 1);
        int ans = n * m;
        return ans;
    }

    public static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * power(a, b - 1);
    }

    public static int powerbtr(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int ans = power(a, b / 2);
        if (b % 2 == 0) {
            return a * ans;
        } else {
            return a * ans * ans;

        }
    }

    public static void display(int index, int arr[]) {
        if (arr.length == index) {
            return;
        }
        System.out.println(arr[index]);
        display(index + 1, arr);
    }

    public static void displayReverse(int index, int arr[]) {
        if (arr.length == index) {
            return;
        }

        displayReverse(index + 1, arr);
        System.out.println(arr[index]);
    }

    public static void displayOnEvenLocations(int index, int arr[]) {
        if (arr.length == index) {
            return;
        }
        if (index % 2 == 0) {
            System.out.println(arr[index]);
        }
        displayOnEvenLocations(index + 1, arr);

    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void displayOnPrimeLocations(int index, int arr[]) {
        if (arr.length == index) {
            return;
        }
        if (isPrime(index)) {
            System.out.println(arr[index]);
        }
        displayOnPrimeLocations(index + 1, arr);
    }

    public static int findData(int arr[], int data, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == data) {
            return index;
        }
        return findData(arr, data, index + 1);
    }

    public static int[] findAll(int arr[], int data, int index, int count) {

        if (arr.length == index) {
            int ansarr[] = new int[count];
            return ansarr;
        }
        if (arr[index] == data) {
            count++;
        }
        int ans[] = findAll(arr, data, index + 1, count);
        if (arr[index] == data) {
            ans[count - 1] = index;
        }
        return ans;
    }

    public static ArrayList<String> subsequence(int index, String str) {
        if (index == str.length()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        char ch = str.charAt(index);
        ArrayList<String> myans = new ArrayList<>();
        ArrayList<String> tempans = subsequence(index + 1, str);
        for (String s : tempans) {
            myans.add(s);
            System.out.println(myans);
            myans.add(ch + s);
            System.out.println(myans);
        }
        return myans;
    }

    public static void subsequence2(String str, int index, String ans) {
        if (index == str.length()) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(index);
        subsequence2(str, index + 1, ans);
        subsequence2(str, index + 1, ans + ch);
    }
    // ----------------
    static String dirS[] = { "H", "V", "D" };
    static int dirsA[][] = { { 0, 1 }, { 1, 0 }, { 1, 1 } };

    public static void MazePath(int sr, int sc, int er, int ec, String ans,
    int[][] m) {
    if (sr == er && sc == ec) {
    System.out.println(ans);
    return;
    }
    for (int i = 0; i < dirs.length; i++) {
    int r = sr + dirsA[i][0];
    int c = sc + dirsA[i][1];

    if (r >= 0 && c >= 0 && r <= er && c <= ec) {
    if (m[r][c] != 0) {

    MazePath(r, c, er, ec, ans + dirs[i],m);
    }

    }
    }
    }
    // ----------------
    static String diRs[] = {"N","ne","E","es","S","ws","W","nw"};
    static int diRA[][] = {{-1,0},{-1,1},
    {0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public static void mazePath(int sr,int sc,int er, int ec, String ans,int
    vis[][],ArrayList<String> temp){
    if(sr == er && sc == ec){
    System.out.println(ans);
    temp.add(ans);
    return;
    }
    vis[sr][sc] = 1;
    for(int d = 0;d <dirs.length; d++){
    int r = sr + dirA[d][0];
    int c = sc + dirA[d][1];
    if(r <= er && c <= ec && r>=0 && c >= 0 && vis[r][c] != 1){
    mazePath(r,c,er,ec,ans + dirs[d], vis ,temp);
    }

    }
    vis[sr][sc]=0;
    }

    // ----------------
    public static ArrayList<String> findPath(int[][] m,int n){
    String dris[] = {"D", "L", "R", "U"};
    int dirA[][] = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

    ArrayList<String> myans = new ArrayList<>();
    if(m[0][0] == 0 || m[n-1][n-1] == 0){
    return myans;
    }

    ratRace(0,0,n-1,n-1,"",dirA,dris,m,myans);

    }

    public static void ratRace(int sr, int sc, int er, int ec, String ans, int
    dirA[][], String[] dris, int vis[][], ArrayList<String> myans) {
    if (sr == er && sc == ec) {
    myans.add(ans);
    return;
    }

    int temp = vis[sr][sc];
    vis[sr][sc] = -1;

    for (int i = 0; i < dris.length; i++) {
    int r = sr + dirA[i][0];
    int c = sc + dirA[i][1];

    if (r >= 0 && c >= 0 && r <= er && c <= ec && vis[r][c] != 0) {
    if (vis[r][c] != -1) {
    ratRace(r, c, er, ec, ans + dris[i], dirA, dris, vis, myans);
    }
    }
    }
    vis[sr][sc] = temp;
    }

    // -------1 to n (jump)-------
    static int count = 0;
    static int n = 0;
    static String dirs[] = {"N","R","E","D","S","L","W","U"};
    static int DirA[][] = {{-1,0},{-1,1},
    {0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public static void mazePath(int sr,int sc,int er, int ec, String ans,intvis[][],ArrayList<String> temp){
    count++;
    if(sr == er && sc == ec){
    System.out.println(ans);
    temp.add(ans);
    return;
    }
    if(er > ec){
    n=er;
    }
    else{
    n=ec;
    }
    vis[sr][sc] = 1;
    for(int d = 0;d <dirs.length; d++){
    for(int jump = 1; jump <= n; jump++){
    int r = sr + dirA[d][0] * jump;
    int c = sc + dirA[d][1] * jump;
    if(r <= er && c <= ec && r>=0 && c >= 0 ){
    if(vis[r][c] != 1){
    mazePath(r,c,er,ec,ans + dirs[d] + "" + jump, vis ,temp);
    }
    }
    else{
    break;
    }
    }
    }
    vis[sr][sc]=0;
    }
    // --------array jumps------------
    public static void mpArrayJump(int sr,int sc,int er,int ec,String ans,int
    vis[][],int given[][],int dirA [][],String dirs[],ArrayList<String> result){
    if(sr == er && sc == ec){
    System.out.println(ans);
    result.add(ans);
    return;
    }
    vis[sr][sc] = 1;
    int temp = given[sr][sc];

    for(int d = 0;d <dirs.length; d++){
    for(int jump = 1; jump <= temp; jump++){
    int r = sr + dirA[d][0] * jump;
    int c = sc + dirA[d][1] * jump;
    if(r <= er && c <= ec && r>=0 && c >= 0 ){
    if(vis[r][c] != 1){
    mpArrayJump(r, c, er, ec, ans + dirs[d] + "" + jump, vis, given, dirA,
    dirs,result);
    }
    }
    }
    }

    vis[sr][sc]=0;

    }
    //----------
    public static void display(int arr[][]) {
    for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr[i].length; j++) {
    System.out.print(arr[i][j] + " ");
    }
    System.out.println();
    }

    }
    public static int[][] mpArrayJump2(int sr,int sc,int er,int ec,String ans,int
    vis[][],int given[][],int dirA [][],String dirs[],ArrayList<String> result){
    if(sr == er && sc == ec){
    System.out.println(ans);
    result.add(ans);
    vis[sr][sc] = 1;
    int myans[][] = new int[er+1][ec+1];
    for (int i = 0; i < myans.length; i++) {
    for (int j = 0; j < myans[i].length; j++) {
    myans[i][j] = vis[i][j];
    System.out.println(vis[i][j]);
    }
    }
    display(myans);
    // display(vis);
    vis[sr][sc] = 0;
    // return vis;
    return myans;
    }
    vis[sr][sc] = 1;
    int temp = given[sr][sc];
    int tempvar[][] = new int[er+1][ec+1];
    for(int d = 0;d <dirs.length; d++){
    for(int jump = 1; jump <= temp; jump++){
    int r = sr + dirA[d][0] * jump;
    int c = sc + dirA[d][1] * jump;
    if(r <= er && c <= ec && r>=0 && c >= 0 ){
    if(vis[r][c] != 1){
    tempvar = mpArrayJump2(r, c, er, ec, ans + dirs[d] + "" + jump, vis, given,
    dirA, dirs,result);
    }
    else{
    break;
    }
    }
    }
    }

    vis[sr][sc]=0;
    return tempvar;
    }

    //--------
    static class Path {
        String longestPath;
        int longestPathlength;
        String shortestPath;
        int shortestPathlength;
        int[][] longestPathco;
        int[][] shorttestPathco;
    }

    public static int[][] copyArray(int vis[][]) {

        int row = vis.length;
        int col = vis[0].length;
        int ans[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = vis[i][j];
            }
        }
        return ans;
    }

    static String dris[] = { "D", "L", "R", "U" };
    static int dirA[][] = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };

    public static Path mpArrayJump(int sr, int sc, int er, int ec, String ans, int given[][], int vis[][]) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            Path p = new Path();
            p.longestPath = ans;
            p.shortestPath = ans;
            p.longestPathlength = ans.length();
            p.shortestPathlength = ans.length();
            p.longestPathco = copyArray(vis);
            p.shorttestPathco = copyArray(vis);
            return p;
        }
        int maxJump = given[sr][sc];
        given[sr][sc] = -1;
        vis[sr][sc] = 1;

        Path myPath = new Path();
        myPath.longestPathco = new int[er + 1][ec + 1];
        myPath.shorttestPathco = new int[er + 1][ec + 1];
        myPath.shortestPathlength = (int) 1e9;
        myPath.longestPathlength = -(int) 1e9;
        myPath.shortestPath = "";
        myPath.longestPath = "";

        for (int i = 0; i < dris.length; i++) {
            for (int jump = 1; jump <= maxJump; jump++) {
                int r = sr + jump * dirA[i][0];
                int c = sc + jump * dirA[i][1];

                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    if (given[r][c] > 0) {
                        Path tempans = mpArrayJump(r, c, er, ec, ans + "" + dris[i] + "" + jump, given, vis);
                        if (tempans.longestPathlength > myPath.longestPathlength) {
                            myPath.longestPath = tempans.longestPath;
                            myPath.longestPathco = tempans.longestPathco;
                            myPath.longestPathlength = tempans.longestPathlength;
                        }
                        if (tempans.shortestPathlength < myPath.shortestPathlength) {
                            myPath.shortestPath = tempans.shortestPath;
                            myPath.shorttestPathco = tempans.shorttestPathco;
                            myPath.shortestPathlength = tempans.shortestPathlength;
                        }
                    }
                }
            }
        }
        given[sr][sc] = maxJump;
        vis[sr][sc] = 0;
        return myPath;
    }
    //---find all longest and shortest path
        static class Path {
        String longestPath;
        int longestPathlength;
        String shortestPath;
        ArrayList<String> shortestPaths;
        int shortestPathlength;
        int[][] longestPathco;
        int[][] shorttestPathco;
        

    }

    public static int[][] copyArray(int vis[][]) {

        int row = vis.length;
        int col = vis[0].length;
        int ans[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = vis[i][j];
            }
        }
        return ans;
    }

    static String dris[] = { "D", "L", "R", "U" };
    static int dirA[][] = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };

    public static Path mpArrayJump1(int sr, int sc, int er, int ec, String ans, int given[][], int vis[][]) {
        ArrayList<Path> shortestPaths = new ArrayList<>();        
        if (sr == er && sc == ec) {
            //System.out.println(ans);
            Path p = new Path();
            p.longestPath = ans;
            p.shortestPath = ans;
            p.shortestPaths.add(ans);
            p.longestPathlength = ans.length();
            p.shortestPathlength = ans.length();
            p.longestPathco = copyArray(vis);
            p.shorttestPathco = copyArray(vis);
            return p;
        }
        int maxJump = given[sr][sc];
        given[sr][sc] = -1;
        vis[sr][sc] = 1;

        Path myPath = new Path();
        myPath.longestPathco = new int[er + 1][ec + 1];
        myPath.shorttestPathco = new int[er + 1][ec + 1];
        myPath.shortestPathlength = (int) 1e9;
        myPath.longestPathlength = -(int) 1e9;
        myPath.shortestPath = "";
        myPath.longestPath = "";

        for (int i = 0; i < dris.length; i++) {
            for (int jump = 1; jump <= maxJump; jump++) {
                int r = sr + jump * dirA[i][0];
                int c = sc + jump * dirA[i][1];

                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    if (given[r][c] > 0) {
                        Path tempans = mpArrayJump(r, c, er, ec, ans + "" + dris[i] + "" + jump, given, vis);
                        if (tempans.longestPathlength > myPath.longestPathlength) {
                            myPath.longestPath = tempans.longestPath;
                            myPath.longestPathco = tempans.longestPathco;
                            myPath.longestPathlength = tempans.longestPathlength;
                        }
                        if (tempans.shortestPathlength < myPath.shortestPathlength) {
                            myPath.shortestPath = tempans.shortestPath;
                            myPath.shorttestPathco = tempans.shorttestPathco;
                            myPath.shortestPathlength = tempans.shortestPathlength;
                        }
                        else if(tempans.shortestPathlength == myPath.shortestPathlength) {
                            //String st = tempans.shortestPath.get(0);
                           // myPath.shortestPaths.add(st);
                        }
                    }
                }
            }
        }
        given[sr][sc] = maxJump;
        vis[sr][sc] = 0;
        return myPath;
    }

    // //=======================================call function====================

    public static void solve() {
        // printIncreasing(1, 5);
        // printDecreasing(1,5);
        // printIncreDecre(1,5);
        // printEvenOdd(1,5);
        // int n = fact(5);
        // System.out.println(n);

        // int p = power(2,5);
        // System.out.println(p);

        // int pb = powerbtr(2,5);
        // System.out.println(pb);

        // int arr[] = {0,1, 3, 3, 4, 5};
        // display(0, arr);
        // displayReverse(0, arr);
        // displayOnEvenLocations(0,arr);
        // displayOnPrimeLocations(0,arr);

        // int f = findData(arr, 3, 0);
        // System.out.println(f);

        // int fa[] = findAll(arr, 3, 0, 0);

        // for (int index : fa) {
        // System.out.println(index);
        // }
        // String str = "abc";
        // ArrayList<String> result = subsequence(0, str);
        // System.out.println(result);
        // Collections.sort(result);
        // System.out.println(result);

        // for(String s : result) {
        // System.out.println(s) ;
        // }

        // subsequence2(str, 0, "");

        // int maze[][] = {{1,1,1},
        // {1,1,1},
        // {1,1,1}};

        // MazePath(0, 0, 2, 2,"", maze);

        // int vis[][] = {{0,0,0},{0,0,0},{0,0,0}};
        // ArrayList<String> temp = new ArrayList<>();
        // mazePath(0, 0, 2, 2,"",vis,temp);
        // System.out.println(temp);
        // System.out.println(temp.size());
        // System.out.println("Total calls" + count);
        // String dirs[] = {"N","E","S","W"};
        // int dirA[][] = {{-1,0}, {0,1},{1,0},{0,-1}};

        int vis[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        int given[][] = { { 2, 1, 1, 1 }, { 3, 1, 0, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };

        // ArrayList<String> result = new ArrayList<>();
        // mpArrayJump(0, 0, 3, 3,"",vis,given,dirA,dirs,result);
        // System.out.println(result);
        // System.out.println(result.size());

        Path result = mpArrayJump(0, 0, 3, 3, "", given, vis);
        System.out.println("Longest Path: " + result.longestPath);
        System.out.println("Shortest Path: " + result.shortestPath);

        Path result1 = mpArrayJump1(0, 0, 3, 3, "", given, vis);
        System.out.println("Longest Path: " + result1.longestPath);
        System.out.println("Shortest Path: " + result1.shortestPath);
        System.out.println("Longest Path: " + result1.longestPath.length());
        System.out.println("Shortest Path: " + result1.shortestPath.length());     
        
       

        // int[][] maze = {
        // {1,0,0,0},
        // {1,0,0,0},
        // {1,0,0,0},
        // {1,0,0,0},
        // };
        // ArrayList<String> Path = findPath(maze, 4);

    }
    // =======================================main
    // method===============================

    public static void main(String[] args) {
        solve();

    }

}