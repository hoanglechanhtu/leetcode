   class Solution {
        class File {
            String name;
            List<File> listFile = new ArrayList<>();

            File(String name, List<File> files) {
                this.name = name;
                this.listFile = files;
            }

            File(String name) {
                this.name = name;
            }
        }

        public int lengthLongestPath(String input) {
            //Add level 0 to handle file system with file in root directory
            input = '\n' + input;
            File file = buildFileSystem(input, 0, input.length(), -1);
            int longest =  getMaxFile(file, 0);
            return longest != 0 ? longest - 1 : 0;
        }

        int getMaxFile(File file, int pathLength) {
            if (file.listFile.size() == 0 && file.name.contains(".")) return pathLength + file.name.length();
            int maxLength = 0;
            for (int i = 0; i < file.listFile.size(); i++) {
                maxLength = Math.max(maxLength, getMaxFile(file.listFile.get(i), pathLength + file.name.length() + 1));

            }

            return maxLength;
        }

        File buildFileSystem(String s, int start, int end, int level) {
            String name = getName(s, start);
            File file = new File(name);
            List<Integer> childIndex = getChild(s, start, end, level + 1);
            childIndex.add(end);
            List<File> files = new ArrayList<>();
            for (int i = 0; i < childIndex.size() - 1; i++) {
                File childFile = buildFileSystem(s, childIndex.get(i) + (level + 2) , childIndex.get(i + 1), level + 1);
                files.add(childFile);
            }
            file.listFile = files;
            return file;
        }

        String getName(String s, int index) {
            int end = index;
            while (end < s.length() && s.charAt(end) != '\n') {
                char c = s.charAt(end);
                end++;
            }
            return s.substring(index, end);
        }

        //in inclusive
        //end exclusive
        List<Integer> getChild(String s, int start, int end, int level) {
            List<Integer> childIndex = new ArrayList<>();
            for (int i = start; i < end; i++) {
                if (isChild(s, i, level)) childIndex.add(i);
            }
            return childIndex;
        }

        boolean isChild(String s, int index, int level) {
            StringBuilder builder = new StringBuilder();
            builder.append("\n");
            while (level > 0) {
                builder.append("\t");
                level--;
            }
            String child = builder.toString();

            return index + child.length() < s.length() && s.startsWith(child, index) && (index + child.length() == s.length() - 1 || s.charAt(index + child.length()) != '\t');
        }

    }
