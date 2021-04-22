package person.liufan.leetcode.thousand.hundred.forth.forth;

/**
 * @author: liufan
 * @E-mail: fan.liu@biz-united.com.cn
 * @package: person.liufan.leetcode.thousand.hundred.forth.forth
 * @description: TODO
 * @date 2021/3/31
 */
public class IsMatch {
    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
                ,"**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }

    /**
     * 思路简单，超时了
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        /**
         * 为空返回
         */
        if (s.length() == 0) {
            if (p.length() == 0) {
                return true;
            } else {
                while (true) {
                    if (p.charAt(pIndex) == '*') {
                        if (pIndex == p.length() - 1) {
                            return true;
                        } else {
                            pIndex++;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        while (sIndex < s.length() && pIndex < p.length()) {
            if (p.charAt(pIndex) == '?') {
                sIndex++;
                pIndex++;
            } else if (p.charAt(pIndex) == '*') {
                sIndex--;
                while (++sIndex < s.length()) {
                    if (p.charAt(pIndex) == '*') {
                        if (pIndex == p.length() - 1) {
                            return true;
                        } else {
                            pIndex++;
                            sIndex--;
                        }
                    } else if (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') {
                        //判断剩下的部分是否相等
                        if (isMatch(s.substring(sIndex), p.substring(pIndex))) {
                            return true;
                        }
                    }
                }
                return false;
            } else if (p.charAt(pIndex) == s.charAt(sIndex)) {
                sIndex++;
                pIndex++;
            } else {
                return false;
            }
        }
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        if (sIndex == s.length()) {
            while (true) {
                if (p.charAt(pIndex) == '*') {
                    if (pIndex == p.length() - 1) {
                        return true;
                    } else {
                        pIndex++;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
