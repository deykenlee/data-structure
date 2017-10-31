import java.lang.Math;
public class MinPath {
    public static int findMinPath(int path[][]) {
       int more = Math.max(path.length, path[0].length);
       int less = Math.min(path.length, path[0].length);
       boolean rowmore = (more == path.length);

       //时间复杂度M*N固定不变，始终将较短的一排作为数组，获得较小的空间复杂度
       int[] array = new int[less];
       array[0] = path[0][0];

       for (int i = 1; i < less; i++) {
           //如果行大于列，证明行作为滚动数组，第一次初始化时以第一行为基准，行索引不变；反之列索引不变
           array[i] = array[i-1] + (rowmore ? path[0][i] : path[i][0]);
       } 
       for (int i = 1; i < more; i++) {
           //初始化下一行的或下一列的第一个元素，若行大于列，说明列索引为0；反之行索引为0
           array[0] = array[0] + (rowmore ? path[i][0] : path[0][i]);
           for (int j = 1; j < less; j++) {
               //比较距离当前元素最近的两个元素，取最小的那个和自身相加，如果行大于列，证明行不变；反之列不变
               array[j] = Math.min(array[j-1], array[j])+ (rowmore ? path[i][j] : path[j][i]);
           }
       }
       return array[less-1];
    }

    public static void main(String args[]) {
        int[][]path = {{1,3,5,9}, {8, 1,3,4}, {5, 0, 6, 1}, {8,8,4,3}};
        System.out.print(findMinPath(path));
    }
}