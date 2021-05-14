package person.liufan.common;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.common
 * @description: ListNode工具类
 * @date 2021/5/14
 */
public class ListNodeUtils {
    public static ListNode build(int[] param) {
        ListNode preHead = new ListNode();
        ListNode temp = preHead;
        for (int j : param) {
            temp.next = new ListNode(j);
            temp = temp.next;
        }
        return preHead.next;
    }
}
