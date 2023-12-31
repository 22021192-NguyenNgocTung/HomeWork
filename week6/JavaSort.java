import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}
class StudentComparator implements  Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        if ( o1.getCgpa() > o2.getCgpa()){
            return 1;
        }
        else if ( o1.getCgpa() < o2.getCgpa()){
            return -1 ;
        }
        else {
            if ( o1.getFname().compareTo(o2.getFname()) < 0){
                return 1 ;
            }
            else if ( o1.getFname().compareTo(o2.getFname()) > 0){
                return -1 ;
            }
            else {
                if (o1.getId() > o2.getId()){
                    return -1 ;
                }
                else if ( o1.getId() < o2.getId()) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
//Complete the code
public class Test
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        StudentComparator sc = new StudentComparator();
        for ( int i = 0 ; i < studentList.size() ; i++){
            for ( int j = i ; j > 0 ; j--){
                if (sc.compare(studentList.get(j), studentList.get(j - 1)) > 0){
                    Student tmp = studentList.get(j) ;
                    studentList.set(j , studentList.get(j - 1)) ;
                    studentList.set(j - 1 , tmp) ;
                }
            }
        }
        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}



