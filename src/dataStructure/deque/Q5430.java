package dataStructure.deque;

import java.util.*;
// stack과 queue를 이용해서 매번 뒤집으면 시간복잡도 O(n^2)-> 시간 초과, 비효율적
// 실제로 뒤집지 않고 뒤집힌 여부만 boolean 변수로 관리
// D 할 때 앞에서 뺄지 뒤에서 뺄지 결정 => deque
public class Q5430 {

    public static Deque<String> reverse(Deque<String> deque) {
        Stack<String> stack=new Stack<>();
        int size=deque.size();
        for (int i=0; i<size; i++) {
            stack.push(deque.poll());
        }
        for (int i=0; i<size; i++) {
            deque.add(stack.pop());
        }
        return deque;
    }
    public static Deque<String> delete(Deque<String> deque, boolean isReverse) {
        if (isReverse) {
            deque.pollFirst();
        }else{
            deque.pollLast();
        }
        return deque;
    }
    /*
    1 2 3 4 RRD 234 RDD  F으면 reverse해서 출력?
    디폴트 re=T
    re=F -> 뒤에서 빼기
    re=T -> 앞에서 빼기
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트의 개수
        // 입력받기
        outer:
        for (int i = 0; i < t; i++) {
            boolean isReverse=true;
            String p=sc.next();
            int n=sc.nextInt();
            String nArr=sc.next();
            nArr=nArr.substring(1,nArr.length()-1);
            // split 는 빈 문자열도 "하나의 요소"로 간주
            String[] nInt;
            if (nArr.isBlank()){
                nInt=new String[0]; // 길이가 0인 배열로 초기화
            }else{
                nInt=nArr.split(",");
            }
            Deque<String> deque=new ArrayDeque<String>();
            for (String s : nInt) {
                deque.addLast(s);
            }
            for (int j=0; j<p.length(); j++) {
                if (p.charAt(j)=='R'){
                    isReverse=!isReverse;
                    //deque=reverse(deque);
                }else if (p.charAt(j)=='D'){
                    if (deque.isEmpty()){
                        System.out.println("error");
                        continue outer;
                    }else{
                        deque=delete(deque,isReverse);
                    }
                }
            }
            // 출력하기
            if (!isReverse){
                deque=reverse(deque);
            }
            // 문자열을 +로 연결하면 새로운 문자열 객체가 계속 만들어져서 메모리, 시간 낭비
            // String s = "hello"; // 자바에서 String 불변
            // s = s + " world"; // 따라서 기존 문자열을 수정하는 게 아님

            // StringBuilder-> 내부적으로 하나의 버퍼에서 문자열을 수정해서 효율적
            StringBuilder sb=new StringBuilder();
            sb.append("[");
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
                if (!deque.isEmpty()){
                    sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb);


        }
    }
}
