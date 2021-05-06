package person.liufan.offer.nine;

import java.util.Stack;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.offer.nine
 * @description:
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/5/6
 */
public class CQueue {
    public static void main(String[] args) {

    }
    public CQueue() {

    }

    /**
     * 这里用静态变量出错了，估计是测试那边系统问题吧
     * 我知道了，它多次创建了对象，但是是共享的属性，卧槽，每次都是一个
     */
    private final Stack<Integer> push = new Stack<>();

    private final Stack<Integer> pop = new Stack<>();

    public void appendTail(int value) {
        push.push(value);
    }

    public int deleteHead() {
        if (pop.empty()) {
            if (!push.empty()) {
                change();
                return pop.pop();
            }
        } else {
            return pop.pop();
        }
        return -1;
    }

    private void change() {
        while (!push.empty()) {
            pop.push(push.pop());
        }
    }
}
