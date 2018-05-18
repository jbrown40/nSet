import java.util.Random;

public class nSet {
    // this class implements the set operations over sets of natural numbers.
    public int Max; // maximal natural number in any set
    private int n_long; // the number of long integers: 64*n_long >= Max
    private long[] store; // store has n_long positions

    // Constructor
    public nSet(int n) {
        this.Max = n;
        if (n < 0) {
            this.Max = 1;
        }
        this.n_long = (n >> 6) + 1; // n_long = n/64+1, number of longs
        this.store = new long[n_long];
        for (int i = 0; i < this.n_long; i++) this.store[i] = 0;
    }

    public void add(int x) {
        // add x into the set
        if (x < 0 || x > this.Max) return;
        int i = (x >> 6);     // i = x/64
        int j = x - (i << 6); // j = x % 64, i.e., 64i + j = x
        this.store[i] |= ((long) 1 << j);  // "|" is the bitwise OR operation
    }

    public boolean find(int x) {
        // decide if x is in the set
        if (x < 0 || x > this.Max) return false;
        int i = (x >> 6);     // i = x/64
        int j = x - (i << 6); // j = x % 64, i.e., 64i + j = x
        long y = this.store[i];
        return ((y >> j) & ((long) 1)) == 1; // "&" is the bitwise OR operation
    }
	

	public boolean isEmpty () {
	   // return true iff the current nSet is empty
        for (int i = 0; i < this.n_long; i++){
            if (this.store[i] > 0){
                return false;
            }
        }
        return true;
	} 
	
	public void clear () {
	   // remove all numbers from the current nSet
        for (int i = 0; i < this.store.length; i++){
            this.store[i] = 0;
        }
	} 
	
	public int size () {
	   // return the number of numbers in the current nSet
        int counter = 0;
        for (int i = 0; i < this.Max; i++){
            if (this.find(i)){
                counter++;
            }
        }
        return counter;
	} 
	
	public boolean delete (int x) {
	   // remove x from the current set if x exists and true is returned; 
	   // otherwise, return false.
        if(this.find(x)){
            long z = (x >> 6);     // i = x/64
            for (int i = 0; i < this.store.length; i++){
                if (this.store[i] == z){
                    this.store[i] = 0;
                    return true;
                }
            }
        }
        return false;

    }
	
	public nSet union (nSet X) {
	   // return a new nSet which is the union of the current nSet and X
        nSet unionSet = new nSet(X.Max+this.Max);
        for(int i = 0; i < this.Max; i++){
            if(this.find(i)) unionSet.add((i));
        }
        for(int i = 0; i < X.Max; i++){
            if(X.find(i)) unionSet.add((i));
        }

        return unionSet;
	} 
	 
	public nSet intersect (nSet X) {
	   // return a new nSet which is the intersection of the current nSet and X
        nSet intersectionSet;
        if(X.Max>this.Max){
            intersectionSet = new nSet(X.Max);
        }
        else{
            intersectionSet = new nSet(this.Max);
        }
        for(int i = 0; i < intersectionSet.Max; i++){
            if(X.find(i) && this.find(i)){
                intersectionSet.add(i);
            }
        }
        return intersectionSet;
	} 
	
    public nSet subtract (nSet X) {
	   // return a new nSet which is the subtraction of the current nSet by X
        nSet subtractionSet = new nSet(this.Max);
        for(int i = 0; i < this.store.length; i++){
            subtractionSet.store[i] = this.store[i] - X.store[i];
        }
        return subtractionSet;
	} 
	
    public nSet complement() {
	   // return a new nSet which is the complement of the current nSet
        nSet complementSet = new nSet(this.Max);
        for(int i = 0; i < complementSet.Max; i++){
            if(this.find(i)) {
                complementSet.add(i);
            }
        }
        for(int i = 0; i < complementSet.n_long; i++){
            complementSet.store[i] = ~complementSet.store[i];
        }
        return complementSet;
	} 
	
	public boolean equal(nSet X) {
	   // return true iff X and the current nSet contain the same set of numbers
        int length = 0;
        if(this.n_long < X.n_long) length = this.n_long;
        else length = X.n_long;
        for(int i = 0; i < length; i++){
            if(this.store[i] != X.store[i]){
                return false;
            }
        }
        return true;
	}
	
	public boolean isSubset(nSet X) {
	   // return true iff X is a subset of the current nSet
        boolean flag = false;
        int n, m;
        if(this.n_long > X.n_long){
            n = this.n_long;
            m = X.n_long;
        }
        else{
            m = this.n_long;
            n = X.n_long;
        }
        for (int i=0; i < n; i++)
        {
            for (int j = 0; j<m; j++)
            {
                if(X.store[i] == this.store[j])flag = true;
                else flag = false;
            }
        }
        return flag;
	}
	
	public int[] toArray () {
	   // return an int array which contains all the numbers in the current nSet
        int[] a = new int[this.Max];
        for(int i = 0; i < this.Max; i++){
            a[i] = (int)this.store[i];
        }
        return a;
	} 
	
	public void enumerate() {
	   // Enumerate all subsets of the current nSet and print them out.
	   // You may assume the current nSet contains less than 30 numbers.

//        int n = this.Max;
//
//        // Run a loop for printing all 2^n
//        // subsets one by one
//        for (int i = 0; i < (1<<n); i++)
//        {
//            System.out.print("{ ");
//            // Print current subset
//            for (int j = 0; j < n; j++)
//
//                if ((i & (1 << j)) > 0)
//                    System.out.print(this.store[j] + " ");
//
//            System.out.println("}");
//        }
	}

} // end of class nSet