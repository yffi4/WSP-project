package users

diagram;


/**
* @generated
*/
public class Admin extends Employee implements CanSendRequests, CanBecomeResearcher {
    
    /**
    * @generated
    */
    private Vector<String> userLogs;
    
    
    
    /**
    * @generated
    */
    private Vector<String> getUserLogs() {
        return this.userLogs;
    }
    
    /**
    * @generated
    */
    private Vector<String> setUserLogs(Vector<String> userLogs) {
        this.userLogs = userLogs;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void addUser() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public boolean removeUser() {
        //TODO
        return false;
    }
    
    /**
    * @generated
    */
    public boolean updateUser() {
        //TODO
        return false;
    }
    
    /**
    * @generated
    */
    public String viewLogs() {
        //TODO
        return "";
    }
    
    
}
