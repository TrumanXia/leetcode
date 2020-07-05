import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        boolean add = doctor.add(new Doctor());
        System.out.println(doctor);

    }
}

class Doctor extends ArrayList<Doctor> {

}
