public class Triangles {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	
    	Triangles t=new Triangles();
    	System.out.println(t.checkTriangleType(2147483647,10,7));
    }

    public int checkTriangleType(int side0, int side1, int side2) {
        int[] sides = new int[3];
        int scalene = 1;
        int isosceles = 2;
        int equilatera = 3;
        int error = 4;

        // If any of the sides is lesser or equal to zero than return error code
        /*if ((side0 <= 0) || (side1 <= 0) || (side2 <= 0)) {
            return error;
        }*/

        /*sides[0] = side0;
        sides[1] = side1;
        sides[2] = side2;
        int longest = sides[0];
        int longestSidePos = 0;
        
        // Finding the longest side
        for (int i = 1; i < sides.length; i++) {
        
                if (sides[i] > longest) {
                        longest = sides[i];
                        longestSidePos = i;
                }
        
        }
        
        // placing the longest side in pos 2 of sides array
        int tmp = sides[2];
        sides[2] = longest;
        if (longestSidePos != 2)
                sides[longestSidePos] = tmp;
        
        
         * If a triangle is not valid than return error code. If longest side is
         * greater or equal than the sum of the other /two sides the triangle is
         * invalid
        
        if (sides[2] >= sides[1] + sides[0]) {
                return error;
        }*/
        
        if ((side0 >= (side1 + side2)) || (side1 >= (side0 + side2)) ||
                (side2 >= (side1 + side0))) {
            return error;
        }

        // Check if triangle is equilateral;
        if ((side0 == side1) && (side1 == side2)) {
            return equilatera;
        }

        // Check if triangle is isoceles;
        if ((side0 == side1) || (side0 == side2) || (side1 == side2)) {
            return isosceles;
        }

        //else triangle is scalene
        return scalene;
    }
}
