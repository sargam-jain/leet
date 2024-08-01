class Solution {
    public int countSeniors(String[] details) {
        int count = 0;

        // Iterate over each passenger's details
        for (String detail : details) {
            // Extract the age substring and convert it to an integer
            int age = Integer.parseInt(detail.substring(11, 13));

            // Check if the age is greater than 60
            if (age > 60) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] details = {
            "1234567890M61A1",
            "0987654321F59B2",
            "1122334455M62C3",
            "6677889900F58D4"
        };

        int result = solution.countSeniors(details);
        System.out.println(result); // Output: 2
    }
}
