import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.LocalDate;
import java.util.Locale;

class Person {
    //Attributes
    private String _name;
    private String _gender;
    private LocalDate _birthday;

    //Setters (Sets attributes from accessors for encapsulation purpose)
    public void set_name(String name) {
        this._name = name;
    }

    public void set_gender(String gender) {
        this._gender = gender;
    }

    public void set_birthday(int year, int month, int day) {
        this._birthday = LocalDate.of(year, month, day);
    }

    //Getters (returns privates attributes)
    public String get_name() {
        return _name;
    }

    public String get_gender() {
        return _gender;
    }

    public LocalDate get_birthday() {
        return _birthday;
    }

    public Person(String name, String gender, String birthday) {
        this._name = name;
        this._gender = gender;

        // uu is used to format the years with two digits
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uu")
                .withResolverStyle(ResolverStyle.STRICT) // used to be sure date is strictly interpreted as calendar rules
                .withLocale(Locale.FRANCE); // format to France conventions if necessary. (Belgium uses the same as France)

        this._birthday = LocalDate.parse(birthday, formatter);
    }
}

public class AddressBookApp {
    public static void main(String[] args) {
        Person dorian = new Person("Dorian", "Male", "23/07/98");
        System.out.println(dorian.get_birthday());
        System.out.println(dorian.get_gender());
        System.out.println(dorian.get_name());
    }
}
