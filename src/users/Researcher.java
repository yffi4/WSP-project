package users;


import utils.Post;




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

    @Override
    public void update(Post p) {

    }

    @Override
    public void becomeResearcher() {


    }
}
