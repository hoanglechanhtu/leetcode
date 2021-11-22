    static class Node {
        Character c;
        Integer count;

        Node(Character c, Integer count) {
            this.c = c;
            this.count = count;
        }
    }

    static class Solution {
        public String candyCrush(String s) {
            //aabbbacd
            Deque<Node> stack = new ArrayDeque<>();
            char[] chars = s.toCharArray();
            int index = 0;
            while (index < chars.length) {
                if (stack.isEmpty()) {
                    Node node = new Node(chars[index], 1);
                    stack.addLast(node);
                    index++;
                } else {
                    if (stack.getLast().c == chars[index]) {
                        stack.getLast().count += 1;
                        index++;
                    } else {
                        if (stack.getLast().count >= 3) {
                            stack.removeLast();
                        } else {
                            Node node = new Node(chars[index], 1);
                            stack.addLast(node);
                            index++;
                        }
                    }
                }
            }

            if (stack.getLast().count >= 3) {
                stack.removeLast();
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                for (int i = 0; i < node.count; i++) {
                    stringBuilder.append(node.c);
                }
            }

            return stringBuilder.reverse().toString();
        }
    }
