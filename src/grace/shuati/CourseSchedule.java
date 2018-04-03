package grace.shuati;
import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        Queue<Integer> queue = new LinkedList<>();
        // use a list to maintain the pres for each course
        // use 
    }
}


// loop through the int[] in pres, figure out the dependencies and add the in degree of each course in a hashmap
//        // add the course with in degree 0 to queue
//        // while queue not empty, poll the queue, and -1 from the in degree (need a hashset to store courses)
//        // compare numCourses with the res size, if <, return false
//        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
//        Queue<Integer> queue = new LinkedList<>();
//        Map<Integer, Set<Integer>> map = new HashMap<>();
//        // course[0]is the course, course[1] is prerequisite
//        for (int[] course: prerequisites) {
//            if (map.containsKey(course[0])) {
//                map.get(course[0]).add(course[1]);
//            } else {
//                Set<Integer> set = new HashSet<>();
//                set.add(course[1]);
//                map.put(course[0], set);
//            }
//        }
//
//        // add the course with no prerequisite to queue
//        for (int i = 0; i < numCourses; i++) {
//            if (!map.containsKey(i)) {
//                queue.offer(i);
//            }
//        }
//
//
//        while (!queue.isEmpty()) {
//            int course = queue.poll();
//            // find out course is the prerequisite for what courses -> remove course from these courses' arraylist
//            for (int k: map.keySet()) {
//                if (map.get(k).contains(course)) {
//                    map.get(k).remove(course);
//                }
//                if (map.get(k).isEmpty()) {
//                    queue.offer(k);
//                    map.remove(k);
//                }
//            }
//        }
//        return map.isEmpty();
//    }