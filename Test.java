import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] student_marks = {{66, 61, 88, 26, 13}, {52, 38, 7, 74, 62}};
        String grades[] = calculateGrade(student_marks);
        for (String g : grades) {
            System.out.println(g);
        }

    }

    static String[] calculateGrade(int[][] student_marks) {

        String[] grades = new String[student_marks.length];

        for (int i = 0; i < student_marks.length; i++) {
            int sum = 0;
            for (int j = 0; j < student_marks[i].length; j++) {
                sum += student_marks[i][j];
            }
            double avg = sum/student_marks[i].length;

            String grade = "F";

            if(avg >= 90)
                grade = "A+";
            else if(avg >= 80) 
                grade = "A";
            else if(avg >= 70) 
                grade = "B";
            else if(avg >= 60) 
                grade = "C";
            else if(avg >= 50) 
                grade = "D";

            grades[i] = grade;
            System.out.println(avg);
        }

        return grades;
    }
}
