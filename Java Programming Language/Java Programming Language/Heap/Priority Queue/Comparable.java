class Student implements Comparable<Student> {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Natural ordering: sort by name
    @Override
    public int compareTo(Student s) {
        return this.name.compareTo(s.name);
    }

    void display() {
        System.out.println(name + " - " + age);
    }
}