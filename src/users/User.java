package users;

import java.awt.print.Paper;
import java.util.Vector;

import journal.Subscriber;
import utils.News;

public class User implements Subscriber, CanBecomeResearcher {
    private Integer id;
    private String email;
    private String name;
    private String lastName;
    private String password;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Make these public if you need them accessible:
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(String email, String password) {
        // TODO
        return "";
    }

    public Vector<News> ViewNews() {
        // TODO
        return null;
    }

    public void reviewPapers(Paper p) {
        // TODO
    }

    @Override
    public void becomeResearcher() {
        // TODO
    }

	@Override
	public void subscribe() {
		// TODO Auto-generated method stub
		
	}
}
