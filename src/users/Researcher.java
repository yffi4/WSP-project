package users;


import enums.Faculty;
import utils.Post;

import java.io.IOException;


/**
* @generated
*/

public class Researcher extends User {
    private Integer ResearcherId;

   


    public Integer getResearcherId() {
        return ResearcherId;
    }

    public void setResearcherId(Integer researcherId) {
          this.ResearcherId = researcherId;
    }

    public Researcher(String name, String lastName) {
        super(name, lastName);
    }
    public Researcher(String name, String lastName, Faculty faculty){
        super(name, lastName);

    }

    @Override
    public void update(Post p) {

    }

    @Override
    public void run() throws IOException {

    }

    @Override
    public void becomeResearcher() {


    }

    @Override
    public void deleteResearchAccount() {

    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
