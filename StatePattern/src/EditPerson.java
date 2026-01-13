public class EditPerson implements PrintableState {
    String name;
    String major;
    float ipk;
    int semester;

    public void printPrintables(Person person) {
        System.out.print("New name: ");
        name = App.scanner.nextLine();
        System.out.print("New semester: ");
        semester = App.scanner.nextInt();
        App.scanner.nextLine();
        System.out.print("New major: ");
        major = App.scanner.nextLine();
        System.out.print("New ipk: ");
        ipk = App.scanner.nextFloat();
    }

    public PrintableState handleInput(Person person) {
        person.setIpk(ipk);
        person.setMajor(major);
        person.setName(name);
        person.setSemester(semester);

        return new PersonInformation();
    }

    @Override
    public void handle(PrintableContext context) {
        printPrintables(context.getPerson());
        context.setState(handleInput(context.getPerson()));
    }
}
