/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {


    private ArrayList<LineSegment> segments = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        checkDuplicated(points);
        Point[] copy = Arrays.copyOf(points, points.length);
        Arrays.sort(copy);
        for (int i = 0; i < copy.length - 3; i++) {
            Arrays.sort(copy);
            Arrays.sort(copy, copy[i].slopeOrder());


            for (int p = 0, first = 1, last = 2; last < copy.length; last++) {

                while (last < copy.length && Double
                        .compare(copy[p].slopeTo(copy[first]), copy[p].slopeTo(copy[last])) == 0) {
                    last++;
                }
                if (last - first >= 3 && copy[p].compareTo(copy[first]) < 0) {
                    segments.add(new LineSegment(copy[p], copy[last - 1]));
                }
                first = last;
            }
        }
    }

    public int numberOfSegments() {
        return segments.size();
    }

    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[segments.size()]);
    }

    private void checkDuplicated(Point[] points) {
        if (points == null || points.length == 1) throw new IllegalArgumentException();
        try {
            for (int i = 0; i < points.length - 1; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    if (points[i].compareTo(points[j]) == 0)
                        throw new IllegalArgumentException("The points shoule be unique");
                }
            }
        }
        catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {

    }
}
