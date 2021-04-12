package person.liufan.common;


/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.common
 * @description: TODO
 * @date 2021/4/6
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    @Override
    public String toString() {
        if (next != null) {
            return val + "++" + next.toString();
        }
        return ""+val;
    }
}
