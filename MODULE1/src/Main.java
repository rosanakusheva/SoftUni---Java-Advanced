public class Main {
    public static void main(String[] args) {

        Jar<String> jar = new Jar<>();

        jar.add("bla");
        jar.add("grr");

        System.out.println(jar.remove());

    }
}
