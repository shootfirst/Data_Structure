// class Solution {
//     public int numRescueBoats(int[] people, int limit) {
//         int left = 0, right = 0, cnt = 0, len = people.length;

//         while (right < len) {
//             if (left == right) {
//                 if (people[right] == limit) {
//                     cnt++;
//                     left++;
//                     right++;
//                 } else {
//                     right++;
//                 }
//             } else {
//                 if (people[left] + people[right] <= limit) {
//                     cnt++;
//                     right++;
//                     left = right;
//                 } else {
//                     cnt++;
//                     right++;
//                     left++;
//                 }
//             }
//         }

//         return right == left ? cnt : cnt + 1;


//     }
// }

// 上面是没有看清题目的后果，这是6个月以来第一次刷leetcode，太生疏了


class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, cnt = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit && left != right) {
                left++;
                right--;
                cnt++;
            } else if (people[left] + people[right] > limit){
                right--;
                cnt++;
            } else {
                cnt++;
                break;
            }
        }
        return cnt;



    }
}