package DynamicProgramming.knacksackProblem;

/**
 * @author Chang
 * @description 01背包问题！
 * 经典的01背包问题：
 * 一个旅行者有一个最多能装M公斤的背包
 * 现在有n件物品
 * 它们的重量分别是W1、W2...Wn
 * 它们的价值分别为C1、C2...Cn
 * 求旅行者能获得最大总价值
 * @create 2021-06-25 22:19
 */
public class _01KnapsackProblem {

    public static void main(String[] args) {

        // 打表，最朴素的是建立一个N行M列的二维数组
        int[][] valueArr = new int[5][10];
        System.out.println(valueArr.length);

        int value[] = {1,3,5,9};
        int weight[] = {2,3,4,7};
        /*
        小傻子，数组默认的初始值就是0
        // 什么都不装的时候，价值都是0，也就是说第一行全是0
        for (int j = 0; j < valueArr[0].length; j++) {
            valueArr[0][j] = 0;
        }
        // 重量为0的时候，价值都是0，也就是说第一列全是0
        for (int i = 0; i < valueArr.length; i++) {
            valueArr[i][0] = 0;
        }
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 10; j++)
                System.out.print(valueArr[i][j]);
            System.out.println();
        }*/

        for(int i=1;i<valueArr.length;i++){

            for(int j=1;j<valueArr[i].length;j++){

                if(weight[i]>i){
                    // 不够拿，取上一行的结果
                    valueArr[i][j] = valueArr[i-1][j];
                }else {
                    if(j-weight[i]>0){
                        // 可以拿的下其他的
                        valueArr[i][j] = Math.max(value[i] + valueArr[i][j-weight[i]],valueArr[i-1][j]);
                    }
                    // 如果不够拿的话
                    valueArr[i][j] = Math.max(value[i],valueArr[i-1][j]);
                }
            }
        }
    }
}
