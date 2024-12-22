package menu.actions;

import Database.Database;
import users.CanSendRequests;
import users.Employee;
import utils.UserInput;

import java.util.stream.Collectors;
import java.util.Vector;
public class EmployeeActions extends CommonActions{
    private final Employee employee;

    public EmployeeActions(Employee employee) {
        super(employee);
        this.employee = employee;
    }

    public MenuAction sendMessage() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Send Message";
            }

            @Override
            public void execute() throws Exception {
                var employees = Database.DATA.getUsers().values().stream()
                        .filter(u -> u instanceof Employee)
                        .map(u -> (Employee)u)
                        .collect(Collectors.toCollection(Vector::new));

                System.out.println("Available recipients:");
                for (int i = 0; i < employees.size(); i++) {
                    if (!employees.get(i).equals(employee)) {
                        System.out.printf("%d. %s%n", i + 1, employees.get(i));
                    }
                }

                int recipientIndex = Integer.parseInt(UserInput.getText("Select recipient:")) - 1;
                String message = UserInput.getText("Enter message:");

                employee.sendMassage(message, employees.get(recipientIndex));
                System.out.println("Message sent");
            }
        };
    }

    public MenuAction sendRequest() {
        return new MenuAction() {
            @Override
            public String getDescription() {
                return "Send Request";
            }

            @Override
            public void execute() throws Exception {
                if (Database.DATA.getRector() == null) {
                    System.out.println("Rector not available");
                    return;
                }

                String request = UserInput.getText("Enter request:");
                ((CanSendRequests)employee).sendRequest(request);
                System.out.println("Request sent");
            }
        };
    }
}
