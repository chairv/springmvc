public class EnumClassTest {

    enum Shrubbery {GROUND, CRAWLING, HANGING}


    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s.name());
        }

        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrub);
        }
    }
}
