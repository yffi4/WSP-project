package enums;

public enum Options {
	VIEW_STUDENTS("View list of students"),
	VIEW_COURSES("View list of courses"),
	ASSIGN_COURSE("Assign course to a teacher"),
	ADD_STUDENT("Add a new student"),
	REMOVE_STUDENT("Remove a student"),
	VIEW_PROJECTS("View research projects"),
	SEND_COMPLAINT("Send a complaint"),
	VIEW_MARKS("View marks"),
	EXIT("Exit the menu"),
	MANAGE_NEWS("Manage news articles"),
	PUBLISH_PAPER("Publish a research paper"),
	PUT_MARKS("Put marks");

	private final String description;

	// Конструктор для установки описания
	Options(String description) {
		this.description = description;
	}

	// Геттер для получения описания
	public String getDescription() {
		return description;
	}
}
