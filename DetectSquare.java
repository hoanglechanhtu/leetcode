//TLE
class DetectSquares {
        class Line {
            int[] x;
            int[] y;

            Line(int[] x, int[] y) {
                this.x = x;
                this.y = y;
            }
        }

        class Point {
            int x;
            int y;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int hashCode() {
                return x * 1000 + y * 1000;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == this) return true;
                if (obj.getClass() != this.getClass()) return false;
                Point other = (Point) obj;
                return other.x   == x && other.y == y;
            }
        }


        List<int[]> points = new ArrayList<>();
        List<Line> lines = new ArrayList<>();
        Map<Point, Integer> pointsToFormSquare = new HashMap<>();

        public DetectSquares() {

        }

        public void add(int[] point) {
            for (int i = 0; i < lines.size(); i++) {
                int[] pointToFormSquare = getSquare(lines.get(i), point);
                if (pointToFormSquare != null)
                    pointsToFormSquare.merge(new Point(pointToFormSquare[0], pointToFormSquare[1]), 1, Integer::sum);
            }

            for (int i = 0; i < points.size(); i++) {
                if (isLine(point, points.get(i))) lines.add(new Line(point, points.get(i)));
            }

            points.add(point);

        }

        public int count(int[] point) {
            Point key = new Point(point[0], point[1]);
            if (pointsToFormSquare.containsKey(key)) return pointsToFormSquare.get(key);
            return 0;
        }


        int[] getSquare(Line line, int[] point) {
            if (line.x[0] != line.y[0] && line.x[1] != line.y[1]) {
                if (point[0] == line.x[0] && point[1] == line.y[1] && Math.abs(point[0] - line.y[0]) == Math.abs(point[1] - line.x[1])) {
                    return new int[]{line.y[0], line.x[1]};
                } else if (point[0] == line.y[0] && point[1] == line.x[1] && Math.abs(point[0] - line.x[0]) == Math.abs(point[1] - line.y[1])) {
                    return new int[]{line.x[0], line.y[1]};
                }

                return null;
            }


            int distance = Math.abs(line.x[0] - line.y[0]) + Math.abs(line.x[1] - line.y[1]);
            if (line.x[0] == line.y[0]) {
                if (point[1] == line.x[1] && Math.abs(point[0] - line.x[0]) == distance) {
                    return new int[]{line.y[0] + point[0] - line.x[0], line.y[1]};
                } else if (point[1] == line.y[1] && Math.abs(point[0] - line.y[0]) == distance) {
                    return new int[]{line.x[0] + point[0] - line.y[0], line.x[1]};
                }
            } else if (line.x[1] == line.y[1]) {
                if (point[0] == line.x[0] && Math.abs(point[1] - line.x[1]) == distance) {
                    return new int[]{line.y[0], line.y[1] + point[1] - line.x[1]};
                } else if (point[0] == line.y[0] && Math.abs(point[1] - line.y[1]) == distance) {
                    return new int[]{line.x[0], line.x[1] + point[1] - line.y[1]};
                }
            }

            return null;
        }

        boolean isLine(int[] x, int[] y) {
            if (x[0] != y[0] || x[1] != y[1]) return true;
            return false;
        }
    }
}



class DetectSquares {
    
    class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (o.getClass() != this.getClass()) return false;
            Point other = (Point) o;
            return other.x == this.x && other.y == this.y;
        }
        
        @Override 
        public int hashCode(){
            return x * 100000+ y;
        }
    }
    
    Map<Integer, List<Integer>> xToY = new HashMap<>();
    Map<Point, Integer> count = new HashMap<>();
    public DetectSquares() {
        
    }
    
    public void add(int[] point) {
        if (xToY.containsKey(point[0])) xToY.get(point[0]).add(point[1]);
        else {
            List<Integer> list = new ArrayList<>();
            list.add(point[1]);
            xToY.put(point[0], list);
        }
        
        count.merge(new Point(point[0], point[1]), 1, Integer::sum);
    }
    
    public int count(int[] point) {
        List<Integer> listY = xToY.get(point[0]);
        int total = 0;
        if (listY == null) return total;
        for (int i = 0; i < listY.size(); i ++) {
            if (listY.get(i) != point[1]) {
                int dis = Math.abs(listY.get(i) - point[1]);
                //left side
                total += count.getOrDefault(new Point(point[0] - dis, point[1]) ,0) * count.getOrDefault(new Point(point[0] - dis, listY.get(i)), 0);
                //right side
                total += count.getOrDefault(new Point(point[0] + dis, point[1]) ,0) * count.getOrDefault(new Point(point[0] + dis, listY.get(i)), 0);
            }
        }
        return total;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */



