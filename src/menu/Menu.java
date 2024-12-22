package menu;

import Database.Database;
import comporators.CitationResearchPaperComparator;
import comporators.DateResearchPaperComparator;
import comporators.LengthResearchPaperComparartor;
import enums.*;
import exeptions.InvalidManagerTypeException;
import journal.Journal;
import papers.ResearchPaper;
import users.*;
import utils.Post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.stream.Collectors;

public class Menu {
    public static Runnable readNotificationsMenu = new Runnable(){
        public void runMenu(User user){
            if (user.readNotifications().size() > 0){
                System.out.println(user.readNotifications().stream().map(n->n.toString())
                        .collect(Collectors.joining("\n")));
            }else System.out.println("You don't have any notifications");
        }
    };

    public static Runnable viewNewsMenu = new Runnable() {
        @Override
        public void runMenu(User user) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            if (user.viewNews().size() > 0){
                for (int i = 0; i < user.viewNews().size(); i++){
                    System.out.println(i + 1 + " " + user.viewNews().get(i));
                }
                view: while (true){
                    System.out.println("To see comments you need select news or enter 0 to stop:");
                    int index = Integer.parseInt(br.readLine());
                    if (index == 0) break view;
                    System.out.println(user.viewNews().get(index - 1).getComments().size() > 0?user.viewNews().get(index - 1).getComments().stream().map(n-> n.toString()).collect(Collectors.joining("\n")) : "No comments was found");
                    comment: while (true){
                        System.out.println("Do you want to add a comment \n 1. Yes \n 2.No");
                        int choice = Integer.parseInt(br.readLine());
                        if (choice == 2) break comment;
                        System.out.println("Enter your comment: ");
                        String comment = br.readLine();
                        user.viewNews().get(index - 1).getComments().add(new Post(comment, user));
                        System.out.println("Comment was posted successfully");
                        break comment;
                    }
                }
            }else System.out.println("News are empty");
        }
    };

    public static Runnable printPaperMenu = new Runnable() {
        @Override
        public void runMenu(User user) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            if (Database.DATA.getResearchPapers().isEmpty()){
                System.out.println("No research paper available at the moment.");
                return;
            }
            System.out.println("Select a sorting option for the research papers:\n" +
                    "1. Alphabetically\n" +
                    "2. By length\n" +
                    "3. By number of citations\n" +
                    "4. By publication year");

            int sortOption = Integer.parseInt(br.readLine());
            Vector<ResearchPaper> paperList = user.printPapers(null);
            switch (sortOption) {
                case 2:
                    paperList = user.printPapers(new LengthResearchPaperComparartor());
                    break;
                case 3:
                    paperList = user.printPapers(new CitationResearchPaperComparator());
                    break;

                case 4:
                    paperList = user.printPapers(new DateResearchPaperComparator());
                    break;
                default:
            }
            for (int i = 0; i < paperList.size(); i++){
                ResearchPaper paper = paperList.get(i);

                if (user instanceof Researcher && paper.getAuthors().contains((Researcher) user)){
                    continue;
                }
                System.out.printf("%d. %s%n", i + 1, paper);
            }
            System.out.println("Woud you like to cite one of this papers? Enter the paper number or 0 to skip: ");
            int selectedPaper = Integer.parseInt(br.readLine());

            if (selectedPaper == 0) return;
            System.out.println("Choose citation format:\n1. Plain Text\n2. BibTeX");
            int citationFormat = Integer.parseInt(br.readLine());
            Format chosenFormat = Format.values()[citationFormat-1];

            System.out.println(paperList.get(selectedPaper - 1).getcitation(chosenFormat));

        }
    };
    public static Runnable journalMenu = new Runnable() {
        @Override
        public void runMenu(User user) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Vector<Journal> journalList = Database.DATA.getJournals();

            if (journalList.isEmpty()) {
                System.out.println("There are no journals available at the moment.");
                return;
            }

            while (true) {
                System.out.println("Select a journal to subscribe/unsubscribe (enter 0 to exit):");

                for (int i = 0; i < journalList.size(); i++) {
                    Journal journal = journalList.get(i);
                    String status = journal.getSubscribers().contains(user) ? "ok" : "";
                    System.out.printf("%d) %s %s%n", i + 1, journal, status);
                }

                try {
                    int selectedIndex = Integer.parseInt(reader.readLine());

                    if (selectedIndex == 0) {
                        System.out.println("Exiting journal management.");
                        break;
                    }

                    Journal selectedJournal = journalList.get(selectedIndex - 1);

                    if (selectedJournal.getSubscribers().contains(user)) {
                        user.unsubscribe(selectedJournal);
                        System.out.printf("You have unsubscribed from %s.%n", selectedJournal);
                    } else {
                        user.subscribe(selectedJournal);
                        System.out.printf("You have subscribed to %s.%n", selectedJournal);
                    }
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Invalid input. Please enter a valid journal number.");
                }
            }

        }
    };
    public static Runnable sendMessageMenu = new Runnable() {
        public void runMenu(User user) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Employee employee = (Employee)user;
            Vector<Employee> employees = Database.DATA.getUsers().values().stream()
                    .filter(n->(n instanceof Employee)).map(n->(Employee)n).collect(Collectors.toCollection(Vector<Employee>::new));
            System.out.println("Select employee:");
            for(int i = 0; i < employees.size(); i++) {
                if(employees.get(i).equals(employee)) {continue;}
                System.out.println(i+1 + " " + employees.get(i));
            }
            int empId = Integer.parseInt(br.readLine());
            System.out.println("Enter you message:");
            String message = br.readLine();
            employee.sendMassage(message, employees.get(empId-1));
            System.out.println("Message was sent successfully");
        }
    };

    public static Runnable sendRequestMenu = new Runnable() {
        @Override
        public void runMenu(User user) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            if (Database.DATA.getRector() == null){
                System.out.println("Rector is not available");
                return;
            }
            CanSendRequests canSendRequests = (CanSendRequests)user;
            System.out.println("Enter the request: ");
            String request = br.readLine();
            canSendRequests.sendRequest(request);
            System.out.println("Request was sent successfully");
        }
    };

    public static Runnable addUserMenu = new Runnable() {
        @Override
        public void runMenu(User user) throws IOException, InvalidManagerTypeException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Admin admin = (Admin)user;
            System.out.print("Enter the new user's first name: ");
            String givenName = br.readLine();

            System.out.print("Enter the new user's last name: ");
            String surname = br.readLine();

            System.out.println("Select the role for the new user:\n" +
                    "1. Dean\n" +
                    "2. Manager\n" +
                    "3. Tech Support\n" +
                    "4. Master Student\n" +
                    "5. PhD Student\n" +
                    "6. Student\n" +
                    "7. Researcher\n" +
                    "8. Teacher");

            int roleSelection = Integer.parseInt(br.readLine());
            UserType role = UserType.values()[roleSelection - 1];

            if (role == UserType.STUDENT || role == UserType.PHD || role == UserType.MASTER || role == UserType.RESEARCHER || role == UserType.TEACHER) {
                System.out.println("Assign a faculty for the user:");
                System.out.println("Available Faculties: 1.SITE 2.BS 3.SAM 4.SEPI 5.SG 6.SMSGT 7.SCE 8.ISE 9.KMA");

                int facultySelection = Integer.parseInt(br.readLine());
                Faculty faculty = Faculty.values()[facultySelection - 1];

                if (role != UserType.TEACHER) {
                    admin.addUser(givenName, surname, role, faculty);
                    System.out.println("User added successfully!");
                    return;
                }

                System.out.println("Select the teacher type for the new user:\n" +
                        "1. PROFESSOR\n" +
                        "2. TUTOR\n" +
                        "3. LECTOR\n" +
                        "4. SENIOR_LECTURER");

                int teacherTypeSelection = Integer.parseInt(br.readLine());
                TeacherType teacherRole = TeacherType.values()[teacherTypeSelection - 1];

                admin.addUser(givenName, surname, faculty, teacherRole);
                System.out.println("Teacher added successfully!");

            } else if (role == UserType.MANAGER) {
                System.out.println("Choose the type of manager:\n" +
                        "1. OR Manager\n" +
                        "2. Department Manager");

                int managerType = Integer.parseInt(br.readLine());
                ManagerType managerRole = ManagerType.values()[managerType - 1];

                admin.addUser(givenName, surname, managerRole);
                System.out.println("Manager added successfully!");
            } else {
                admin.addUser(givenName, surname, role);
                System.out.println("User added successfully!");
            }

        }
    };

    public static Runnable removeUserMenu = new Runnable() {
        @Override
        public void runMenu(User user) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Admin admin = (Admin) user;
            System.out.println("Enter username of the user to remove him");
            String username = br.readLine();
            admin.removeUser(username);
            System.out.println("User removed successfully");
        }
    };

    public static Runnable logFilesMenu = new Runnable() {
        @Override
        public void runMenu(User user) throws IOException{
            Admin admin = (Admin) user;
            System.out.println(admin.viewLogs());
        }
    };







    public static Runnable adminMenu[] = {viewNewsMenu, readNotificationsMenu, printPaperMenu, journalMenu,
            sendMessageMenu, sendRequestMenu,  addUserMenu, removeUserMenu, logFilesMenu};

}
