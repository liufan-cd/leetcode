package person.liufan.leetcode.thousand.four.zero.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.fore.zero.three
 * @description:
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 *
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 *
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 *
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/4/29
 */
public class CanCross {
    public static void main(String[] args) {
        CanCross canCross = new CanCross();
        //System.out.println(canCross.canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(canCross.canCross(new int[]{0,1,2,3,4,8,9,11}));
    }
    public boolean canCross(int[] stones) {
        this.stones = stones;
        Set<Integer>[] sets = new Set[stones.length];
        sets[0] = new HashSet<Integer>(){{ add(0);}};
        for (int i = 0; i < sets.length; i++) {
            Set<Integer> set = sets[i];
            if (set == null) {
                continue;
            }
            for (Integer entry : set) {
                setStep(i, entry - 1, sets);
                setStep(i, entry, sets);
                setStep(i, entry + 1, sets);
            }
        }
        return sets[stones.length - 1] != null;
    }

    int[] stones;
    private void setStep(Integer nowIndex, Integer step, Set<Integer>[] sets) {
        if (step >= 1) {
            int nextPossible = stones[nowIndex] + step;
            for (int i = nowIndex + 1; i < stones.length; i++) {
                int location = stones[i];
                if (nextPossible == location) {
                    Set<Integer> set = sets[i];
                    if (set == null) {
                        set = new HashSet<>();
                        sets[i] = set;
                    }
                    set.add(step);
                }
                if (nextPossible < location) {
                    break;
                }
            }
        }
    }
}
