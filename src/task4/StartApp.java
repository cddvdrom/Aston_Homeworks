package task4;

import java.util.*;
import java.util.stream.Collectors;

public class StartApp {
    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN));
        StudentUtils utils = new StudentUtils();
        OptionalDouble average = utils.getAverageAgeOfManStudent(students);
        System.out.println("Список студентов :");
        utils.printListStudents(students);
        if ( average.isPresent() )
        {
            System.out.println("\nСредний возраст студентов мужского пола = " + average.getAsDouble());
        } else
        {
            System.out.println("\nСредний возраст студентов вычислить невозможно");
        }
        List<Student> studentForMilitaryService = utils.getStudentsForMilitaryService(students);
        System.out.println("\nКоличество студентов , подлежащих призыву : ");
        utils.printListStudents(studentForMilitaryService);
    }
    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        public String getName() {
            return name;
        }
        public Integer getAge() {
            return age;
        }
        public Gender getGender() {
            return gender;
        }
        @Override
        public String toString() {
            return String.format("%-20s%-10s%-10s", this.getName(), this.getAge(), this.getGender());
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return name.equals(student.name) &&
                    age.equals(student.age) &&
                    gender == student.gender;
        }
        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }
    private static class StudentUtils {
        public OptionalDouble getAverageAgeOfManStudent(Collection<Student> list) {
            return list.stream().map(Student::getAge).mapToInt(Integer::intValue).average();
        }
        public List<Student> getStudentsForMilitaryService(Collection<Student> list) {
            return list.stream().filter(x -> x.getAge() > 18 && x.getAge() < 27 && x.getGender() == Gender.MAN).
                    collect(Collectors.toList());
        }
        public void printListStudents(Collection<Student> students) {
            System.out.println("----------------------------------------");
            System.out.printf("%-20s%-10s%-10s%n", "Имя", "Возраст", "Пол");
            System.out.println("----------------------------------------");
            for (Student student : students)
            {
                System.out.println(student);
            }
            System.out.println("----------------------------------------");
        }
    }
    private enum Gender {
        MAN,
        WOMAN
    }
}
