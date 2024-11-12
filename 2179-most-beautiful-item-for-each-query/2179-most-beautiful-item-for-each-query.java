class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,(a,b) -> Integer.compare(a[0],b[0]));
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int maxBeauty = 0;
        for(int[] item : items){
            maxBeauty = Math.max(maxBeauty,item[1]);
            map.put(item[0],maxBeauty);
        }
        int result[] = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            Integer price = map.floorKey(queries[i]);
            result[i] = (price == null) ? 0 : map.get(price);
        }
        return result;
    }
}