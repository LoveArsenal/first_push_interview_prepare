package DynamicProgramming;

/**
 * @author Chang
 * @description 最长不重复子串，P6
 * @create 2021-05-29 8:34
 */

public class LongestString {

    public static void find(String s) {

        char[] str = s.toCharArray();

        // 不重复，记录26个字符的上次出现的位置
        int[] lastPos = new int[26];

        for (int i = 0; i < lastPos.length; i++) {

            // 一开始每个字符都没有出现
            lastPos[i] = -1;
        }

        // 0 位置结尾的子串（符合条件的）长度为1
        int maxLength = 1;

        // 记录 0 位置的字符出现的位置
        lastPos[str[0] - 'a'] = 0;

        // 从 1 位置字符开始遍历，这个lastPos就是可以往左扩充到哪里
        for (int i = 1; i < str.length; i++) {

            // 最长不重复子串长度是maxLength，求 i 的长度需要知道 i-1 的长度
            int bound = Math.max(lastPos[str[i] - 'a'], lastPos[str[i - 1] - 'a']);

            if (lastPos[str[i] - 'a'] == lastPos[str[i - 1] - 'a']) {

                maxLength = i - bound;
            }else {

                maxLength = i - bound + 1;
            }

            lastPos[str[i] - 'a'] = i;

        }

        System.out.println(maxLength);
    }

}
