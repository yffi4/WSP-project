package utils;


import users.User;

/**
* @generated
*/
public class Request extends Post{
    private boolean isSigned;

    public Request() {
        super();
    }
    public Request(String content, User author){
        super(content, author);
    }


    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }
}

