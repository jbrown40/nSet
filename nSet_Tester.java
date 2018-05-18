public class nSet_Tester {
    public static void main(String[] args) {
        // testing
        nSet A = new nSet(1000);

        for (int i = 1; i<A.Max; i += i) {
            A.add(i-1);
            A.add(i);
            A.add(i+1);
        }
        System.out.println("Show A:");
        for (int i = 0; i<=A.Max; i++) {
            if (A.find(i)) System.out.println("found "+i);
        }


        nSet B = new nSet(1000);// all natural numbers <= 1000, is a power of 2
        for (int i = 1; i<B.Max; i++) {
            if((i & (i - 1)) == 0){
                B.add(i);
            }
        }
        System.out.println("Show B:");
        for (int i = 0; i<=B.Max; i++) {
            if (B.find(i)) System.out.println("found "+i);
        }

        nSet C = A.union(B);
        System.out.println("Show C:");
        for (int i = 0; i < C.Max; i++){
            if (C.find(i)) System.out.println("found "+i);
        }
        if (A.equal(C)) System.out.println("A is equal to C");
        else System.out.println("A is not equal to C");



        nSet D = A.intersect(B);
        if (B.equal(D)) System.out.println("B is equal to D");
        else System.out.println("B is not equal to D");
        System.out.println("Show D:");
        for (int i = 0; i < D.Max; i++){
            if (D.find(i)) System.out.println("found "+i);
        }

        nSet E = new nSet(1000);// all natural numbers <= 1000, and divisible by 5

        for (int i = 1; i<E.Max; i++) {
            if((i % 5) == 0){
                E.add(i);
            }

        }
        System.out.println("Show E:");
        for(int i = 0; i<E.Max; i++){
            if (E.find(i)) System.out.println("found "+i);
        }
        nSet F = A.intersect(E);
        System.out.println("Show F:");
        for(int i = 0; i<F.Max; i++){
            if (F.find(i)) System.out.println("found "+i);
        }
        if (E.equal(F)) System.out.println("B is equal to F");
        else System.out.println("B is not equal to F");

        nSet G = F.subtract(A);
        System.out.println("Show G:");
        for(int i = 0; i<G.Max; i++){
            if (G.find(i)) System.out.println("found "+i);
        }
        if (G.isEmpty()) System.out.println("G is empty");
        else System.out.println("G is not empty");

        nSet H = B.complement();
        System.out.println("Show H:");
        for(int i = 0; i<H.Max; i++){
            if (H.find(i)) System.out.println("found "+i);
        }
        System.out.println("The size of H is " + H.size());

        nSet I = H.intersect(E);
        I.enumerate();

        // print out the sizes of A, B, C, D, E, F, G, H, I
        System.out.println("The size of A is " + A.size());
        System.out.println("The size of B is " + B.size());
        System.out.println("The size of C is " + C.size());
        System.out.println("The size of D is " + D.size());
        System.out.println("The size of E is " + E.size());
        System.out.println("The size of F is " + F.size());
        System.out.println("The size of G is " + G.size());
        System.out.println("The size of H is " + H.size());
        System.out.println("The size of I is " + I.size());


    }
}