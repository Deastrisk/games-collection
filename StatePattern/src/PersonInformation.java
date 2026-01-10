public class PersonInformation implements PrintableState {
    public void printPrintables(Person person) {
        System.out.println("Name: " + person.getName());
        System.out.println("Semester: " + person.getSemester());
        System.out.println("IPK: " + person.getIpk());
        System.out.println("Major: " + person.getMajor());
    }

    @Override
    public void handle(PrintableContext context) {
        printPrintables(context.getPerson());
        context.setState(new HelloWorld());
    }
}
