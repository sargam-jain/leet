
class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> uglyNumbers = new ArrayList<>();
        uglyNumbers.add(1);
        
        int i2 = 0, i3 = 0, i5 = 0;
        
        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(uglyNumbers.get(i2) * 2, 
                                    Math.min(uglyNumbers.get(i3) * 3, uglyNumbers.get(i5) * 5));
            
            uglyNumbers.add(nextUgly);
            
            if (nextUgly == uglyNumbers.get(i2) * 2) i2++;
            if (nextUgly == uglyNumbers.get(i3) * 3) i3++;
            if (nextUgly == uglyNumbers.get(i5) * 5) i5++;
        }
        
        return uglyNumbers.get(n - 1);
    }
}
